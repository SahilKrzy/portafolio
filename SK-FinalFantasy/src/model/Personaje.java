package model;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import main.Recursos;

public class Personaje {
	private ArrayList <Arma> armas;
	private String nombre;
	private String clase;
	
	public Personaje() {
		this.nombre = Recursos.getNombre();
		this.clase = Recursos.getClase();
		armas = new ArrayList <Arma>();
	}
	
	public void menu() {
		Scanner teclado = new Scanner (System.in);
		int opc;
		
		do {
			System.out.println("--Menú Personaje--\n1: Mostrar armas\n2: Crear nueva arma\n3: Seleccionar arma\n0: Salir");
			opc = teclado.nextInt();
			 
			switch(opc) {
			case 0:
				opc = 0;
			break;
			case 1:
				mostrarArmas();
			break;
			case 2:
				nuevaArma();
			break;
			case 3:
				seleccionarArma();
			break;
			default:
				System.out.println("ERROR. Opcion incorrecta.");
				menu();
			}
		} while (opc != 0);
		
		
	}

	private void seleccionarArma() {
		if(armas.isEmpty()) {
			System.out.println("Primero crea un arma.");
		} else {
			int op =JOptionPane.showOptionDialog(null, "Selecciona armas","ARMAS", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, armas.toArray(), null);
			if (op != -1) {
				this.armas.get(op).menu();
			} else {
				System.out.println("Se ha cerrado la ventana de seleccion.");
			}
		}
	}

	private void nuevaArma() {
		Arma a = new Arma();
		armas.add(a);
		a.menu();
	}

	private void mostrarArmas() {
		if (armas.isEmpty()) {
			System.out.println("No hay armas a mostrar.");
		} else {
			for (int i = 0; i < armas.size(); i++) {
				System.out.println(armas.get(i).toString() +" ");
			}
		}
		
	}
	
	public ArrayList <Arma> getArma(){
		return this.armas;
	}

	@Override
	public String toString() {
		return nombre + " (" + clase + ")";
	}

}
