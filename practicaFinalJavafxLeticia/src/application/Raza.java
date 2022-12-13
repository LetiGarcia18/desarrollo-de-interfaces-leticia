package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Clase que representa una raza
 * @author Leticia
 *
 */
public class Raza {
	/**
	 * Variable de tipo int que representa el id de la raza
	 */
	private int id;
	/**
	 * Varianle de tipo SimpleStringProperty que representa el nombre de la raza
	 */
	private SimpleStringProperty nombre;
	/**
	 * Variable de tipo SimpleStringProperty que representa el habitat de la raza
	 */
	private SimpleStringProperty habitat;
	/**
	 * Variable de tipo SimpleBooleanProperty que representa si la raza es peligrosa
	 */
	private SimpleBooleanProperty esPeligrosa;
	
	/**
	 * Constructor de la clase
	 * @param nombre El nombre de la raza
	 * @param habitat El habitat de la raza
	 * @param esPeligrosa Si es peligrosa la raza
	 */
	public Raza(String nombre, String habitat, boolean esPeligrosa) {
		this.nombre = new SimpleStringProperty(nombre);
		this.habitat = new SimpleStringProperty(habitat);
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}

	/**
	 * Constructor de la clase
	 * @param id El id de la raza
	 * @param nombre El nombre de la raza
	 * @param habitat El habitat de la raza
	 * @param esPeligrosa Si es peligrosa la raza
	 */
	public Raza(int id, String nombre, String habitat, boolean esPeligrosa) {
		this.id = id;
		this.nombre = new SimpleStringProperty(nombre);
		this.habitat = new SimpleStringProperty(habitat);
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}

	/**
	 * Getter del id de la raza
	 * @return Devuelve el id de la raza
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter del nombre de la raza
	 * @return Devuelve el nombre de la raza
	 */
	public String getNombre() {
		return nombre.get();
	}

	/**
	 * Setter del nombre de la raza. No devuelve nada
	 * @param nombre El nombre de la raza
	 */
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	/**
	 * Getter del habitat de la raza
	 * @return Devuelve el habitat de la raza
	 */
	public String getHabitat() {
		return habitat.get();
	}

	/**
	 * Setter del habitat de la raza
	 * @param habitat El habitat de la raza
	 */
	public void setHabitat(String habitat) {
		this.habitat = new SimpleStringProperty(habitat);
	}

	/**
	 * Función que nos dice si la raza es peligrosa
	 * @return Devuelve true si es peligrosa, y false si no lo es.
	 */
	public boolean isEsPeligrosa() {
		return esPeligrosa.get();
	}

	/**
	 * Setter de si es peligrosa la raza. No devuelve nada.
	 * @param esPeligrosa Se le pasa por parámetros true si es peligrosa, o false si no lo es.
	 */
	public void setEsPeligrosa(boolean esPeligrosa) {
		this.esPeligrosa = new SimpleBooleanProperty(esPeligrosa);
	}


}
