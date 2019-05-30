package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import classes.*;
import exceptions.*;
import interfaces.*;

public class TesterAlgoritmo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ArgsDistintosFuncionesException {
		
		List<Funcion> funciones = new ArrayList<>();
		List<Terminal> terminales = new ArrayList<>();
		IDominio domAritm;
		
		
		Terminal x = new TerminalAritmetico("x");
		Funcion suma = new FuncionSuma("+", 2);
		Funcion resta = new FuncionResta("-", 2);
		Funcion multi = new FuncionMultiplicacion("*", 2);
		
		funciones.add((Funcion) suma.copy());
		funciones.add((Funcion) resta.copy());
		funciones.add((Funcion) multi.copy());
		
		multi.incluirDescendiente(x);
		multi.incluirDescendiente(x);
		suma.incluirDescendiente(multi);
		suma.incluirDescendiente(x);
		resta.incluirDescendiente(suma);
		resta.incluirDescendiente(multi);
		
		terminales.add(x);
		
		
		
		domAritm = new DominioAritmetico();
		domAritm.definirValoresPrueba("valores.txt");
		
		IAlgoritmo algoritmo = new Algoritmo(4,15,8,30,0.2);
		System.out.println(algoritmo);
		
		algoritmo.defineConjuntoFunciones(funciones);
		algoritmo.defineConjuntoTerminales(terminales);
		algoritmo.ejecutar(domAritm);
		
	}

}
