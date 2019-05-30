package interfaces;

import java.util.List;


/**
 * @brief La interfaz nodo
 * @author Jorge Santisteban y Martín de las Heras
 */
public interface INodo {

	
	/**
	 * Gets the raiz.
	 *
	 * @return the raiz
	 */
	public String getRaiz();
	
	/**
	 * Gets the descendientes.
	 *
	 * @return the descendientes
	 */
	public List<INodo> getDescendientes();
	
	/**
	 * Incluir descendiente.
	 *
	 * @param nodo the nodo
	 */
	public void incluirDescendiente(INodo nodo);
	
	/**
	 * Calcular.
	 *
	 * @return the double
	 */
	public double calcular();
	
	/**
	 * Copy.
	 *
	 * @return the i nodo
	 */
	public INodo copy();
	
	/**
	 * Sets the raiz.
	 *
	 * @param valor the new raiz
	 */
	public void setRaiz(String valor);
	
	
}
