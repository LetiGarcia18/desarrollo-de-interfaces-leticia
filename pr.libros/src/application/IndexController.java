package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
}
