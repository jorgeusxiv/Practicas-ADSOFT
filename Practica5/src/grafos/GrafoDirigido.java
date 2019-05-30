package adsof1718.grafos;

import java.util.*;

/**
 * Esta clase define el tipo grafo dirigido, hereda de grafo y define las funciones especificas del grafo dirigido
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class GrafoDirigido<T> extends Grafo<T> {
	
	public GrafoDirigido() {
		super();
	}
	
	/**
	 * Anade un arco que va de v1 a v2 con peso peso, si existe ya uno lo suma
	 * @param v1
	 * @param v2
	 * @param peso
	 */

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if(v1 == null || v2 == null || peso == 0.0) {
			return;
		}
		if(arcos.containsKey(Arrays.asList(v1,v2)) == false) {
			arcos.put(Arrays.asList(v1,v2), peso);
			numArcos++;
		}
		else {
			arcos.put(Arrays.asList(v1,v2), peso + arcos.get(Arrays.asList(v1,v2)));
		}
	}
	
	/**
	 * Devuelve el peso del arco que va de v1 a v2
	 * @param v1
	 * @param v2
	 * @return peso o 0.0 si hay algun error
	 */

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null || arcos.containsKey(Arrays.asList(v1,v2)) == false) {
			return 0.0;
		}
		return arcos.get(Arrays.asList(v1,v2));
	}
	
	/**
	 * Devuelve una lista con los vertices conectados a v mediante un arco que salga de v
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
			if(arcos.containsKey(Arrays.asList(v,vaux))){
				vecinos.add(vaux);
			}
		}
		return vecinos;
	}
}
