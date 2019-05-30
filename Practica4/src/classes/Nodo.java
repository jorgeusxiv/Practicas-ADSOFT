package classes;

import java.util.List;

import interfaces.INodo;


/**
 * The Class Nodo.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */


public abstract class Nodo implements INodo {

	/**
	 * The simbolo.
	 */
	protected String simbolo;
	
	/**
	 * The descendientes.
	 */
	protected List<INodo>  descendientes;
	
	/**
	 * The etiqueta.
	 */
	protected int etiqueta;


	/**
	 * Gets the etiqueta.
	 *
	 * @return la etiqueta
	 */
	public int getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Sets the etiqueta.
	 *
	 * @param etiqueta la etiqueta a poner
	 */
	public void setEtiqueta(int etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	/**
	 * Gets the raiz.
	 *
	 * @return el simbolo
	 */
	

	public String getRaiz() {
		return this.simbolo;
	}
	
	/**
	 * Sets the raiz.
	 *
	 * @param simbolo the new raiz
	 */

	public void setRaiz(String simbolo){
		this.simbolo = simbolo;
	}
	
	/**
	 * Gets the descendientes.
	 *
	 * @return descendientes los descendientes del nodo
	 */

	public List<INodo> getDescendientes() {
		return this.descendientes;
	}
	
	/**
	 * Sets the descendientes.
	 *
	 * @param descendientes los descendientes que queremos que tenga el nodo
	 */
	public void setDescendientes(List<INodo> descendientes) {
		this.descendientes = descendientes;
	}
	
	/**
	 * Incluir descendiente.
	 *
	 * @param nodo El nodo que queremos incluir
	 */

	public abstract void incluirDescendiente(INodo nodo);
	
	/**
	 * Calcular.
	 *
	 * @return the double
	 * @brief La funcion que calcula las raices
	 */

	public abstract double calcular();
	
	/**
	 * Copy.
	 *
	 * @return the i nodo
	 * @brief La funcion que copia un nodo
	 */

	public abstract INodo copy();
	
	/**
	 * To string.
	 *
	 * @return the string
	 * @brief Pasa un nodo a string
	 */

	public abstract String toString();
	
	/**
	 * Gets the nodo etiqueta.
	 *
	 * @param etiqueta La etiqueta que identifica el nodo que buscamos
	 * @return Nodo Devuelve el nodo que buscamos
	 * @brief A partir de una etiqueta devuelve su nodo correspondiente
	 */


	public Nodo getNodoEtiqueta(int etiqueta){

		Nodo res;
	

		if(this.getEtiqueta() == etiqueta){
			return this; 
		}

		if(this.getDescendientes().isEmpty()){
			return null;
		}


		for(int i = 0; i < this.getDescendientes().size(); i++){
			
			Nodo aux = (Nodo) this.getDescendientes().get(i);
			res = aux.getNodoEtiqueta(etiqueta);
			if(res != null){
				return res;
	
			}


		}

		return null;

	}
	
	/**
	 * Cambiar nodo etiqueta.
	 *
	 * @param n1 the n 1
	 * @param etiqueta the etiqueta
	 * @return Devuelve null si se ha realizado correctamente, sino devuelve un nodo para continua la recursion
	 * @brief Ponemos el nodo n1 en la posicion que indica la etiqueta
	 */

	public Nodo cambiarNodoEtiqueta(INodo n1, int etiqueta){
		
		if(etiqueta == 1){
			
			this.setRaiz(n1.getRaiz());
			this.setDescendientes(n1.getDescendientes());
			return null;
		}

		Nodo res;

		if(this.getEtiqueta() == etiqueta){
			return this; 
		}

		if(this.getDescendientes().isEmpty()){
			return null;
		}

		int posicion = -1;
		for(int i = 0; i < this.getDescendientes().size(); i++){
			INodo aux = this.getDescendientes().get(i);
			
			res = ((Nodo) aux).cambiarNodoEtiqueta(n1, etiqueta);
		
			if(res != null){
				posicion = i;
				break;
			}
		}

		if(posicion != -1){
			this.getDescendientes().remove(posicion);
			this.getDescendientes().add(posicion, n1);
		}

		return null;

	}


}
