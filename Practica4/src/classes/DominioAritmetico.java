package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import exceptions.*;
import interfaces.*;


/**
 * The Class DominioAritmetico.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class DominioAritmetico implements IDominio{

	/**
	 * The terminales.
	 */
	private List<Terminal> terminales; 
	
	/**
	 * The funciones.
	 */
	private List<Funcion> funciones;
	
	/**
	 * The valores.
	 */
	private List<String> valores;
	
	/**
	 * The resultados.
	 */
	private List<String> resultados;
	
	/**
	 * Instantiates a new dominio aritmetico.
	 */
	public DominioAritmetico(){
		this.terminales = new ArrayList<Terminal>();
		this.funciones = new ArrayList<Funcion>();
		this.valores = new ArrayList<String>();
		this.resultados = new ArrayList<String>();
		
		
	}
	

	/**
	 * Gets the terminales.
	 *
	 * @return the terminales
	 */
	public List<Terminal> getTerminales() {
		return terminales;
	}




	/**
	 * Sets the terminales.
	 *
	 * @param terminales the terminales to set
	 */
	public void setTerminales(List<Terminal> terminales) {
		this.terminales = terminales;
	}




	/**
	 * Gets the funciones.
	 *
	 * @return the funciones
	 */
	public List<Funcion> getFunciones() {
		return funciones;
	}




	/**
	 * Sets the funciones.
	 *
	 * @param funciones the funciones to set
	 */
	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}




	/**
	 * Gets the valores.
	 *
	 * @return the valores
	 */
	public List<String> getValores() {
		return valores;
	}




	/**
	 * Sets the valores.
	 *
	 * @param valores the valores to set
	 */
	public void setValores(List<String> valores) {
		this.valores = valores;
	}




	/**
	 * Gets the resultados.
	 *
	 * @return the resultados
	 */
	public List<String> getResultados() {
		return resultados;
	}




	/**
	 * Sets the resultados.
	 *
	 * @param resultados the resultados to set
	 */
	public void setResultados(List<String> resultados) {
		this.resultados = resultados;
	}

	/**
	 * Definir conjunto terminales.
	 *
	 * @param terminales the terminales
	 * @return List<Terminal> lista de terminales
	 * @brief A partir de una cadena de caracteres introducimos los terminales en la lista de terminales
	 */


	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		
		for(String aux : terminales){
			Terminal t = new TerminalAritmetico(aux);
			this.terminales.add(t);
		}
		
		return this.terminales;
		
	}
	

	/**
	 * Definir conjunto funciones.
	 *
	 * @param argumentos the argumentos
	 * @param funciones the funciones
	 * @return List<Funcion> lista de funciones
	 * @throws ArgsDistintosFuncionesException the args distintos funciones exception
	 * @brief A partir de una cadena de caracteres introducimos las funciones en la lista de funciones y dependiendo del tipo crea una
	 * funcion diferentes
	 */

	public List<Funcion> definirConjuntoFunciones(int[] argumentos,
			String... funciones) throws ArgsDistintosFuncionesException {
		
		int i;
		
		if(argumentos.length != funciones.length) throw new ArgsDistintosFuncionesException();
		
		for(i = 0; i < argumentos.length; i++){
			
			switch(funciones[i]){
			case "+":
				Funcion f1 = new FuncionSuma(funciones[i], argumentos[i]);
				this.funciones.add(f1);
				break;
			
			case "-":
				Funcion f2 = new FuncionResta(funciones[i], argumentos[i]);
				this.funciones.add(f2);
				break;
			
			case "*":
				Funcion f3 = new FuncionMultiplicacion(funciones[i], argumentos[i]);
				this.funciones.add(f3);
				break;
			
			default:
				break;
			}		
		}	
		
		return this.funciones;
	}
	
	
	/**
	 * @brief  A partir de un fichero de texto inicializamos el dominio
	 * @param String nombre del fichero del dominio
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(ficheroDatos));
			String line = br.readLine();
			
			while(line != null){
				
				ArrayList<String> aux = new ArrayList<String>();

				StringTokenizer str = new StringTokenizer(line,";");
				do{

					String token = str.nextToken();
					
					aux.add(token);

				}while(str.hasMoreTokens());
				
				this.valores.add(aux.get(0));
				this.resultados.add(aux.get(1));
				
				line = br.readLine();

			}
			
			br.close();
			
		}catch(FileNotFoundException e){
			System.out.println("FileNotFound Exception\n");
			e.printStackTrace();
			return;
		}catch(IOException e){
			System.out.println("IO Exception\n");
			e.printStackTrace();
			return;
		}
		
		
	}

	/* 
	 * @brief Calculo el fitness de un individuo
	 * @param IIndividuo Individuo del cual queremos obtener el fitness
	 * @return double Devuelve el fitness 
	 */
	public double calcularFitness(IIndividuo individuo) {
		
		double estimado, real;
		int fitness = 0;
		int j = 0;
		
		for(String i : this.valores){
			
			Individuo copia = ((Individuo)individuo).copy();
			
			(copia).evaluarTerminales(i);
			
			estimado = individuo.calcularExpresion();
			real = Double.parseDouble(resultados.get(j));
			
			if(estimado >= (real - 1) && estimado <= (real + 1)){
				fitness++;
			}
			
			System.out.println("Valor: " + i + " <-> Rdo estimado: " + estimado + " <-> Rdo real: " + real);
			
			j++;
			
		}
		
		individuo.setFitness(fitness);
		((Individuo)individuo).evaluarTerminales("x");
		System.out.println("\n");
		
		
		
		return fitness;
	}

	

}
