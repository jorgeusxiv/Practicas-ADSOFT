package adsof1718.grafos;

import java.util.*;

/**
 * Esta clase define el tipo abstracto grafo e implementa las funciones necesarias
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public abstract class Grafo<T> {
	
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<List<Vertice<T>>, Double> arcos;
	
	protected int numVertices;
	protected int numArcos;
	
	public Grafo() {
		vertices = new TreeMap<Integer, Vertice<T>>();
		arcos = new HashMap<List<Vertice<T>>, Double>();
	}
	
	/**
	 * Llama a addVertice para anadir el vertice al grafo
	 * @param datos que van a ir en el nuevo vertice
	 * @return el vertice
	 */
	
	public Vertice<T> addVertice(T datos){
		if(datos == null) {
			return null;
		}
		return addVertice(numVertices, datos);
	}
	
	/**
	 * Crea el vertice, aumenta el numero de vertices en 1 y lo anade a la lista
	 * @param id del vertice
	 * @param datos del vertice
	 * @return el vertice
	 */
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> vertice = new Vertice<T>(datos, id);
		vertices.put(id, vertice);
		numVertices += 1;
		return vertice;
	}
	
	/**
	 * Devuelve una lista con todos los vertices del grafo
	 * @return lista con los vertices
	 */
	
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> lista = new ArrayList<Vertice<T>>(vertices.values());
		return lista;
	}
	
	/**
	 * Devuelve el numero de vertices
	 * @return numVertices
	 */
	
	public int getNumVertices() {
		return numVertices;
	}
	
	/**
	 * Anade un arco entre v1 y v2 con peso peso
	 * @param v1
	 * @param v2
	 * @param peso
	 */
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	/**
	 * Indica si hay arco entre v1 y v2
	 * @param v1
	 * @param v2
	 * @return true si hay arco false si no o si falla algo
	 */
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null) {
			return false;
		}
		return arcos.containsKey(Arrays.asList(v1,v2));
	}
	
	/**
	 * Devuelve el numero de arcos
	 * @return numArcos
	 */
	
	public int getNumArcos() {
		return numArcos;
	}
	
	/**
	 * Devuelve el peso del arco entre v1 y v2
	 * @param v1
	 * @param v2
	 * @return peso
	 */
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	/**
	 * Devuelve una lista con los vertices conectados a v
	 * @param v
	 * @return lista de vertices
	 */
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
	// (en grafo dirigido, v ha de ser origen de los arcos)
	
	/**
	 * Devuelve un string con toda la informacion del grafo
	 * @return texto
	 */
	
	public String toString() {
		String texto = "\nVertices:\n";
		for(Vertice<T> v : getVertices()) {
			texto += v.toString();
			texto += "\n";
		}
		texto += "\nArcos: \n";
		for(List<Vertice<T>> lv: new ArrayList<List<Vertice<T>>>(arcos.keySet())) {
			texto += "\n" + lv + "\nPeso: " + arcos.get(lv) + "\n";
		}
		return texto;
	}
}
