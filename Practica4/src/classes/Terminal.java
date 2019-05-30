package classes;

import interfaces.INodo;


/**
 * The Class Terminal.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public abstract class Terminal extends Nodo {
	
	

	
	/**
	 * @brief Incluye al nodo un descendiente, al ser terminal no hace nada
	 * @param INodo nodo a incluir
	 * 
	 */
	public void incluirDescendiente(INodo nodo){
		return;
	}
	
	/**
	 * @brief Calcula la expresion de un nodo
	 * @return Double el resultado
	 */
	
	
	public abstract double calcular();

	

	/**
	 * @brief Copia un nodo 
	 * @return INodo Devuelve el nodo copia
	 */
	
	public abstract INodo copy();


	/**
	 *@brief Devuelve una cadena con la informacion del nodo
	 *@return Devuelve la cadena  
	 */
	
	public String toString() {
		return simbolo;
	}
	
	
	
	

}
