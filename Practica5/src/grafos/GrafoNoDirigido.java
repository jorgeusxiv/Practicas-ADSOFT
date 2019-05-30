package adsof1718.grafos;

import java.util.*;

/**
 * Esta clase define el tipo grafo no dirigido, hereda de grafo y define las funciones especificas del grafo no dirigido
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class GrafoNoDirigido<T> extends Grafo<T> {
	
	public GrafoNoDirigido() {
		super();
	}
	
	/**
	 * Anade un arco entre v1 y v2 con peso peso, si existe ya uno lo suma
	 * @param v1
	 * @param v2
	 * @param peso
	 */

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if(v1 == null || v2 == null || peso == 0.0) {
			return;
		}
		
		if (arcos.containsKey(Arrays.asList(v1,v2)) == true) {
			arcos.put(Arrays.asList(v1,v2), peso + arcos.get(Arrays.asList(v1,v2)));
		}
		else if (arcos.containsKey(Arrays.asList(v2,v1)) == true) {
			arcos.put(Arrays.asList(v2,v1), peso + arcos.get(Arrays.asList(v2,v1)));
		}
		else {
			arcos.put(Arrays.asList(v1,v2), peso);
			numArcos++;
		}
		return;
	}
	
	/**
	 * Devuelve el peso del arco entre v1 y v2
	 * @param v1
	 * @param v2
	 * @return peso o 0.0 si hay algun error
	 */

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null) {
			return 0.0;
		}
		if(arcos.containsKey(Arrays.asList(v2,v1)) == false && arcos.containsKey(Arrays.asList(v1,v2)) == false) {
			return 0.0;
		}
		if(arcos.containsKey(Arrays.asList(v2,v1))){
			return arcos.get(Arrays.asList(v2,v1));
		}
		return arcos.get(Arrays.asList(v1,v2));
	}
	
	/**
	 * Devuelve una lista con los vertices conectados a v
	 * @param v
	 * @return lista de vertices
	 */

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		if(v == null) {
			return null;
		}
		List<Vertice<T>> vecinos = new ArrayList<Vertice<T>>();
		for(Vertice<T> vaux: getVertices()) {
			if(arcos.containsKey(Arrays.asList(v,vaux)) || arcos.containsKey(Arrays.asList(vaux,v))){
				vecinos.add(vaux);
			}
		}
		return vecinos;
	}
}
