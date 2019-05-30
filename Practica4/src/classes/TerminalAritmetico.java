package classes;

import java.util.ArrayList;
import interfaces.INodo;


/**
 * The Class TerminalAritmetico.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class TerminalAritmetico extends Terminal {

	/**
	 * Instantiates a new terminal aritmetico.
	 *
	 * @param simbolo the simbolo
	 */
	public TerminalAritmetico(String simbolo){
		this.simbolo = simbolo;
		this.descendientes = new ArrayList<INodo>();
	}


	/**
	 * @brief Calcula la expresion de un nodo
	 * @return Double el resultado
	 */

	public double calcular() {
		return Double.parseDouble(this.simbolo);
	}



	/**
	 * @brief Copia un nodo
	 * @return INodo Devuelve el nodo copia
	 */


	public INodo copy() {

		INodo copia = new TerminalAritmetico(this.simbolo);

		return copia;
	}








}
