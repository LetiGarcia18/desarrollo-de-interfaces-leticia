package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndexController {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtHabitat;

	@FXML
	private ChoiceBox chbPeligrosa;

	@FXML
	private TableView<Raza> tableRazas;

	@FXML
	private TableColumn<Raza, String> columNombre;

	@FXML
	private TableColumn<Raza, String> columHabitat;

	@FXML
	private TableColumn<Raza, Boolean> columPeligrosa;

	@FXML
	private Button btAniadir;

	@FXML
	private Button btBorrar;

	private ObservableList<Raza> listaRazas = FXCollections.observableArrayList();

	// ObservableList --> Refleja los cambios en tiempo real, ya que al modificar
	// esa lista, se cambia todo automaticamente en tiempo real.
	public ObservableList<Boolean> listaPeligrosa = FXCollections.observableArrayList(true, false);

	@FXML
	private void initialize() {
		chbPeligrosa.setItems(listaPeligrosa); // Cuando arranque la aplicación, al ChoiceBox le va a meter la lista
												// de editoriales

		columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columHabitat.setCellValueFactory(new PropertyValueFactory<>("habitat"));
		columPeligrosa.setCellValueFactory(new PropertyValueFactory<>("esPeligrosa"));

		tableRazas.setItems(listaRazas);

		// Almacenamos en esta variable la lista de libros de la BD
		ObservableList listaRazasBD = getRazasBD();

		tableRazas.setItems(listaRazasBD);
	}

	private ObservableList<Raza> getRazasBD() {

		// Creamos la ObservableList donde almacenaremos los libros obtenidos de la BD
		ObservableList<Raza> listaRazasBD = FXCollections.observableArrayList();

		// Nos conectamos a la BD
		DatabaseConnection bdConnection = new DatabaseConnection();
		Connection connection = bdConnection.getConnection();

		String query = "select * from razas";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Raza raza = new Raza(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getBoolean("esPeligrosa"));
				listaRazasBD.add(raza);
			}

			// cerramos la conexion
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaRazasBD;
	}

	@FXML
	public void anadirRaza(ActionEvent event) {

		if (txtNombre.getText().isEmpty() || chbPeligrosa.getSelectionModel().isEmpty()
				|| txtHabitat.getText().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información de la raza");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();

		} else {
			Raza raza = new Raza(
					txtNombre.getText(),
					txtHabitat.getText(),
					(boolean) chbPeligrosa.getValue());
			
			txtNombre.clear();
			chbPeligrosa.getSelectionModel().clearSelection();
			txtHabitat.clear();
			
			// Nos conectamos a la BD
			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection connection = dbConnection.getConnection();

			try {
				// Aquí insertaremos en la BD
				String query = "insert into razas " + "(nombre, habitat, esPeligrosa) " + "VALUES (?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, raza.getNombre());
				ps.setString(2, raza.getHabitat());
				ps.setBoolean(3, raza.isEsPeligrosa());
				ps.executeUpdate();

				// Cerramos la sesión
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Después de insertar actualizamos la tabla
			ObservableList listaRazasBD = getRazasBD();
			tableRazas.setItems(listaRazasBD);

		}
	}

	@FXML
	public void borrarLibro(ActionEvent event) {

		int indiceSeleccionado = tableRazas.getSelectionModel().getSelectedIndex();
		System.out.println("Indice a borrar: " + indiceSeleccionado);
		if (indiceSeleccionado <= -1) {
			// Alerta error
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha podido borrar el elemento");
			alerta.setContentText("Por favor, seleccione el elemento que quiere borrar");
			alerta.showAndWait();
		} else {
			// tableLibros.getItems().remove(indiceSeleccionado);
			// tableLibros.getSelectionModel().clearSelection();

			// Nos conectamos a la BD
			DatabaseConnection bdConnection = new DatabaseConnection();
			Connection connection = bdConnection.getConnection();

			try {
				// Aqui borramos los datos
				String query = "delete from razas where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Raza raza = tableRazas.getSelectionModel().getSelectedItem();
				ps.setInt(1, raza.getId());
				ps.executeUpdate();

				tableRazas.getSelectionModel().clearSelection();

				// Después de insertar actualizamos la tabla
				ObservableList listaRazasBD = getRazasBD();

				tableRazas.setItems(listaRazasBD);

				// Cerramos la conexion
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
