package application;

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
	private ObservableList<Videojuego> listaVideojuegos = FXCollections.observableArrayList(new Videojuego("Zelda Breath of the Wild", 50f, "Nintendo Switch", "12"));

	@FXML
	public ObservableList<String> listaConsolas = FXCollections.observableArrayList("Nintendo Switch", "PlayStation","Nintendo DS", "PC", "Gameboy Color");
	
	@FXML
	public ObservableList<String> listaPegis = FXCollections.observableArrayList("3", "12","18");
	
	@FXML
	private void initialize() {
		chbConsola.setItems(listaConsolas);
		chbPegi.setItems(listaPegis);
		columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
		  
		tableVideojuegos.setItems(listaVideojuegos);
	}
	
	@FXML
	public void aniadirVideojuego(ActionEvent event) {
		
		if(txtNombre.getText().isEmpty() || !txtPrecio.getText().isEmpty() || !chbConsola.getSelectionModel().isEmpty() || !chbPegi.getSelectionModel().isEmpty()){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del videojuego");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();

			txtNombre.clear();
			txtPrecio.clear();
			chbConsola.getSelectionModel().clearSelection();
			chbPegi.getSelectionModel().clearSelection(); 
		
		
		}else if (!esNumero(txtPrecio.getText())) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al insertar");
			alerta.setHeaderText("No se ha introducido un número en el precio");
			alerta.setContentText("Por favor, introduzca un número en el campo del precio");
			alerta.showAndWait(); 
			
		}else {
    		Videojuego videojuego = new Videojuego(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()), chbConsola.getValue().toString(), chbPegi.getValue().toString());
    		listaVideojuegos.add(videojuego);
            txtNombre.clear();
			txtPrecio.clear();
			chbConsola.getSelectionModel().clearSelection();
			chbPegi.getSelectionModel().clearSelection();
		}
	}	
	
	
	public void borrarVideojuego(ActionEvent event) {

		int indiceSeleccionado = tableVideojuegos.getSelectionModel().getSelectedIndex();
		tableVideojuegos.getItems().remove(indiceSeleccionado);

	}
	
	
	private static boolean esNumero(String cadena){
		try {
			Float.parseFloat(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	
	
}
