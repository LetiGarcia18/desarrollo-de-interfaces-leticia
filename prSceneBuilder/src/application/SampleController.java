package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	
	@FXML
	private TextField textoMensaje;
	
	@FXML
	private Button botonMensaje;
	
	@FXML
	private Label labelMensaje;
	
	@FXML
	public void mostrarMensaje(ActionEvent event) {
		labelMensaje.setText(textoMensaje.getText()); //De esta manera cogemos el texto que se ha introducido en el TextField
	}
}
