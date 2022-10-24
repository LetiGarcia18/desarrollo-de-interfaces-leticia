package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//STACK PANEL
			/*BorderPane root = new BorderPane(); //Aqu� est� creado un panel que tiene centro, izq, derecha, arriba y abajo. Est� vac�o.
			Scene scene = new Scene(root,700,400); //Se crea una escena donde se le asigna un panel principal, y el tama�o en p�xeles de la pantalla.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //Le mete un css
			primaryStage.setScene(scene);//En el escenario, ponemos la escena que se quiera. 
			primaryStage.show(); //Lo muestra al ejecutarlo.
			
			Button btn = new Button("Clic aqu�"); //Creamos un bot�n
			btn.setOnAction(new EventHandler<ActionEvent>(){ //Le a�adimos un evento al bot�n. Al clicar nos dir� ese mensaje por consola
				public void handle(ActionEvent event) {
					System.out.println("Hola mundo");
				}
			});
			
			Label lbl = new Label("�Hola mundo!");
			//Creamos un panel principal:
			StackPane panel = new StackPane();
			panel.setAlignment(lbl, Pos.TOP_CENTER);
			panel.setAlignment(btn, Pos.CENTER);
			panel.getChildren().addAll(lbl, btn);*/
			
			//Fin StackPanel--------------------------------------------------------------------------------------------------
			
			
			//VBox: Es una caja en vertical
			/*Button b1 = new Button ("Bot�n 1");
			Button b2 = new Button ("Bot�n 2");
			Button b3 = new Button ("Bot�n 3");
			
			VBox panel = new VBox(15); //Lo que le pasamos por par�metros al vBox, es la separaci�n que va a haber entre sus elementos.
			panel.setPadding(new Insets(15)); //Le pone margen al rededor del panel.
			panel.getChildren().addAll(b1,b2,b3);*/
			
			//Fin del VBox-------------------------------------------------------------------------------------------------
			
			//HBox: es una caja horizontal
			//HBox panel = new HBox(15); //Lo que le pasamos por par�metros al vBox, es la separaci�n que va a haber entre sus elementos.
			
			//Fin del HBox ---------------------------------------------------------------------------------------------------
			
			//BORDERPANE: 
			/*Button b1 = new Button ("Bot�n 1");
			Button b2 = new Button ("Bot�n 2");
			Button b3 = new Button ("Bot�n 3");
			VBox panelVertical = new VBox(15);
			panelVertical.setPadding(new Insets(15));
			panelVertical.getChildren().addAll(b1, b2, b3);
			
			BorderPane panel = new BorderPane(); //Con este tipo de panel no hace falta hacer el getChildren().Add
			panel.setRight(panelVertical);*/
			
			//Fin del BorderPane ------------------------------------------------------------------------------------------
			
			//GRIDPANE (Por coordenadas)
			
			GridPane panel = new GridPane();
			
			Button b1 = new Button ("Bot�n 1");
			Button b2 = new Button ("Bot�n 2");
			Button b3 = new Button ("Bot�n 3");
			Button b4 = new Button ("Bot�n 4");
			
			panel.setVgap(15); //Separaci�n vertical
			panel.setHgap(15); //Separaci�n horizontal
			panel.setPadding(new Insets(15));
			
			panel.add(b1, 0, 0); //Primer va la columna y luego la fila
			panel.add(b2, 1, 0);
			panel.add(b3, 0, 1);
			panel.add(b4, 1, 1);

			//Fin del GridPane -------------------------------------------------------------------------------------------------
			
			
			

			
			
			Scene scene = new Scene(panel, 700, 400); //Creamos la escena y le metemos el panel creado anteriormente
			primaryStage.setScene(scene); //Le creamos un escenario, y le pasamos la escena
			primaryStage.setTitle("Introducci�n a JavaFX"); //Le ponemos un t�tulo a la ventana
			primaryStage.getIcons().add(new Image("/application/emoji_cat_icon_229589.png"));
			primaryStage.show(); //Lo mostramos
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
