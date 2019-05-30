package classes;

import java.util.ArrayList;

import interfaces.INodo;

/**
 * @author Jorge Santisteban y Martín de las Heras
 *
 */

public class FuncionMultiplicacion extends Funcion{

	/**
	 * Instantiates a new funcion multiplicacion.
	 *
	 * @param simbolo the simbolo
	 * @param numDesc the num desc
	 */
	public FuncionMultiplicacion(String simbolo, Integer numDesc){
		this.simbolo = simbolo;
		this.numDesc = numDesc;
		this.descendientes = new ArrayList<INodo>();
	}

	/**
	 * @brief Calcula la expresion de un nodo
	 * @return Double el resultado
	 */

	public double calcular() {

		Double res = 1.00;
		for(INodo n : this.getDescendientes()){
			res = res*n.calcular();
		}

		return res;

	}

	/**
	 * @brief Copia un nodo
	 * @return INodo Devuelve el nodo copia
	 */


	public INodo copy() {

		INodo copia = new FuncionMultiplicacion(this.simbolo, this.numDesc);

		for(INodo n : this.descendientes){
			copia.incluirDescendiente(n);
		}

		return copia;
	}

}
