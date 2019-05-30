package Cine;

/**
 * @brief Esta clase define la clase entrada y define sus metodos adecuados para manejarla.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

public class Entrada {
	
	private double precio;
	private Sesion sesion;

	/**
	 * @param precio
	 * @param sesion
	 */
	public Entrada(double precio, Sesion sesion) {
		
		if(precio < 0.00 || sesion == null) {
			return;
		}
		this.precio = precio;
		this.sesion = sesion;
	}

	/**
	 * @return Obtener la sesion de la entrada
	 */
	public Sesion getSesion() {
		return sesion;
	}

	/**
	 * @param sesion Poner sesion a la entrada
	 */
	public void setSesion(Sesion sesion) {
		if(sesion != null) {
			this.sesion = sesion;
		}
	}

	/**
	 * @return Devuelve el precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio Pone el precio de la entrada
	 */
	public void setPrecio(double precio) {
		if(precio > 0.00) {
			this.precio = precio;
		}
	}

	
	public String toString() {
		return "Entrada: Precio = " + precio;
	}	
}
