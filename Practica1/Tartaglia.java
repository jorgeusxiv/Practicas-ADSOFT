/**
  * Esta aplicación escribe por pantalla el triangulo de Tartaglia de orden n
  * sea n un argumento dado por el usuario
  */


public class Tartaglia{

  private Combinatoria c;
  private int n;

  public Tartaglia (Combinatoria c, int n){
    this.n = n;
    this.c = c;
  }

  public String toString(){
    String triangulo = "";
    for (int i = 0; i < n; i++){
      for (int j = 0; j <= i; j++){
        triangulo = triangulo + c.combinaciones(i, j) + " ";
      }
      triangulo = triangulo + "\n";
    }
    return triangulo;
  }

  public static void main(String[] args) {
     if (args.length!=1) {
       System.out.println("Se espera un número como parámetro, n.");
       System.out.println("  n = Número de filas del triángulo ");
       System.out.println("Devuelve el triángulo de Tartaglia de orden n");
     }
     else {
       int n  = Integer.parseInt(args[0]);   // convertimos String a int
       Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
       System.out.println(new Tartaglia(c, n)); // Imprimimos una línea por salida estándar
       // En java la destrucción de objetos es automática
     }
  }
}
