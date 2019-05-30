package testers;

/**
 * @brief Esta clase prueba la clase sesion.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import Cine.*;
import java.time.LocalDate;

public class testerSesion {
  public static void main(String[] args) {

    Sesion sesion;

    Pelicula pelicula = new Pelicula("Macario", "Roberto Gavaldon", 1960, "Sinopsis de Macario", Genero.Drama);

    Sala sala = new Sala(1, 50);

    sesion = new Sesion(LocalDate.of(2018,03,21), pelicula, sala);

    if(sesion.actualizarButacasVendidas(5) == false){
      System.out.println("No quedan butacas suficientes");
    }

    System.out.println(sesion.toString());

    if(sesion.actualizarButacasVendidas(46) == false){
      System.out.println("No quedan butacas suficientes");
    }

    System.out.println(sesion.toString());
  }

}
