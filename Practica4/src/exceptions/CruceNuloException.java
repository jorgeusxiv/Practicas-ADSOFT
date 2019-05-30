package exceptions;

/**
 * @brief La excepcion que detecta los cruces nulos
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class CruceNuloException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "El cruce es inviable\n";
	}

}
