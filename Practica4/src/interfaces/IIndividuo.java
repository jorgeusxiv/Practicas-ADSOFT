package interfaces;

import java.util.List;
import classes.*;

/**
 * @brief La interfaz individuo
 * @author Jorge Santisteban y Martín de las Heras
 */

public interface IIndividuo {
	
	/**
	 * Gets the expresion.
	 *
	 * @return the expresion
	 */
	public INodo getExpresion();
	
	/**
	 * Sets the expresion.
	 *
	 * @param expresion the new expresion
	 */
	public void setExpresion(INodo expresion);
	
	/**
	 * Gets the fitness.
	 *
	 * @return the fitness
	 */
	public double getFitness();
	
	/**
	 * Sets the fitness.
	 *
	 * @param fitness the new fitness
	 */
	public void setFitness(double fitness);
	
	/**
	 * Crear individuo aleatorio.
	 *
	 * @param profundidad the profundidad
	 * @param terminales the terminales
	 * @param funciones the funciones
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	
	/**
	 * Calcular expresion.
	 *
	 * @return the double
	 */
	public double calcularExpresion();
	
	/**
	 * Gets the numero nodos.
	 *
	 * @return the numero nodos
	 */
	public int getNumeroNodos();
	
	/**
	 * Write individuo.
	 */
	public void writeIndividuo();
	
	
}
