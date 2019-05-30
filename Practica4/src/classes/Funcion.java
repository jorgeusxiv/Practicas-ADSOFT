package classes;

import interfaces.INodo;


/**
 * The Class Funcion.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public abstract class Funcion extends Nodo {
	
	/**
	 * The num desc.
	 */
	protected Integer numDesc;
	
	
	/**
	 * @brief Incluye al nodo un descendiente
	 * @param INodo nodo a incluir
	 * 
	 */
	public void incluirDescendiente(INodo nodo){
		
		if(this.descendientes.size() > this.numDesc) return;
		
		INodo copia = nodo.copy();
		
		this.descendientes.add(copia);
		
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
		
		String funcion = "(" + simbolo;
		
		for(INodo n : descendientes){
			funcion = funcion + " " + n.toString();
		}
		
		return funcion + ")";
	}


}
