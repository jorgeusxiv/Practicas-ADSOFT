package adsof1718.grafos.got;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import adsof1718.grafos.GrafoNoDirigido;
import adsof1718.grafos.Vertice;

/**
 * Esta clase define el tipo grafoGOT que hereda de grafo no dirigido y define las funciones especificas del mismo
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT> {

	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		BufferedReader verticesFichero = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
		BufferedReader arcosFichero = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));
		
		List<String> listaVertices = new ArrayList<String>();
		List<String> listaArcos = new ArrayList<String>();
		String buffer;
		StringTokenizer tok;
		int numTokens, i;
		int idAux = -1;
		String nombreAux = "";
		String casaAux = "";
		int v1Aux = -1;
		int v2Aux = -1;
		double pesoAux;
		
		while((buffer = verticesFichero.readLine()) != null) {
			tok = new StringTokenizer(buffer, ",");
			numTokens = tok.countTokens();
			for(i = 0; i < numTokens; i++) {
				listaVertices.add(tok.nextToken());
			}
			i = 0;
			for(String aux: listaVertices) {
				if(i == 0) {
					idAux = Integer.parseInt(aux);
				}
				else if (i == 1) {
					nombreAux = aux;
				}
				else {
					casaAux = aux;
					addVertice(idAux, new PersonajeGOT(nombreAux, casaAux));
				}
				i++;
			}
			listaVertices.clear();
		}
		verticesFichero.close();

		while((buffer = arcosFichero.readLine()) != null) {
			tok = new StringTokenizer(buffer, ",");
			numTokens = tok.countTokens();
			for(i = 0; i < numTokens; i++) {
				listaArcos.add(tok.nextToken());
			}
			i = 0;
			for(String aux: listaArcos) {
				if(i == 0) {
					v1Aux = Integer.parseInt(aux);
				}
				else if (i == 1) {
					v2Aux = Integer.parseInt(aux);
				}
				else {
					pesoAux = Double.parseDouble(aux);
					addArco(vertices.get(v1Aux), vertices.get(v2Aux), pesoAux);
				}
				i++;
			}
			listaArcos.clear();
		}
		arcosFichero.close();
	}
	
	
	/**
	 * Devuelve el vértice que contiene el personaje cuyo nombre se indica como argumento de entrada.
	 * 
	 * @param nombre
	 * @return vertice del personaje pasado
	 */
	public Vertice<PersonajeGOT> getVertice(String nombre) {
		List<Vertice<PersonajeGOT>> lista = getVertices().stream().filter(v -> v.getDatos().getNombre().equals(nombre)).collect(Collectors.toList());
		
		if(lista.isEmpty()) {
			return null;
		}
		
		return lista.get(0);
	}

	/**
	 * Devuelve una lista con los nombres de las casas sin repeticiones, ordenadas, y sin valores null
	 * 
	 * @return lista con los nombres de las casas
	 */
	public List<String> casas() {
		return getVertices().stream().map(v -> v.getDatos().getCasa()).filter(c -> !c.equals("null")).distinct().sorted().collect(Collectors.toList());
	}
	
	/**
	 * Devuelve una lista con los nombres de los personajes de una casa indicada como argumento de entrada.
	 * 
	 * @param casa
	 * @return lista de los miembros de la casa
	 */
	public List<String> miembrosCasa(String casa) {
		Predicate<Vertice<PersonajeGOT>> esDe = v -> v.getDatos().getCasa().equals(casa);
		return getVertices().stream().filter(esDe).map(v -> v.getDatos().getNombre()).collect(Collectors.toList());
	}
	
	/**
	 * Devuelve los personajes y sus “grados”, esto es el número de vecinos que tiene cada vértice.
	 * 
	 * @return map con los grados de los personajes
	 */
	public Map<String, Integer> gradoPersonajes() {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		getVertices().forEach(v-> {mapa.put(v.getDatos().getNombre(), getVecinosDe(v).size());});
		return mapa;
	}
	
	/**
	 * Devuelve los personajes y sus “grados ponderados”, esto es la suma de los pesos de los arcosFichero que unen a cada vértice con sus vecinos.
	 * 
	 * @return map con los grados ponderados de los personajes
	 */
	public Map<String, Integer> gradoPonderadoPersonajes() {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		ToDoubleFunction<Vertice<PersonajeGOT>> ponderado = v-> getVecinosDe(v).stream().collect(Collectors.summingDouble(v2 -> getPesoDe(v,v2)));
		
		getVertices().forEach(v-> {
			mapa.put(v.getDatos().getNombre(), (int) Math.round(ponderado.applyAsDouble(v)));
			});
		
		return mapa;
	}
	
	/**
	 * Devuelve los personajes y sus “grados ponderados”, pero sólo para aquellos personajes cuyo grado ponderado es superior al grado ponderado medio en la red social.
	 * 
	 * @return map con los personajes cuyo grado ponderado supera la media
	 */
	public Map<String, Integer> personajesRelevantes() {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		ToDoubleFunction<Vertice<PersonajeGOT>> gradoPonderado = v-> getVecinosDe(v).stream().collect(Collectors.summingDouble(v2 -> getPesoDe(v,v2)));
		
		Double media = getVertices().stream().collect(Collectors.averagingDouble(v2 -> gradoPonderado.applyAsDouble(v2)));
		
		Predicate<Vertice<PersonajeGOT>> superaMedia = v -> gradoPonderado.applyAsDouble(v) > media;
		
		getVertices().stream().filter(superaMedia).forEach(v -> {
			mapa.put(v.getDatos().getNombre(), (int) Math.round(gradoPonderado.applyAsDouble(v)));
		});
		return mapa;
	}
}
