package application;

public class Raza {
	
	private int id;
	private String nombre;
	private String habitat;
	private boolean esPeligrosa;
	
	public Raza(String nombre, String habitat, boolean esPeligrosa) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
	}

	
	public Raza(int id, String nombre, String habitat, boolean esPeligrosa) {
		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getHabitat() {
		return habitat;
	}


	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}


	public boolean isEsPeligrosa() {
		return esPeligrosa;
	}


	public void setEsPeligrosa(boolean esPeligrosa) {
		this.esPeligrosa = esPeligrosa;
	}



	@Override
	public String toString() {
		String peligrosa = "";
		
		if(esPeligrosa) {
			peligrosa = "Si";
		}else {
			peligrosa = "No";
		}
		
		return "Raza --> \nid: " + id + "\nNombre: " + nombre + "\nHabitat: " + habitat + "\nEs peligrosa: " + peligrosa;
	}

}
