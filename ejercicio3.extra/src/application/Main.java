package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Ejercicio 3. Teclado numérico:
			Button boton1 = new Button("1");
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
			
			//Panel principal
			BorderPane panel = new BorderPane();
			Label label_numero = new Label();
			panel.setBottom(label_numero);
			
			
			//Panel secundario
			GridPane grid = new GridPane();
			panel.setCenter(grid); //Esto es para alinearlo
			
			grid.setVgap(0);
			grid.setHgap(0);
			grid.add(boton1, 0, 2); //Primero va la columna (0), y luego la fila (2)
			boton1.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "1";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton2, 1, 2);
			boton2.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "2";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton3, 2, 2);
			boton3.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "3";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton4, 0, 1);
			boton4.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "4";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton5, 1, 1);
			boton5.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "5";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton6, 2, 1);
			boton6.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "6";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton7, 0, 0);
			boton7.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "7";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton8, 1, 0);
			boton8.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "8";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton9, 2, 0);
			boton9.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "9";
					label_numero.setText(numero);
				}
				
			});
			grid.add(boton0, 1, 3);
			boton0.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					String numero = label_numero.getText() + "0";
					label_numero.setText(numero);
				}
				
			});
			grid.add(botonLlamar, 3, 1);
			grid.add(botonColgar, 3, 2);

			Scene s = new Scene(panel,300,300);
		    primaryStage.setScene(s);
		    primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
