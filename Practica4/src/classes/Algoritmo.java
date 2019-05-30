package classes;

import java.util.ArrayList;
import java.util.List;



import exceptions.ArgsDistintosFuncionesException;
import exceptions.CruceNuloException;
import interfaces.IAlgoritmo;
import interfaces.IDominio;
import interfaces.IIndividuo;


/**
 * 
 *
 * @author Jorge Santisteban y MartÃ­n de las Heras
 */

public class Algoritmo implements IAlgoritmo{

	
	/**
	 * The poblacion.
	 */
	private List<IIndividuo> poblacion;
	
	/** The terminales. */
	private List <Terminal> terminales;
	
	/** The funciones. */
	private List<Funcion> funciones;
	
	/** The num individuos. */
	private int numIndividuos;
	
	/** The profundidad. */
	private int profundidad;
	
	/** The k. */
	private int K;
	
	/** The generacion. */
	private int generacion;
	
	/** The generaciones max. */
	private double generaciones_max;
	
	/** The prob. */
	private double prob;
	
	/**
	 * Instantiates a new algoritmo.
	 *
	 * @param prof_max the prof max
	 * @param generaciones_max the generaciones max
	 * @param K the k
	 * @param numIndividuos the num individuos
	 * @param prob the prob
	 * @brief Constructor donde inicializamos el algoritmo
	 */
	
	public Algoritmo (int prof_max, int generaciones_max, int K, int numIndividuos, double prob){
		
		this.poblacion = new ArrayList<IIndividuo>();
		this.terminales = new ArrayList<Terminal>();
		this.funciones = new ArrayList<Funcion>();
		
		this.numIndividuos = numIndividuos;
		this.profundidad = prof_max;
		this.K = K;
		this.generacion = 0;
		this.generaciones_max = generaciones_max;
		this.prob = prob;
		
	}
		
	
	/**
	 * Gets the num individuos.
	 *
	 * @return el numIndividuos
	 */
	public int getNumIndividuos() {
		return numIndividuos;
	}



	/**
	 * Gets the profundidad.
	 *
	 * @return la profundidad
	 */
	public int getProfundidad() {
		return profundidad;
	}



	/**
	 * Sets the num individuos.
	 *
	 * @param numIndividuos el numIndividuos a poner
	 */
	public void setNumIndividuos(int numIndividuos) {
		this.numIndividuos = numIndividuos;
	}


	/**
	 * Gets the poblacion.
	 *
	 * @return la poblacion
	 */
	public List<IIndividuo> getPoblacion() {
		return poblacion;
	}


	/**
	 * Sets the poblacion.
	 *
	 * @param poblacion la poblacion a poner
	 */
	public void setPoblacion(List<IIndividuo> poblacion) {
		
		int i;
		
		this.poblacion = poblacion;
		this.numIndividuos = poblacion.size();
		
		for(i = 0; i < poblacion.size(); i++){
			((Individuo) this.poblacion.get(i)).etiquetaNodos();
		}
	}


	/**
	 * Gets the terminales.
	 *
	 * @return los terminales
	 */
	public List<Terminal> getTerminales() {
		return terminales;
	}




	/**
	 * Gets the funciones.
	 *
	 * @return las funciones
	 */
	public List<Funcion> getFunciones() {
		return funciones;
	}


	/**
	 * Gets the generacion.
	 *
	 * @return la generacion
	 */
	public int getGeneracion() {
		return generacion;
	}

