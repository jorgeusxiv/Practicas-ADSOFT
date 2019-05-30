package adsof1718.grafos.got;

/**
 * Esta clase define el tipo PersonajeGOT
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class PersonajeGOT {
	private String nombre;
	private String casa;
	
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre a anadir
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return casa
	 */
	public String getCasa() {
		return casa;
	}

	/**
	 * @param casa a anadir
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}

	/**
	 * @return String con la informacion del personaje
	 */
	@Override
	public String toString() {
		return nombre + " de la casa " + casa;
	}
	
	
	
	
}
