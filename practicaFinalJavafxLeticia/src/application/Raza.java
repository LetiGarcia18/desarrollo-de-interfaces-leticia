package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Raza {
	
	private int id;
	
	private SimpleStringProperty nombre;
	
	private SimpleStringProperty habitat;
	
	private SimpleBooleanProperty esPeligrosa;
	
	public Raza(String nombre, String habitat, boolean esPeligrosa) {
		this.nombre = new SimpleStringProperty(nombre);
		this.habitat = new SimpleStringProperty(habitat);
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}

	
	public Raza(int id, String nombre, String habitat, boolean esPeligrosa) {
		this.id = id;
		this.nombre = new SimpleStringProperty(nombre);
		this.habitat = new SimpleStringProperty(habitat);
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre.get();
	}


	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}


	public String getHabitat() {
		return habitat.get();
	}


	public void setHabitat(String habitat) {
		this.habitat = new SimpleStringProperty(habitat);
	}


	public boolean isEsPeligrosa() {
		return esPeligrosa.get();
	}


	public void setEsPeligrosa(boolean esPeligrosa) {
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}


}
