/**
  * Esta clase define fecha e implementa los métodos que imprimen fecha y
  * comprueba que la fecha es válida.
  *
  * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
  * @author Martin de las Heras martin.delasheras@estudiante.uam.es
  */

  public class Alumno {

    private String dni;

    private String nombre;

    private String apellido;

    private Fecha matriculacion;

    private String tipocarnet;

  public Alumno(String dni, String nombre, String apellido, Integer anyo,
  Integer mes, Integer dia, String tipocarnet){

   this.dni = dni;

   this.nombre = nombre;

   this.apellido = apellido;

   this.matriculacion = new Fecha(dia, mes, anyo);

   this.tipocarnet = tipocarnet;


 /**
  * 
  * @return  Fecha Devuelve la fecha de matriculacion
  */
 }

 public Fecha getFechaMatr(){
   return this.matriculacion;
 }

 /**
  * Guarda los datos de un alumno en un string.
  * @return string con los datos del alumno.
  */

 public String toString() {
   String alumno = "";
   alumno = "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" +
   "DNI: " + dni + "\n" + "Fecha Matriculacion: " + matriculacion + "\n"
    + "Tipo carnet: " + tipocarnet + "\n";
 return alumno;

 }

}
