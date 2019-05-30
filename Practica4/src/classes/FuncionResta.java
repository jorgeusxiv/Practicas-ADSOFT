package classes;

import java.util.ArrayList;

import interfaces.INodo;


/**
 * The Class FuncionResta.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class FuncionResta extends Funcion{

	
	/**
	 * Instantiates a new funcion resta.
	 *
	 * @param simbolo the simbolo
	 * @param numDesc the num desc
	 */
	public FuncionResta(String simbolo, Integer numDesc){
		this.simbolo = simbolo;
		this.numDesc = numDesc;
		this.descendientes = new ArrayList<INodo>();
	}
	
	/**
	 * @brief Calcula la expresion de un nodo
	 * @return Double el resultado
	 */
	
	public double calcular() {
		
		
		Double res = 0.00;
		for(INodo n : this.getDescendientes()){
			if(n.equals(this.getDescendientes().get(0))){
				res = n.calcular();
			}else{
				res = res-n.calcular();	
			}
		}
		
		return res;	
	
		
		
		
	}

	/**
	 * @brief Copia un nodo 
	 * @return INodo Devuelve el nodo copia
	 */
	
	public INodo copy() {
		
		INodo copia = new FuncionResta(this.simbolo, this.numDesc);
		
		for(INodo n : this.descendientes){
			copia.incluirDescendiente(n);
		}
		
		return copia;
	}

}
