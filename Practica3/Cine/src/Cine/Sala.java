package Cine;

/**
 * @brief Esta clase define la clase sala e implementa los metodos necesarios para su manejo.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import java.util.*;

public class Sala {

	private Integer identificador;

	private Integer butacas;

	private List<Sesion> sesiones = new ArrayList<Sesion>();

	/**
	 * @param identificador
	 * @param butacas
	 * @param sesiones
	 */
	public Sala(Integer identificador, Integer butacas) {
		
		if(identificador < 0 || butacas < 0) {
			return;
		}
		this.identificador = identificador;
		this.butacas = butacas;
	}

	/**
	 * @return Devuelve el identificador
	 */
	public Integer getIdentificador() {
		return identificador;
	}

	/**
	 * @return Devuelve el numero de butacas
	 */
	public Integer getButacas() {
		return butacas;
	}

	/**
	 * @param butacas Pone butacas que tiene la sala
	 */
	public void setButacas(int butacas) {
		if(butacas > 0) {
			this.butacas = butacas;
		}
	}

	/**
	 * @return Devuelve las sesiones
	 */
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	/**
	 * @param sesiones Annade una sesion a la sala comprobando si esta existe en la sala previamente
	 */
	public boolean addSesion(Sesion sesion) {
		
		if(sesion == null) {
			return false;
		}

		for (Sesion sesionAux: sesiones) {

			if(sesion.getFecha().equals(sesionAux.getFecha())) {

				return false;
			}

		}

		sesiones.add(sesion);

		return true;
	}

	/**
	 * @return un string con la informacion de la sala
	 */


	public String toString() {
		return "Sala [Identificador=" + identificador + ", Butacas=" + butacas
				+ ", Sesiones=" + sesiones + "]";
	}


}
