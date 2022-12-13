package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Clase principal de la práctica final de JavaFx
 * @author Leticia
 *
 */
public class Main extends Application {
	/**
	 * Función que inicia y hace visible la ventana de la interfaz gráfica
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Index.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Las razas del mundo");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image("/application/cat.png"));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Función que lanza el programa
	 * @param args Sin uso
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

