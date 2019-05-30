package classes;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

import exceptions.CruceNuloException;


/**
 * The Class PruebaCruce.
 *
 * @author Jorge Santisteban y Martín de las Heras
 */

public class PruebaCruce {
	
	/**
	 * Instantiates a new prueba cruce.
	 */
	public PruebaCruce(){}
	
	
	
	/**
	 * @brief Realiza el cruce entre dos individuos
	 *
	 * @param IIndividuo el individuo i1
	 * @param IIndividuo el individuo i2
	 * @return List<IIndividuo> la lista con los individuos ya cruzados
	 * @throws CruceNuloException the cruce nulo exception
	 */
	public List<IIndividuo> cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException{
		
		int size;
		List<IIndividuo> indivs = new ArrayList<IIndividuo>();
		
		Individuo i1x, i2x;
		
		i1x = ((Individuo) i1).copy();
		i2x = ((Individuo) i2).copy();
		
		if(i1x.getNumeroNodos() >= i2x.getNumeroNodos()){
			size = i2x.getNumeroNodos();
		}else{
			size = i1x.getNumeroNodos();
		}
		
		int pos1 = (int) (Math.random() * size) + 1;
		int pos2 = (int) (Math.random() * size) + 1;
		
		System.out.println("");
		System.out.println("Punto de cruce del progenitor 1: " + pos1);
		System.out.println("Punto de cruce del progenitor 2: " + pos2);
		System.out.println("");
		
		if(pos1 == 1 && pos2 == 1) throw new CruceNuloException();
		
		Nodo n1 = (Nodo) ((Nodo) i1x.getExpresion()).getNodoEtiqueta(pos1).copy();
		
		Nodo n2 = (Nodo) ((Nodo) i2x.getExpresion()).getNodoEtiqueta(pos2).copy();
		
	
		((Nodo) i1x.getExpresion()).cambiarNodoEtiqueta(n2, pos1);
		
		((Nodo) i2x.getExpresion()).cambiarNodoEtiqueta(n1, pos2);
		
		i1x.etiquetaNodos();
		i2x.etiquetaNodos();
		
		
		indivs.add(i1x);
		indivs.add(i2x);
		
		return indivs;
		
	}

}
