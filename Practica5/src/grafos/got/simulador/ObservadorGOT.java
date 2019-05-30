package adsof1718.grafos.got.simulador;

import java.util.*;
import adsof1718.grafos.got.PersonajeGOT;

/**
 * Esta clase define el tipo observadorGOT que hereda de Observador y que se almacena y actualiza la informacion de un personaje
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public class ObservadorGOT extends Observador {
	private PersonajeGOT p;
	private Map<String, Integer> casas;
	private Integer vecesCasa;
	private Integer interaccionesTotales;

	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		super(s);
		this.p = p;
		casas = new HashMap<String, Integer>();
		interaccionesTotales = 0;
		vecesCasa = 0;
	}

	/**
	 * Este metodo actualiza la informacion en funcion de los datos que tiene el simulador, si el origen es el personaje del observador mira la lista de destinos y actualiza
	 * las interacciones, si el personaje esta entre los destinos, actualiza segun la informacion del origen
	 */
	public void actualizar() {
		SimuladorGOT simulador = (SimuladorGOT) super.subject;
		PersonajeGOT origen = simulador.getOrigen();
		List<PersonajeGOT> destinos = simulador.getDestinos();
		
		if(origen.equals(p) == true) {
			for(PersonajeGOT p: destinos) {
				if(p.getCasa().equals(this.p.getCasa())) {
					vecesCasa++;
				}
				else if (casas.containsKey(p.getCasa())) {
					casas.put(p.getCasa(), casas.get(p.getCasa()) + 1);
				}
				else {
					casas.put(p.getCasa(), 1);
				}
				interaccionesTotales++;
			}
		}
		else if(destinos.contains(p)) {
			if(origen.getCasa().equals(this.p.getCasa())) {
				vecesCasa++;
			}
			else if(casas.containsKey(origen.getCasa())) {
				casas.put(origen.getCasa(), casas.get(origen.getCasa()) + 1);
			}
			else {
				casas.put(origen.getCasa(), 1);
			}
			interaccionesTotales++;
		}
		return;
	}
	
	public PersonajeGOT getPersonaje() {
		return p;
	}

	/**
	 * @return Devuelve una string con la informacion del observador
	 */
	@Override
	public String toString() {
		return p.getNombre() + "\n Interacciones: " + interaccionesTotales + "\n  Con miembros de su casa: " + vecesCasa + "\n  Con miembros de casa ajena\n   : "
				+  (interaccionesTotales-vecesCasa) + "\n   " + casas;
	}
	
	
	
}
