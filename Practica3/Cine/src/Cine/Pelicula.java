package Cine;

/**
 * @brief Esta clase define la clase pelicula e implementa los metodos necesarios para su manejo
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */


public class Pelicula {
	
	private String titulo;
	
	private String director;
	
	private Integer anno;
	
	private String sinopsis;
	
	private Genero genero;
	
	/**
	 * @param titulo
	 * @param director
	 * @param anno
	 * @param sinopsis
	 * @param genero
	 */

	public Pelicula(String titulo, String director, Integer anno, String sinopsis, Genero genero) {
		
		if(titulo == null || director == null || anno < 1880 || sinopsis == null) {
			return;
		}

		this.titulo = titulo;
		this.director = director;
		this.anno = anno;
		this.sinopsis = sinopsis;
		this.genero = genero;
	}

	/**
	 * @return Devuelve el titulo de la pelicula
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo Pone el titulo a una pelicula			
	 */
	public void setTitulo(String titulo) {
		if(titulo != null) {
			this.titulo = titulo;
		}	
	}

	/**
	 * @return Devuelve el director de la pelicula 
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director Pone el director a una pelicula
	 */
	public void setDirector(String director) {
		if(director != null) {
			this.director = director;
		}
	}

	/**
	 * @return Devuelve  el año			
	 */
	public Integer getAnno() {
		return anno;
	}

	/**
	 * @param anno Pone el anno a una pelicula
	 */
	public void setAnno(Integer anno) {
		if(anno > 1880) {
			this.anno = anno;
		}
	}

	/**
	 * @return Devuelve  la sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @param sinopsis Pone sinopsis a una pelicula
	 */
	public void setSinopsis(String sinopsis) {
		if(sinopsis != null) {
			this.sinopsis = sinopsis;
		}
	}

	/**
	 * @return Devuelve el genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero Pone el genero a una pelicula
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	/**
	 * @return string con los datos de la pelicula
	 */
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director
				+ ", anno=" + anno + ", sinopsis=" + sinopsis + ", genero="
				+ genero + "]";
	}
	
}
