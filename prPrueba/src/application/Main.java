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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Ejercicio 2. Parte 1:
			/*StackPane stackPane = new StackPane();
			stackPane = new StackPane();
			stackPane.setPadding(new Insets(10));
			//Influye el orden en el que se insertan en addAll.
			stackPane.getChildren().addAll(new Rectangle(500, 500, Color.BLUEVIOLET),new Rectangle(400, 400, Color.CORAL), new Rectangle(300, 300, Color.GOLD));
	       
	        Scene scene = new Scene(stackPane);
	        primaryStage.setScene(scene);
	        primaryStage.show();*/
			
			//Ejercicio 2. Parte 2:
			BorderPane bp = new BorderPane();
			
			Rectangle rCentro = new Rectangle(300, 300, Color.AQUAMARINE);
			Rectangle rArriba = new Rectangle(400, 50, Color.CORAL);
			Rectangle rAbajo = new Rectangle(400, 50, Color.CORAL);
			Rectangle rDerecha = new Rectangle(50, 300, Color.BLUEVIOLET);
			Rectangle rIzquierda = new Rectangle(50, 300, Color.BLUEVIOLET);
			
			bp.setCenter(rCentro);
			bp.setTop(rArriba);
			bp.setBottom(rAbajo);
			bp.setRight(rDerecha);
			bp.setLeft(rIzquierda);
			
			Scene scene = new Scene(bp);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
			
			//Ejercicio 3. Teclado numérico:
			/*Button boton1 = new Button("1");
			Button boton2 = new Button("2");
			Button boton3 = new Button("3");
			Button boton4 = new Button("4");
			Button boton5 = new Button("5");
			Button boton6 = new Button("6");
			Button boton7 = new Button("7");
			Button boton8 = new Button("8");
			Button boton9 = new Button("9");
			Button boton0 = new Button("0");
			Button botonLlamar = new Button("Llamar");
			Button botonColgar = new Button("Colgar");
			
			GridPane panel = new GridPane();
			
			panel.setVgap(0);
			panel.setHgap(0);
			panel.add(boton1, 0, 2);
			panel.add(boton2, 1, 2);
			panel.add(boton3, 2, 2);
			panel.add(boton4, 0, 1);
			panel.add(boton5, 1, 1);
			panel.add(boton6, 2, 1);
			panel.add(boton7, 0, 0);
			panel.add(boton8, 1, 0);
			panel.add(boton9, 2, 0);
			panel.add(boton0, 1, 3);
			panel.add(botonLlamar, 3, 1);
			panel.add(botonColgar, 3, 2);

			Scene s = new Scene(panel,300,300);
		    primaryStage.setScene(s);
		    primaryStage.show();*/
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
