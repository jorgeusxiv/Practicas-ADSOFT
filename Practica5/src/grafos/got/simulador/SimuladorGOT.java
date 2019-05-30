package adsof1718.grafos.got.simulador;

import adsof1718.grafos.Vertice;
import adsof1718.grafos.got.GrafoGOT;
import adsof1718.grafos.got.PersonajeGOT;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Esta clase define el tipo SimuladorGOT que simula las interacciones y notifica a los observadores y luego imprime los resultados
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class SimuladorGOT extends Sujeto {
	
	private GrafoGOT g;
	
	public SimuladorGOT(GrafoGOT g) {
		super();
		this.g = g;
	}
	
	/**
	 * Este metodo, mediante el algoritmo explicado en el enunciado hace que un personaje interaccione con sus vecinos
	 * 
	 * @param nombre del personaje que interacciona
	 */
	public void interaccion (String nombre) {
		Random rand = new Random();
		Vertice<PersonajeGOT> v = g.getVertice(nombre);
		Double gradoPonderado = g.getVecinosDe(v).stream().collect(Collectors.summingDouble(v2 -> g.getPesoDe(v,v2)));
		List<PersonajeGOT> destinos = new ArrayList<PersonajeGOT>();
		
		if(super.observadores.isEmpty() || existeObservador(g.getVertice(nombre).getDatos()) == false) {
			observadores.add(new ObservadorGOT(this, g.getVertice(nombre).getDatos()));
		}
		
		for(Vertice<PersonajeGOT> vAux: g.getVecinosDe(v)) {
			if(rand.nextFloat() < g.getPesoDe(v, vAux)/gradoPonderado) {
				destinos.add(vAux.getDatos());
			}
		}
		super.notificar(g.getVertice(nombre).getDatos(), destinos);
	}
	
	/**
	 * Pasa a string la informacion almacenada
	 * 
	 * @return string con la informacion de sus observadores
	 */
	public String toString() {
		String texto = "";
		int i = 1;
		for(ObservadorGOT o: observadores) {
			texto += "Observador " + i + "\n" + o.toString() + "\n";
			i++;
		}
		return texto;
	}
	
	/**
	 * Simula N interacciones de personajes aleatorios del grafo e imprime por pantalla los resultados.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int N = 10000;
		Random rand = new Random();
		GrafoGOT g = new GrafoGOT("got-s01-vertices.csv" ,"got-s01-arcos.csv");
		SimuladorGOT simulador = new SimuladorGOT(g);
		List<String> nombresPersonajes = g.getVertices().stream().map(v -> v.getDatos().getNombre()).distinct().sorted().collect(Collectors.toList());
		for (int n = 0; n < N; n++) {
			String nombre = nombresPersonajes.get(rand.nextInt(nombresPersonajes.size()));
			simulador.interaccion(nombre);
		}
		
		System.out.println(simulador.toString());
	}
}
