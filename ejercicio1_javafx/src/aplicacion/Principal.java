package aplicacion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application{

	@Override
	public void start(Stage primaryStage){
		BorderPane panel = new BorderPane();
		Label labelNombre = new Label("H");
		Label labelContrasenia = new Label("F");
		labelNombre.setAlignment(Pos.TOP_LEFT);
		labelContrasenia.setAlignment(Pos.TOP_RIGHT);
		panel.setCenter(labelContrasenia);
		
		
		Scene scene = new Scene(panel,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
