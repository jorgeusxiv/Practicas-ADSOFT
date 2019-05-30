package interfaces;

import java.util.*;
import classes.*;
import exceptions.*;

/**
 * @brief La interfaz algoritmo
 * @author Jorge Santisteban y Martín de las Heras
 */
public interface IAlgoritmo {
	
	/**
	 * Define conjunto terminales.
	 *
	 * @param terminales the terminales
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);
	
	/**
	 * Define conjunto funciones.
	 *
	 * @param funciones the funciones
	 * @throws ArgsDistintosFuncionesException the args distintos funciones exception
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
	
	/**
	 * Crear poblacion.
	 */
	public void crearPoblacion();
	
	/**
	 * Cruce.
	 *
	 * @param prog1 the prog 1
	 * @param prog2 the prog 2
	 * @return the list
	 * @throws CruceNuloException the cruce nulo exception
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;
	
	/**
	 * Crear nueva poblacion.
	 */
	public void crearNuevaPoblacion();
	
	/**
	 * Ejecutar.
	 *
	 * @param dominio the dominio
	 */
	public void ejecutar(IDominio dominio);
	
}