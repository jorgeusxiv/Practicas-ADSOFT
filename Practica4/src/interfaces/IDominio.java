package interfaces;
import java.io.*;
import java.util.List;
import classes.*;
import exceptions.*;

/**
 * @brief La interfaz dominio
 * @author Jorge Santisteban y Martín de las Heras
 */

public interface IDominio {
	
	/**
	 * Definir conjunto terminales.
	 *
	 * @param terminales the terminales
	 * @return the list
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	
	/**
	 * Definir conjunto funciones.
	 *
	 * @param argumentos the argumentos
	 * @param funciones the funciones
	 * @return the list
	 * @throws ArgsDistintosFuncionesException the args distintos funciones exception
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
ArgsDistintosFuncionesException;

	/**
	 * Definir valores prueba.
	 *
	 * @param ficheroDatos the fichero datos
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	
	/**
	 * Calcular fitness.
	 *
	 * @param individuo the individuo
	 * @return the double
	 */
	public double calcularFitness(IIndividuo individuo);
}