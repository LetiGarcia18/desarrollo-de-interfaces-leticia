package application;
	
import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*Button btn = new Button("Click Aqui:");
			btn.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent eventz) {
					System.out.println("Hola mundo.");
				}
			});
			
			Label lbl = new Label("Hola mundo.");
			
			//Para insertar cosas en el panel, lo creamos.
			StackPane panel1 = new StackPane();
			StackPane panel2 = new StackPane();
			StackPane panel3 = new StackPane();
			
			Scene scene = new Scene(panel1,500,500);*/
			
			//Creamos la escena, y decimos el panel que queremos y las caracteristicas de este.
			
			/*Button btn1 = new Button("Boton 1");
			Button btn2 = new Button("Boton 2");
			Button btn3 = new Button("Boton 3");
			Button btn4 = new Button("Boton 4");
			
			
			GridPane panel = new GridPane();
			
			panel.setVgap(15);
			panel.setHgap(15);
			panel.add(btn1, 0, 0);
			panel.add(btn2, 1, 0);
			panel.add(btn3, 0, 1);
			panel.add(btn4, 1, 1);*/
			
			/*VBox panelVertical = new VBox(15);
			panelVertical.setPadding(new Insets(15));
			panelVertical.getChildren().addAll(btn1,btn2,btn3);
			BorderPane bp = new BorderPane();
			bp.setRight(panelVertical);*/
			/*bp.setCenter(btn1);
			bp.setRight(btn2);
			bp.setTop(btn3);*/
			
			//HBox vBoxPanel = new HBox(15);
			//vBoxPanel.setPadding(new Insets(15));
			//vBoxPanel.getChildren().addAll(btn1,btn2,btn3);
			//Scene scene = new Scene(panel,400,300);
			
			/*primaryStage.setScene(scene);
			primaryStage.setTitle("Introduccion a JavaFX");
			primaryStage.getIcons().add(new Image("/application/angry.png"));
			primaryStage.show();*/
			
			//Ejercicio 2. Parte 1:
			StackPane stackPane = new StackPane();
			stackPane = new StackPane();
			stackPane.setPadding(new Insets(10));
			stackPane.getChildren().addAll(new Rectangle(500, 500, Color.BLUEVIOLET),new Rectangle(400, 400, Color.CORAL), new Rectangle(300, 300, Color.GOLD));
	       
	        Scene scene = new Scene(stackPane);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
			//Ej 2
			/*Button btn1 = new Button("1");
			Button btn2 = new Button("2");
			Button btn3 = new Button("3");
			Button btn4 = new Button("4");
			Button btn5 = new Button("5");
			Button btn6 = new Button("6");
			Button btn7 = new Button("7");
			Button btn8 = new Button("8");
			Button btn9 = new Button("9");
			Button btn0 = new Button("0");
			Button btnLlamar = new Button("Llamar");
			Button btnColgar = new Button("Colgar");
			
			GridPane panel = new GridPane();
			
			panel.setVgap(0);
			panel.setHgap(0);
			panel.add(btn1, 0, 2);
			panel.add(btn2, 1, 2);
			panel.add(btn3, 2, 2);
			panel.add(btn4, 0, 1);
			panel.add(btn5, 1, 1);
			panel.add(btn6, 2, 1);
			panel.add(btn7, 0, 0);
			panel.add(btn8, 1, 0);
			panel.add(btn9, 2, 0);
			panel.add(btn0, 1, 3);
			panel.add(btnLlamar, 3, 1);
			panel.add(btnColgar, 3, 2);*/

			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
