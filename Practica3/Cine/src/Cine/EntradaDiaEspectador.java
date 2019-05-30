package Cine;

import java.text.DecimalFormat;

/**
 * @brief Esta clase define la clase entrada del dia del espectador y redefine el metodo getPrecio de su clase padre (Entrada)
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

public class EntradaDiaEspectador extends Entrada{
	

	/**
	 * @param precio
	 * @param sesion
	 */
	public EntradaDiaEspectador(double precio, Sesion sesion) {
		super(precio, sesion);
	}
	

	/**
	 * @return Devuelve el precio
	 */

	public double getPrecio() {
		
		return super.getPrecio()*(1 - 0.4);
	}
	
	public String toString() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		return "Entrada del dia del espectador: Precio = " + numberFormat.format(getPrecio());
	}

}
