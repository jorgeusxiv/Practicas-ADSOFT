package tests;

import java.util.*;

import classes.*;
import exceptions.*;
import interfaces.*;

public class TesterCruce {
	public static void main(String[] args) {
		PruebaCruce prueba = new PruebaCruce();
		List<IIndividuo> descendientes = new ArrayList<IIndividuo>();
		Terminal x = new TerminalAritmetico("x");
		Funcion suma = new FuncionSuma("+", 2);
		Funcion resta = new FuncionResta("-", 2);
		Funcion multi = new FuncionMultiplicacion("*", 2);
		multi.incluirDescendiente(x);
		multi.incluirDescendiente(x);
		suma.incluirDescendiente(multi);
		suma.incluirDescendiente(x);
		resta.incluirDescendiente(suma);
		resta.incluirDescendiente(multi);

		IIndividuo prog1 = new Individuo();
		prog1.setExpresion(resta);
		((Individuo) prog1).etiquetaNodos();
		IIndividuo prog2 = new Individuo();
		prog2.setExpresion(suma);
		((Individuo) prog2).etiquetaNodos();
		System.out.println();
		System.out.println("PROGENITOR 1");
		prog1.writeIndividuo();
		System.out.println("PROGENITOR 2");
		prog2.writeIndividuo();
		try {
			descendientes = prueba.cruce(prog1, prog2);
			System.out.println();
			System.out.println("DESCENDIENTE 1");
			((Individuo)descendientes.get(0)).writeIndividuo();
			System.out.println("DESCENDIENTE 2");
			((Individuo)descendientes.get(1)).writeIndividuo();
		} catch (CruceNuloException e) {
			e.printStackTrace();

		}
	}
}
