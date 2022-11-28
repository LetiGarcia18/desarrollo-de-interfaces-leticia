package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
		
		Videojuego videojuego = new Videojuego(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()), chbConsola.getValue().toString(), chbPegi.getValue().toString());
		
		
		if(isNumeric(txtPrecio.getText())) {
			listaVideojuegos.add(videojuego);
			
			txtNombre.clear();
			txtPrecio.clear();
			chbConsola.getSelectionModel().clearSelection();
			chbPegi.getSelectionModel().clearSelection();
		}
		
		
		
		
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Float.parseFloat(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	
	
}