	/**
	 * Sets the generacion.
	 *
	 * @param generacion la generacion a poner
	 */
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}


	/**
	 * Gets the generaciones max.
	 *
	 * @return las generaciones_max
	 */
	public double getGeneraciones_max() {
		return generaciones_max;
	}



	/**
	 * Sets the generaciones max.
	 *
	 * @param generaciones_max las generaciones_max a poner
	 */
	public void setGeneraciones_max(double generaciones_max) {
		this.generaciones_max = generaciones_max;
	}



	/**
	 * Gets the k.
	 *
	 * @return la k
	 */
	public int getK() {
		return K;
	}


	/**
	 * Sets the k.
	 *
	 * @param k la k a poner
	 */
	public void setK(int k) {
		K = k;
	}

	/**
	 * Gets the prob.
	 *
	 * @return la prob
	 */
	public double getProb() {
		return prob;
	}


	/**
	 * Sets the prob.
	 *
	 * @param prob la prob a poner
	 */
	public void setProb(double prob) {
		this.prob = prob;
	}

	/**
	 * Define conjunto terminales.
	 *
	 * @param terminales los terminales a poner
	 */
	
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;
		
	}
	
	/**
	 * Define conjunto funciones.
	 *
	 * @param funciones las funciones a poner
	 * @throws ArgsDistintosFuncionesException the args distintos funciones exception
	 */

	
	public void defineConjuntoFunciones(List<Funcion> funciones)
			throws ArgsDistintosFuncionesException {
		this.funciones = funciones;
		
	}
	
	/**
	 * 
	 *
	 * @brief Genera una poblacion con individuos aleatorios a partir del numero de individuos que el usuario halla
	 * decidido
	 */

	
	public void crearPoblacion() {
		
		int i;
		
		for(i = 0; i < this.numIndividuos; i++){
			IIndividuo ind = new Individuo();
			ind.crearIndividuoAleatorio(this.profundidad, this.terminales, this.funciones);
			poblacion.add(ind);
		}
		
	}
	
	/**
	 * @brief Se encarga de cruzar 2 individuos
	 * @return List<IIndividuo> devuelve una lista con los dos nuevos individuos
	 * 
	 */

	
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2)
			throws CruceNuloException {
		PruebaCruce prueba = new PruebaCruce();
		
		return prueba.cruce(prog1, prog2);
		
	}

	
	/**
	 *  @brief Crea una nueva poblacin y va generando las generaciones progresivamente
	 *
	 */
	public void crearNuevaPoblacion() {
		
		if(this.generaciones_max == this.generacion)return;
		
		if(this.poblacion.size() < 2) return;
		
		else if(this.poblacion.size() == 2){
			
			List<IIndividuo> nuevapoblacion = new ArrayList<>();
			
			try {
				nuevapoblacion.addAll(cruce(this.poblacion.get(0), this.poblacion.get(1)));
			} catch (CruceNuloException e) {
				e.printStackTrace();
			}
			
			this.numIndividuos = 2;
			this.poblacion = nuevapoblacion;
		}else{
			
			//Tendremos varias listas, una para guardar a los padres, otra para guardar los resultantes del cruce, la poblacion directa
			// y una poblacion temporal
			
			List <IIndividuo> padres = new ArrayList<>();
			List <IIndividuo> cruce = new ArrayList<>();
			List <IIndividuo> nuevapoblacion = new ArrayList<>();
			List <IIndividuo> poblaciondirecta = new ArrayList<>();
			List <IIndividuo> poblaciontmp = new ArrayList<>();
			
			poblaciontmp.addAll(this.poblacion);
			
			int i, j; 
			
			//Primero insertamos a la poblacion directa
			
			for(i = 0; i < (int)(poblaciontmp.size() * (1 -this.prob)); i++){
				
				IIndividuo mejor = poblaciontmp.get(0);
				
				for(j = 0; j < poblaciontmp.size(); j++){
					if(poblaciontmp.get(j).getFitness() > mejor.getFitness()){
						mejor = poblaciontmp.get(j);
					}
				}
				
				poblaciondirecta.add(((Individuo) mejor).copy());
				
				poblaciontmp.remove(mejor);
			
			}
			
			// Después generamos el resto de los integrantes de la poblacion 
			
			
			for(i = 0; i < this.K; i++){
				
				if(poblaciontmp.size() < i) i = this.K;
				
				else{
					IIndividuo padre = poblaciontmp.get((int) (Math.random() * poblaciontmp.size()));
					padres.add(((Individuo) padre).copy());
					poblaciontmp.remove(padre);
				}
				
			}
			
			//Finalmente los mostramos por pantalla
			
			System.out.println("Los candidatos para el cruce son ");
			
			for(i = 0; i < padres.size(); i++){
				padres.get(i).writeIndividuo();
			}
			
			System.out.println("\n");
			
			for(i = 0; i < 2; i++){
				
				IIndividuo mejorpadre = padres.get(0);
				
				for(j = 0; j < padres.size(); j++){
					if(padres.get(j).getFitness() > mejorpadre.getFitness()){
						mejorpadre = padres.get(j);
					}
				}
				cruce.add(((Individuo) mejorpadre).copy());
				padres.remove(mejorpadre);
			
			}
			
			//Mostramos los individuos seleccionados para el cruce
			
			System.out.println("Los individuos seleccionados para el cruce son ");
			for(i = 0; i < cruce.size(); i++){
				cruce.get(i).writeIndividuo();
			}
			
			System.out.println("\n");
			
			//Realizamos el cruce e insertamos los nuevos individuos en la poblacion
			try {
				nuevapoblacion.addAll(cruce(cruce.get(0), cruce.get(1)));
			} catch (CruceNuloException e) {
				e.printStackTrace();
			}
			
			this.numIndividuos = nuevapoblacion.size();
			this.setPoblacion(nuevapoblacion);
			
			System.out.println("La poblacion final es");
			for(i = 0; i < numIndividuos; i++){
				poblacion.get(i).writeIndividuo();
			}
			
			System.out.println("\n");
			System.out.println("El numero final de habitantes es " + nuevapoblacion.size() + "\n");
			
			
		}
		
	}

	/**
	 * @brief Programa que simula el main para generar generaciones e ir aplicando el cruce entre ellas
	 */
	public void ejecutar(IDominio dominio){
		
		this.crearPoblacion();
		System.out.println(this);
		
		int i;
		
		//Calculamos el fitness y etiquetamos
		
		for(i = 0; i < this.poblacion.size(); i++){
			double fitness = dominio.calcularFitness(poblacion.get(i));
			poblacion.get(i).setFitness(fitness);
			((Individuo) poblacion.get(i)).etiquetaNodos();
		}
		
		//Iteramos hasta la generacion maxima
		
		
		while(this.generacion < this.generaciones_max){
			
			System.out.println("************************************************************");
			this.crearNuevaPoblacion();
			
			for(i = 0; i < this.poblacion.size(); i++){
				
				double fitness = dominio.calcularFitness(poblacion.get(i));
				poblacion.get(i).setFitness(fitness);
				
			}
			
			this.generacion++;
			System.out.println(this.toString());
			System.out.println("************************************************************");
			
			
			if(this.generacion < this.generaciones_max){
				System.out.println("Generacion siguiente \n");
			}
			
			
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @brief Funcion que devuelve en una cadena todo lo que vaya realizando el algoritmo
	 */
	public String toString(){
		
		String resultado = "";
		
		int i;
		
		for (i = 0; i < this.poblacion.size(); i++){
			resultado = resultado + "Individuo " + i + "\n" + poblacion.get(i).getExpresion().toString() + "\n******************\n";
		}
		
		resultado = resultado + "Profundidad = " + this.profundidad + "\n";
		resultado = resultado + "Generacion = " + this.generacion + "\n";
		
		return resultado;
	}

}
