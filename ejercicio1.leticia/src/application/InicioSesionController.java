package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionController {
	
	@FXML
	private Label labelNombre;
	
	@FXML
	private TextField textoNombre;
	
	@FXML
	private Label labelContrasenia;
	
	@FXML
	private PasswordField passField;
	
	@FXML
	private Button entrarBoton;
	
	@FXML
	private Label labelBienvenido;
	
	@FXML
	public void mostrarMensaje(ActionEvent event) {
		String nombre = textoNombre.getText();
		textoNombre.clear();
		passField.clear();
		labelBienvenido.setText("Bienvenido " + nombre);
		
	}
	
	
}
