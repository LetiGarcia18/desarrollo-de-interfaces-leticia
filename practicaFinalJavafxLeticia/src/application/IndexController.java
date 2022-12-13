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
/**
 * Clase que representa la funcionalidad de la interfaz gráfica del programa
 * @author Leticia
 *
 */
public class IndexController {

	/**
	 * Variable de tipo TextField que representa el texto del nombre en la interfaz
	 */
	@FXML
	private TextField txtNombre;
	/**
	 * Variable de tipo TextField que representa el texto del habitat en la interfaz
	 */
	@FXML
	private TextField txtHabitat;
	/**
	 * Variable de tipo ChoiceBox que representa el ChoiceBox de si es peligrosa o no la raza en la interfaz
	 */
	@FXML
	private ChoiceBox chbPeligrosa;
	/**
	 * Variable de tipo TableView<Raza> que representa la tabla donde están los datos de la raza
	 */
	@FXML
	private TableView<Raza> tableRazas;
	/**
	 * Variable de tipo TableColumn<Raza, String> que representa la columna de la tabla donde está el nombre de la raza
	 */
	@FXML
	private TableColumn<Raza, String> columNombre;
	/**
	 * Variable de tipo TableColumn<Raza, String> que representa la columna de la tabla donde está el habitat de la raza
	 */
	@FXML
	private TableColumn<Raza, String> columHabitat;
	/**
	 * Variable de tipo TableColumn<Raza, String> que representa la columna de la tabla donde está es peligrosa o no la raza
	 */
	@FXML
	private TableColumn<Raza, Boolean> columPeligrosa;
	/**
	 * Variable de tipo Button que representa el botón de añadir datos en la base de datos.
	 */
	@FXML
	private Button btAniadir;
	/**
	 * Variable de tipo Button que representa el botón de borrar datos en la base de datos.
	 */
	@FXML
	private Button btBorrar;
	/**
	 * Variable de tipo ObservableList<Raza> que representa la lista de las razas
	 */
	private ObservableList<Raza> listaRazas = FXCollections.observableArrayList();
	
	/**
	 * Variable de tipo ObservableList<Raza> que representa la lista de las si las razas son peligrosas o no
	 */
	public ObservableList<Boolean> listaPeligrosa = FXCollections.observableArrayList(true, false);

	/**
	 * Función que inicializa todas las funciones de la interfaz gráfica. No devuelve nada
	 */
	@FXML
	private void initialize() {
		chbPeligrosa.setItems(listaPeligrosa); 

		columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columHabitat.setCellValueFactory(new PropertyValueFactory<>("habitat"));
		columPeligrosa.setCellValueFactory(new PropertyValueFactory<>("esPeligrosa"));

		tableRazas.setItems(listaRazas);

		// Almacenamos en esta variable la lista de libros de la BD
		ObservableList listaRazasBD = getRazasBD();

		tableRazas.setItems(listaRazasBD);
	}

	/**
	 * Función que te devuelve una lista con las razas almacenadas en la base de datos.
	 * @return Una lista con las razas almacenadas en la base de datos.
	 */
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

	/**
	 * Función que añade una raza en la base de datos
	 * @param event Variable de tipo ActionEvent que dispara el evento.
	 */
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
			
			
			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection connection = dbConnection.getConnection();

			try {
				
				String query = "insert into razas " + "(nombre, habitat, esPeligrosa) " + "VALUES (?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, raza.getNombre());
				ps.setString(2, raza.getHabitat());
				ps.setBoolean(3, raza.isEsPeligrosa());
				ps.executeUpdate();

				
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ObservableList listaRazasBD = getRazasBD();
			tableRazas.setItems(listaRazasBD);

		}
	}

	/**
	 * Función que elimina una raza de la base de datos
	 * @param event Variable de tipo ActionEvent que dispara el evento.
	 */
	@FXML
	public void borrarRaza(ActionEvent event) {

		int indiceSeleccionado = tableRazas.getSelectionModel().getSelectedIndex();
		System.out.println("Indice a borrar: " + indiceSeleccionado);
		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha podido borrar el elemento");
			alerta.setContentText("Por favor, seleccione el elemento que quiere borrar");
			alerta.showAndWait();
		} else {
			
			DatabaseConnection bdConnection = new DatabaseConnection();
			Connection connection = bdConnection.getConnection();

			try {
				String query = "delete from razas where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Raza raza = tableRazas.getSelectionModel().getSelectedItem();
				ps.setInt(1, raza.getId());
				ps.executeUpdate();

				tableRazas.getSelectionModel().clearSelection();

				ObservableList listaRazasBD = getRazasBD();

				tableRazas.setItems(listaRazasBD);

				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
