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

public class IndexController {
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private ChoiceBox chbEditorial;
	
	@FXML
	private TextField txtAutor;
	
	@FXML
	private TextField txtPaginas;
	
	@FXML
	private TableView<Libro> tableLibros;
	
	@FXML
	private TableColumn<Libro, String> columTitulo;
	
	@FXML
	private TableColumn<Libro, String> columEditorial;
	
	@FXML
	private TableColumn<Libro, String> columAutor;
	
	@FXML
	private TableColumn<Libro, Integer> columPaginas;
	
	@FXML
	private Button btAniadir;
	
	private ObservableList<Libro> listaLibros = FXCollections.observableArrayList(new Libro("La Biblia", "Planeta", "Jesús", 500));
	
	//ObservableList --> Refleja los cambios en tiempo real, ya que al modificar esa lista, se cambia todo automaticamente en tiempo real.
	public ObservableList<String> listaEditoriales = FXCollections.observableArrayList("Planeta", "Altaya","Kadokawa","Penguin Libros");
	
	@FXML
	private void initialize() {
		chbEditorial.setItems(listaEditoriales); //Cuando arranque la aplicación, al ChoiceBox le va a meter la lista de editoriales
		
		columTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));
		  
		tableLibros.setItems(listaLibros);
	}
	
	@FXML 
	public void aniadirLibro(ActionEvent event) {
		
		Libro libro = new Libro(txtTitulo.getText(), chbEditorial.getValue().toString(), txtAutor.getText(), Integer.parseInt(txtPaginas.getText()));
		
		if(isNumeric(txtPaginas.getText())) {
			listaLibros.add(libro);
			
			txtTitulo.clear();
			chbEditorial.getSelectionModel().clearSelection(); //Borra la seleccion
			txtAutor.clear();
			txtPaginas.clear();
		}
		
		
		
	}
	
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	@FXML 
	public void borrarLibro(ActionEvent event) {
		System.out.println("Borrando libro");
	}
}
