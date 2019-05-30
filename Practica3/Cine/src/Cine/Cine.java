package Cine;

/**
 * @brief Esta clase define la clase cine e implementa los metodos necesarios para su manejo.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Cine {

	private String nombre;

	private String direccion;

	private List<Entrada> entradas = new ArrayList<Entrada>();

	private List<Sala> salas = new ArrayList<Sala>();

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	/**
	 * @param nombre
	 * @param direccion
	 * @param entradas
	 * @param salas
	 * @param peliculas
	 */

	public Cine(String nombre, String direccion) {
		
		if(nombre == null || direccion == null) {
			return;
		}
		this.nombre = nombre;
		this.direccion = direccion;
	}

	/**
	 * @return Devuelve el nombre del cine
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Pone el nombre al cine
	 */
	public void setNombre(String nombre) {
		if(nombre != null) {
			this.nombre = nombre;
		}
	}

	/**
	 * @return Devuelve la direccion del cine
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion Pone la direccion al cine
	 */
	public void setDireccion(String direccion) {
		if(direccion != null) {
			this.direccion = direccion;
		}
	}

	/**
	 * @return Devuelve la lista de entradas del cine
	 */
	public List<Entrada> getEntradas() {
		return entradas;
	}


	/**
	 * @return Devuelve las salas del cine
	 */
	public List<Sala> getSalas() {
		return salas;
	}

	/**
	 * @return Devuelve las peliculas del cine
	 */
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	/**
	 *
	 * @param pelicula
	 * @return true si se ha anadido bien y si no false
	 */

	public Boolean anadirPelicula(Pelicula pelicula){

		if(peliculas.contains(pelicula) || pelicula == null){
				return false;
			}

		peliculas.add(pelicula);

		return true;
	}

	/**
	 *
	 * @param sala
	 * @return true si se ha anadido bien y si no false
	 */

	public Boolean anadirSala(Sala sala){

		if(salas.contains(sala) || sala == null){
			return false;
		}

		salas.add(sala);

		return true;
	}

	/**
	 * @param sesion
	 * @return true si se ha anadido bien y si no false
	 */
	public Boolean anadirSesion(Sesion sesion){

		List<Sala> salasAux = salas;
		
		if(sesion == null) {
			return false;
		}

		for(Sala aux:salasAux){
			if(aux.getIdentificador().equals(sesion.getSala().getIdentificador())){
				if(aux.addSesion(sesion) == true){
					return true;
				}
			return false;
			}
		}
		return false;
	}

	/**
	 * @param precio
	 * @param sesion
	 * @return
	 */
	public Boolean addEntrada(double precio, Sesion sesion){

		if(sesion.getButacasdisponibles().equals(0) || sesion == null || precio < 0.00){
			return false;
		}

		Entrada entradanueva;


		if(sesion.getFecha().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)){
			entradanueva = new EntradaDiaEspectador(precio,sesion);
		}else{
			entradanueva = new Entrada(precio,sesion);
		}

		sesion.actualizarButacasVendidas(1);
		entradas.add(entradanueva);

		return true;
	}

	/**
	 * @return recaudacion String que indica la recaudacion total
	 */
	public Double recaudacionCine(){

		Double sum = 0.000;

		for(Entrada aux: entradas){
			sum += aux.getPrecio();
		}

		return sum;

	}

	/**
	 *
	 * @return todas las sesiones del cine
	 */

	public List<Sesion> sesiones(){

		List<Sesion> sesiones = new ArrayList<Sesion>();

		for(Sala auxSala: salas) {
			for(Sesion auxSesion: auxSala.getSesiones()) {
				sesiones.add(auxSesion);
			}
		}

		return sesiones;
	}

	/**
	 *
	 * @param pelicula
	 * @return true si se elimina bien y false si no
	 */

	public boolean eliminarPelicula(Pelicula pelicula){

		if(peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
		}
		else{
			return false;
		}

		for (Sala aux : salas){
			for(Sesion sesaux : aux.getSesiones()){
				if(sesaux.getPelicula().equals(pelicula)){
					aux.getSesiones().remove(sesaux);
				}
			}
		}
		return true;
	}

	/**
	 *
	 * @return un string con todas las peliculas
	 */

	public String mostrarPeliculas(){

	  String res = "Las peliculas son: \n";
	  for(Pelicula aux: peliculas){
	    res += aux.getTitulo() + "\n";
	  }

	  return res;
	}

	/**
	 *
	 * @return un string con las salas.
	 */

	public String mostrarSalas(){

	  String res = "Las salas son: \n";
	  for(Sala aux: salas){
	    res += aux.getIdentificador() + "\n";
	  }

	  return res;
	}


}
