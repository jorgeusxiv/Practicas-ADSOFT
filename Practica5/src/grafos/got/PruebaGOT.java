package adsof1718.grafos.got;

/**
 * Esta clase prueba los metodos de grafoGOT
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class PruebaGOT {
	public static void main(String[] args) throws Exception {
		
		GrafoGOT grafo = new GrafoGOT("got-s01-vertices.csv" ,"got-s01-arcos.csv");
		
		System.out.println(grafo);
		
		System.out.println(grafo.casas());
		
		System.out.print(grafo.miembrosCasa("Stark"));
		
		System.out.print("Grado Personajes: \n");
		System.out.println(grafo.gradoPersonajes());
		
		System.out.print("\nGrado Ponderado Personajes: \n");
		System.out.println(grafo.gradoPonderadoPersonajes());
		
		System.out.println("\nPersonajes Relevantes: \n");
		System.out.println(grafo.personajesRelevantes());		
	}
}
