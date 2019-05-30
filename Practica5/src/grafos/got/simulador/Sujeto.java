package adsof1718.grafos.got.simulador;

import java.util.ArrayList;
import java.util.List;

import adsof1718.grafos.got.PersonajeGOT;

/**
 * Esta clase define el tipo Sujeto que notifica a los observadores y simula
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public abstract class Sujeto {
	
	protected List<ObservadorGOT> observadores;
	private PersonajeGOT origen;
	private List<PersonajeGOT> destinos;
	
	public Sujeto() {
		observadores = new ArrayList<ObservadorGOT>();
	}
	
	/**
	 * Este metodo notifica a los observadores de que alguien a interaccionado y estos se actualizan con la informacion del sujeto
	 * 
	 * @param personaje origen
	 * @param destinos personajes con los que interacciona origen
	 */
	public void notificar(PersonajeGOT origen, List<PersonajeGOT> destinos) {
		this.origen = origen;
		this.destinos = destinos;
		for(ObservadorGOT o: observadores) {
			o.actualizar();
		}
	}
	
	/**
	 * Funcion que indica si existe el observador de un personaje
	 * 
	 * @param p personaje que queremos comprobar
	 * @return true si ya hay un observador creado para ese personaje, false si no hay o si no existe el personaje
	 */
	public boolean existeObservador(PersonajeGOT p) {
		if(p == null) {
			return false;
		}
		for(ObservadorGOT o: observadores) {
			if(o.getPersonaje().equals(p)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return origen
	 */
	public PersonajeGOT getOrigen() {
		return origen;
	}

	/**
	 * @return lista de destinos
	 */
	public List<PersonajeGOT> getDestinos() {
		return destinos;
	}
}
