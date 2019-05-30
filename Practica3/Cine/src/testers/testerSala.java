package testers;

/**
 * @brief Esta clase prueba la clase sala.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import Cine.*;
import java.time.LocalDate;

public class testerSala {
  public static void main(String[] args) {

    Sala sala = new Sala(1, 50);

    Pelicula pelicula = new Pelicula("Macario", "Roberto Gavaldon", 1960, "Sinopsis de Macario", Genero.Drama);

    Sesion sesion = new Sesion(LocalDate.of(2018,03,21), pelicula, sala);
    
    Sesion sesionSecundaria = new Sesion(LocalDate.of(2017, 06, 14), pelicula, sala);

    sala.addSesion(sesion);

    if(sala.addSesion(sesion) == false){
      System.out.println("No se puede meter dos veces la misma sesion");
    }
    
    sala.addSesion(sesionSecundaria);

    System.out.println(sala.toString());

  }

}
