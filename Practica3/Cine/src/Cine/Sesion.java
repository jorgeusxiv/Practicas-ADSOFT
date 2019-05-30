package Cine;

/**
 * @brief Esta clase define la clase sesion e implementa los metodos necesarios para su manejo.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import java.time.LocalDate;

public class Sesion {

	private LocalDate fecha;

	private Pelicula pelicula;

	private Integer butacasdisponibles;

	private Sala sala;

	/**
	 * @param fecha
	 * @param pelicula
	 * @param butacasdisponibles
	 * @param sala
	 */
	public Sesion(LocalDate fecha, Pelicula pelicula, Sala sala) {
		
		if(sala == null || pelicula == null) {
			return;
		}
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.sala = sala;
		this.butacasdisponibles = sala.getButacas();
	}

	/**
	 * @return Devuelve la fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha Pone la fecha de la sesion
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return Devuelve la pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula Pone la pelicula de la sesion
	 */
	public void setPelicula(Pelicula pelicula) {
		if(pelicula != null) {
			this.pelicula = pelicula;
		}
	}

	/**
	 * @return Devuelve las butacas disponibles
	 */
	public Integer getButacasdisponibles() {
		return butacasdisponibles;
	}

	/**
	 * @param butacasdisponibles Pone la butacas disponibles de la sesion
	 */
	public void setButacasdisponibles(Integer butacasdisponibles) {
		if(butacasdisponibles > 0) {
			this.butacasdisponibles = butacasdisponibles;
		}
	}

	/**
	 * @return la sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * @param sala Pone la sala de la sesion
	 */
	public void setSala(Sala sala) {
		if(sala != null) {
			this.sala = sala;
		}
	}

	/**
	 * @param butacasvendidas que se tienen que restar a las disponibles
	 * @return boolean segun se haya hecho la actualizacion o no
	 */
	public boolean actualizarButacasVendidas(Integer butacasvendidas) {

		if(this.butacasdisponibles < butacasvendidas || butacasvendidas < 0) {

			return false;
		}

		this.butacasdisponibles -= butacasvendidas;

		return true;
	}

	/**
	 * @return un string con toda a informacion de sesion
	 */

	public String toString() {
		return "Sesion [Fecha=" + fecha + ", Pelicula=" + pelicula
				+ ", Butacasdisponibles=" + butacasdisponibles + ", Sala="
				+ sala.getIdentificador() + "]";
	}

}
