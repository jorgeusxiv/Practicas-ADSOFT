/**
 * @brief Esta clase prueba la clase pelicula.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */
package testers;

import Cine.Pelicula;
import Cine.Genero;

public class testerPelicula {
	public static void main(String args[]) {
		
		Pelicula pelicula;
		
		pelicula = new Pelicula("Macario", "Roberto Gavaldon", 1960, "Sinopsis de Macario", Genero.Drama);
		
		System.out.println(pelicula.toString());
		
		pelicula.setTitulo("Lolita");
		pelicula.setDirector("Stanley Kubrick");
		pelicula.setSinopsis("Sinopsis de Lolita");
		pelicula.setAnno(1962);
		pelicula.setGenero(Genero.Drama);
		
		System.out.println(pelicula.toString());
	}

}
