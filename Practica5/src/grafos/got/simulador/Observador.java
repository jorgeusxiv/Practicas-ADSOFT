package adsof1718.grafos.got.simulador;

/**
 * Esta clase define el tipo observador que almacena datos y los actualiza segun el subject que tiene
 * 
 * @author Martin de las Heras martin.delasheras@estudiante.uam.es
 * @author Jorge Santisteban jorge.santisteban@estudiante.uam.es
 */

public abstract class Observador {
	
	protected Sujeto subject;
	
	public Observador(Sujeto s) {
		subject = s;
	}
	
	public abstract void actualizar();
}
