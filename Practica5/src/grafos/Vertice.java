package adsof1718.grafos;

/**
 * Esta clase define el tipo vertice y sus funciones
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class Vertice<T> {
	
	private final int id;
	private T datos;
	
	public Vertice(T datos, int id) {
		
		this.id = id;
		this.datos = datos;
	}

	/**
	 * @return datos
	 */
	public T getDatos() {
		return datos;
	}

	/**
	 * @param datos para anadir
	 */
	public void setDatos(T datos) {
		this.datos = datos;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return string con la informacion del vertice
	 */
	@Override
	public String toString() {
		return "Vertice " + id + ": " + datos;
	}
	
	
}
