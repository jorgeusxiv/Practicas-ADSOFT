package classes;

import java.util.ArrayList;

import interfaces.INodo;


/**
 * The Class FuncionSuma.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class FuncionSuma extends Funcion {

	
	/**
	 * Instantiates a new funcion suma.
	 *
	 * @param simbolo the simbolo
	 * @param numDesc the num desc
	 */
	public FuncionSuma(String simbolo, Integer numDesc){
		this.simbolo = simbolo;
		this.numDesc = numDesc;
		this.descendientes = new ArrayList<INodo>();
	}
	
	/**
	 * @brief Calcula la expresion de un nodo
	 * @return Double el resultado
	 */
	
	public double calcular() {
		

		return this.getDescendientes().get(0).calcular() + this.getDescendientes().get(1).calcular() ;
		
	}

	/**
	 * @brief Copia un nodo 
	 * @return INodo Devuelve el nodo copia
	 */
	
	public INodo copy() {
		
		INodo copia = new FuncionSuma(this.simbolo, this.numDesc);
		
		for(INodo n : this.descendientes){
			copia.incluirDescendiente(n);
		}
		
		return copia;
	}
	
	

}
