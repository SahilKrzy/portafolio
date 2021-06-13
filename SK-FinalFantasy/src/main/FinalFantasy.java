package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Arma;
import model.Habilidad;
import model.Partida;
import model.Personaje;


public class FinalFantasy {
	private static ArrayList <Partida> partidas;

	public static void main(String[] args) {
		partidas = new ArrayList <Partida>();
		menu();
	}
	
	public static void menu() {
		Scanner teclado = new Scanner(System.in);
		int opc = 0;
		
		do {
			System.out.println("--Menú Final Fantasy--\n1: Mostrar partidas guardadas\n2: Mostrar info partidas\n0: Salir del programa");
			opc = teclado.nextInt();
			switch(opc) {
			case 0:
				opc = 0;
			break;
			case 1:
				mostrarPatidasGuardadas();
			break;
			case 2:
				mostrarInfo();
			break;
			default:
				System.out.println("ERROR. Opcion invalida.");
				menu();
			}
		} while (opc != 0);
	}
	
	public static void mostrarInfo() {
		if (partidas.isEmpty()){
			System.out.println("No hay informacion para mostrar.\nCreando nueva partida...");
			Partida p = new Partida();
		    partidas.add(p);
		    p.menu();
		} else {
			for (int i = 0; i < partidas.size(); i++) {
				System.out.println("Partida: " + partidas.get(i).toString());
				
				for (int j = 0; j < partidas.get(i).getPersonaje().size(); j++) {
					System.out.println("\t" + partidas.get(i).getPersonaje().get(j).toString());
					
					for (int x = 0; x < partidas.get(i).getPersonaje().get(j).getArma().size(); x++) {
						System.out.println("\t\t" + partidas.get(i).getPersonaje().get(j).getArma().get(x).toString());
						
						for (int k = 0; k < partidas.get(i).getPersonaje().get(j).getArma().get(x).getHabilidad().size(); k++) {
							System.out.println("\t\t\t" + partidas.get(i).getPersonaje().get(j).getArma().get(x).getHabilidad().get(k).toString());
						}
					}
				}
			}
		}
		
	}
	
	public static void mostrarPatidasGuardadas() {
		
		if(partidas.isEmpty()) {
			System.out.println("No hay ninguna partida guardada.\nCreando una nueva partida...");
		    Partida p = new Partida();
		    partidas.add(p);
		    p.menu();
		 } else {
			 int x = JOptionPane.showOptionDialog(null, "Selecciona Partida","PARTIDAS",
					 JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, partidas.toArray(), null);
		     if (x == -1) {
		    	 System.out.println("Creando una nueva partida...");
		    	 Partida p = new Partida();
		    	 partidas.add(p);
		    	 p.menu();
		     }else if(x >=0){
		    	 partidas.get(x).menu();
		     }
		 }
	}

}
