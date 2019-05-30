package exceptions;


/**
 * @brief La excepcion que detecta los argumentos distintos
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class ArgsDistintosFuncionesException extends Exception {
	
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;


	public String toString() {
		return "El número de argumentos debe ser el mismo que el número de funciones";
	}

}
