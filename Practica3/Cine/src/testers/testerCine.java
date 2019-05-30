package testers;

/**
 * @brief Esta clase prueba la clase cine y la integracion del proyecto.
 *
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 */

import Cine.*;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class testerCine {
  public static void main(String[] args) {

	DecimalFormat numberFormat = new DecimalFormat("#.00");

    Cine cine = new Cine("Proyecciones Javil", "Boulevard del Dia");

    Pelicula pelicula1 = new Pelicula("Macario", "Roberto Gavaldon", 1960, "Sinopsis de Macario", Genero.Drama);
    Pelicula pelicula2 = new Pelicula("Lolita", "Stanley Kubrick", 1962, "Sinopsis de Lolita", Genero.Drama);

    Sala sala = new Sala(1, 50);

    Sesion sesion = new Sesion(LocalDate.of(2018,03,21), pelicula1, sala);

    Entrada entrada = new Entrada(4.5, sesion);

    EntradaDiaEspectador entradaEspectador = new EntradaDiaEspectador(4.5, sesion);

    sala.addSesion(sesion);

    System.out.println(entrada.toString());

    System.out.println(entradaEspectador.toString());

    if(cine.anadirPelicula(pelicula1) == false){
      System.out.println("No se ha annadido la pelicula");
    }

    if(cine.anadirPelicula(pelicula1) == true){
      System.out.println("Se ha annadido dos veces la misma pelicula");
    }

    if(cine.anadirPelicula(pelicula2) == false){
      System.out.println("No se ha annadido la pelicula");
    }

    if(cine.anadirSesion(sesion) == true){
      System.out.println("Se ha annadido dos veces la misma sesion");
    }

    System.out.println("Entradas disponibles antes de la compra: " + sesion.getButacasdisponibles());

    if(cine.addEntrada(4.5, sesion) == true){
      System.out.println("Ha comprado una entrada para la pelicula " + sesion.getPelicula().getTitulo() + " el dia " + sesion.getFecha() + " y la sala " + sesion.getSala().getIdentificador());
    }

    System.out.println("Entradas disponibles despues de la compra: " + sesion.getButacasdisponibles());

    System.out.println("Se han recaudado " + numberFormat.format(cine.recaudacionCine()) + " euros");

    System.out.println(cine.mostrarSalas());

    if(cine.anadirSala(sala) == false){
      System.out.println("No se ha anadido la sala");
    }

    if(cine.anadirSala(sala) == true){
      System.out.println("Se ha anadido dos veces la misma sala");
    }

    System.out.println(cine.mostrarSalas());

    System.out.println(cine.mostrarPeliculas());

    if(cine.eliminarPelicula(pelicula2) == false){
      System.out.println("No se ha eliminado la pelicula");
    }

    System.out.println(cine.mostrarPeliculas());

  }

}
