package classes;

import java.util.List;

import interfaces.IIndividuo;
import interfaces.INodo;



/**
 * The Class Individuo.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class Individuo implements IIndividuo{

	/**
	 * The nodo raiz.
	 */
	private INodo nodoRaiz;

	/**
	 * The fitness.
	 */
	private Double fitness;

	/**
	 * The contador etiqueta.
	 */
	private static int contadorEtiqueta = 1;

	/**
	 * Instantiates a new individuo.
	 */
	public Individuo(){
		this.fitness = 0.0;
	};

	/**
	 * Aumenta cont.
	 *
	 * @return the int
	 * @brief Aumenta el cont.
	 */

	public static int aumentaCont() {
		int cont = getContadorEtiqueta() + 1;
		Individuo.setContadorEtiqueta(cont);
		return cont;
	}


	/**
	 * Gets the contador etiqueta.
	 *
	 * @return the contadorEtiqueta
	 */

	public static int getContadorEtiqueta() {
		return contadorEtiqueta;
	}

	/**
	 * Sets the contador etiqueta.
	 *
	 * @param contadorEtiqueta the contadorEtiqueta to set
	 */

	public static void setContadorEtiqueta(int contadorEtiqueta) {
		Individuo.contadorEtiqueta = contadorEtiqueta;
	}



	/**
	 * Gets the expresion.
	 *
	 * @return INodo el nodo raiz
	 * @brief Devuelve el nodo raiz
	 */

	public INodo getExpresion() {
		return this.nodoRaiz;
	}

	/**
	 * Sets the expresion.
	 *
	 * @param expresion the new expresion
	 * @brief Pone el nodo ra�z
	 */
	public void setExpresion(INodo expresion) {
		this.nodoRaiz = expresion;


	}

	/**
	 * Gets the fitness.
	 *
	 * @return double el fitness
	 * @brief Devuelve el fitness
	 */
	public double getFitness() {
		return this.fitness;
	}

	/**
	 * Sets the fitness.
	 *
	 * @param fitness the new fitness
	 * @brief Pone el fitness
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;

	}


	/**
	 * @brief Crear individuo aleatorio a partir de una profundidad, unos terminales y unas funciones.
	 *
	 * @param profundidad the profundidad
	 * @param terminales the terminales
	 * @param funciones the funciones
	 *
	 */

	public void crearIndividuoAleatorio(int profundidad,
			List<Terminal> terminales, List<Funcion> funciones) {

		this.setExpresion(crearIndividuoAleatorioRec(profundidad,terminales, funciones));

		return;

	}

	/**
	 * @brief Funcion recursvia que va incluyendo descendientes aleatorios a un individuo
	 *
	 * @param profundidad the profundidad
	 * @param terminales the terminales
	 * @param funciones the funciones
	 * @return the i nodo
	 */
	public INodo crearIndividuoAleatorioRec(int profundidad,
			List<Terminal> terminales, List<Funcion> funciones){

		if(profundidad == 0){
			INodo aux = terminales.get((int) (Math.random() * terminales.size())).copy();
			return aux;
		}else{
			INodo aux = funciones.get((int) (Math.random() * funciones.size())).copy();
			aux.incluirDescendiente(this.crearIndividuoAleatorioRec(profundidad - 1, terminales, funciones));
			aux.incluirDescendiente(this.crearIndividuoAleatorioRec(profundidad - 1, terminales, funciones));
			return aux;
		}

	}

	/**
	 * @brief Calculamos la expresion a partir del metodo calcular
	 * @return double Devuelve la expresion final
	 */
	public double calcularExpresion() {

		return this.nodoRaiz.calcular();
	}

	/**
	 * @brief Calculamos la expresion a partir del metodo calcular
	 * @return double Devuelve el numero de nodos
	 */


	public int getNumeroNodos() {

		int cont = 1;

		if(this.nodoRaiz.getDescendientes().isEmpty()){
			return cont;

		}else{
			for(INodo n : this.nodoRaiz.getDescendientes()){
				IIndividuo aux = new Individuo();
				aux.setExpresion(n);
				cont = cont + aux.getNumeroNodos();
			}
		}

		return cont;
	}


	/**
	 * @brief Imprime los datos del individuo
	 *
	 */
	public void writeIndividuo() {
		System.out.println("Expresion: " + ((Nodo)this.nodoRaiz).toString());

	}

	/**
	 * @brief Evaluar terminales.
	 *
	 * @param valor el valor al queque queremos evaluar
	 */
	public void evaluarTerminales(String valor){

		if(this.nodoRaiz.getDescendientes().isEmpty()){
			((Nodo) this.nodoRaiz).setRaiz(valor);
			return;

		}else{
			for(INodo n : this.nodoRaiz.getDescendientes()){
				IIndividuo aux = new Individuo();
				aux.setExpresion(n);
				((Individuo) aux).evaluarTerminales(valor);
			}

		}

		return;

	}


	/**
	 * @brief Etiqueta los nodos de un individuo.
	 */
	public void etiquetaNodos(){

		((Nodo)this.nodoRaiz).setEtiqueta(Individuo.getContadorEtiqueta());


		for(INodo n : nodoRaiz.getDescendientes()){

			this.etiquetaNodosDesc(n);

		}

		Individuo.setContadorEtiqueta(1);

		return;

	}


	/**
	 * @brief Funcion recursiva para etiquetar nodo
	 *
	 * @param INodo el nodo a etiquetar
	 */
	public void etiquetaNodosDesc(INodo n){

		((Nodo)n).setEtiqueta(Individuo.aumentaCont());

		if(n.getDescendientes().isEmpty()) return;

		for(INodo d : n.getDescendientes()){
			this.etiquetaNodosDesc(d);
		}


		return;
	}


	/**
	 * Sets the fitness.
	 *
	 * @param fitness the fitness to set
	 */
	public void setFitness(Double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Copia un individuo.
	 *
	 * @return la copia del individuo
	 */
	public Individuo copy(){
		Individuo copia = new Individuo();
		copia.setExpresion(this.nodoRaiz);
		copia.setFitness(fitness);
		return copia;
	}









}
