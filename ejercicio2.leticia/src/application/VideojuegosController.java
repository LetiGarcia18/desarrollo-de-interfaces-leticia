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

public class VideojuegosController {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPrecio;

	@FXML
	private ChoiceBox chbConsola;

	@FXML
	private ChoiceBox chbPegi;

	@FXML
	private TableView<Videojuego> tableVideojuegos;

	@FXML
	private TableColumn<Videojuego, String> columNombre;

	@FXML
	private TableColumn<Videojuego, Float> columPrecio;

	@FXML
	private TableColumn<Videojuego, String> columConsola;

	@FXML
	private TableColumn<Videojuego, Integer> columPegi;

	@FXML
	private Button btAniadir;

	@FXML
	private Button btBorrar;

	@FXML
	private ObservableList<Videojuego> listaVideojuegos = FXCollections
			.observableArrayList(new Videojuego("Zelda Breath of the Wild", 50f, "Nintendo Switch", "12"));

	@FXML
	public ObservableList<String> listaConsolas = FXCollections.observableArrayList("Nintendo Switch", "PlayStation",
			"Nintendo DS", "PC", "Gameboy Color");

	@FXML
	public ObservableList<String> listaPegis = FXCollections.observableArrayList("3", "12", "18");

	@FXML
	private void initialize() {
		chbConsola.setItems(listaConsolas);
		chbPegi.setItems(listaPegis);
		columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
		
		//Almacenamos en esta variable la lista de libros de la BD
		ObservableList listaVideojuegosBD = getVideojuegosBD();

		tableVideojuegos.setItems(listaVideojuegosBD);
	}

	private ObservableList<Videojuego> getVideojuegosBD() {

		// Creamos la ObservableList donde almacenaremos los libros obtenidos de la BD
		ObservableList<Videojuego> listaVideojuegosBD = FXCollections.observableArrayList();

		// Nos conectamos a la BD
		DatabaseConnection bdConnection = new DatabaseConnection();
		Connection connection = bdConnection.getConnection();

		String query = "select * from videojuegos";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego videojuego = new Videojuego(rs.getInt("id"), rs.getString("nombre"), (float) rs.getFloat("precio"), rs.getString("consola"),
						rs.getInt("pegi")+"");
				listaVideojuegosBD.add(videojuego);
			}

			// cerramos la conexion
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaVideojuegosBD;
	}

	@FXML
	public void aniadirVideojuego(ActionEvent event) {

		if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || chbConsola.getSelectionModel().isEmpty()
				|| chbPegi.getSelectionModel().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del videojuego");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();

			txtNombre.clear();
			txtPrecio.clear();
			chbConsola.getSelectionModel().clearSelection();
			chbPegi.getSelectionModel().clearSelection();

		} else if (!esNumero(txtPrecio.getText())) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al insertar");
			alerta.setHeaderText("No se ha introducido un número en el precio");
			alerta.setContentText("Por favor, introduzca un número en el campo del precio");
			alerta.showAndWait();

		} else {
			Videojuego videojuego = new Videojuego(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()),
					chbConsola.getValue().toString(), chbPegi.getValue().toString());
			listaVideojuegos.add(videojuego);
			txtNombre.clear();
			txtPrecio.clear();
			chbConsola.getSelectionModel().clearSelection();
			chbPegi.getSelectionModel().clearSelection();
			
			//Nos conectamos a la BD
			DatabaseConnection bdConnection = new DatabaseConnection();
			Connection connection = bdConnection.getConnection();
			
			
			try {
				//Aquí insertamos en la bbdd
				String query = "insert into videojuegos (nombre, precio, consola, pegi) values (?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, videojuego.getNombre());
				ps.setFloat(2, videojuego.getPrecio());
				ps.setString(3, videojuego.getConsola());
				ps.setString(4, videojuego.getPegi());
				ps.executeUpdate();
				
						
				
				//Cerramos la sesión
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Después de insertar actualizamos la tabla
			ObservableList listaVideojuegosBD = getVideojuegosBD();

			tableVideojuegos.setItems(listaVideojuegosBD);
			
		}
		
		
	}

	public void borrarVideojuego(ActionEvent event) {

		int indiceSeleccionado = tableVideojuegos.getSelectionModel().getSelectedIndex();
		if (indiceSeleccionado <= -1) {
			// Alerta error
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha podido borrar el elemento");
			alerta.setContentText("Por favor, seleccione el elemento que quiere borrar");
			alerta.showAndWait();
		} else {
			//tableVideojuegos.getItems().remove(indiceSeleccionado);
			//tableVideojuegos.getSelectionModel().clearSelection();
			
			//Nos conectamos a la BD
			DatabaseConnection bdConnection = new DatabaseConnection();
			Connection connection = bdConnection.getConnection();
			
			
			try {
				//Aqui borramos los datos
				String query = "delete from videojuegos where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Videojuego videojuego = tableVideojuegos.getSelectionModel().getSelectedItem();
				ps.setInt(1, videojuego.getId());
				ps.executeUpdate();
				
				tableVideojuegos.getSelectionModel().clearSelection();
				
				//Después de insertar actualizamos la tabla
				ObservableList listaLibrosBD = getVideojuegosBD();

				tableVideojuegos.setItems(listaLibrosBD);
				
				//Cerramos la conexion
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static boolean esNumero(String cadena) {
		try {
			Float.parseFloat(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
