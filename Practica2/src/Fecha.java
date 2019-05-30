/**
  * Esta clase define fecha e implementa los métodos que imprimen fecha y
  * comprueba que la fecha es válida.
  *
  * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
  * @author Martin de las Heras martin.delasheras@estudiante.uam.es
  */

public class Fecha {

  private Integer anyo;

  private Integer mes;

  private Integer dia;

  public Fecha(Integer dia, Integer mes, Integer anyo){

    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;

  }

  /**
   * Guarda los datos de fecha en un string.
   * @return string con la fecha completa.
   */

  public String toString() {
    String fecha = "";
    fecha = dia + "/" + mes + "/" + anyo;
  return fecha;
  }

  /**
   * Comprueba si la fecha es válida, comprueba si el número de mes es correcto
   * y en los días comprueba según el mes si tiene un número válido.
   * @return un resultado tipo bool que indica si es válida o no la fecha
   */

  public Boolean isFechaValida() {

    if(dia <= 0 || dia > 31) return false;

    if(mes <= 0 || mes > 12) return false;

    if (anyo <= 0) return false;

    if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
      if (dia > 30) return false;
    }

    if (mes == 2){
      if(anyo % 4 == 0){
        if(anyo % 100 == 0 && anyo % 400 != 0){
          if (dia > 28) return false;
        }else{
          if (dia > 29) return false;
        }
      }else{
        if (dia > 28) return false;
      }
    }
  return true;
  }

}
