package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Partida {

	private ArrayList <Personaje> personajes;
	private String nombre;
	private long milis;
	
	public Partida() {
		personajes = new ArrayList<Personaje>();
		this.nombre = (new Date()).toString();
		this.milis = 0;
	}
	
	public void menu() {
		Scanner teclado = new Scanner(System.in);		
		int opc;
		this.milis = System.currentTimeMillis();
		do {
			System.out.println("--Menú Partida--\n1: Mostrar pesonaje\n"
				+ "2: Crear nuveo personaje\n3: Seleccionar personaje\n0: Salir");
			opc = teclado.nextInt();
			switch(opc) {
			case 0:
				System.out.println("Saliendo...");
				finDia();
			break;
			case 1:
				mostrarPersonaje();
			break;
			case 2:
				nuevoPersonaje();
			break;
			case 3:
				seleccionarPersonaje();
			break;
			default:
				System.out.println("ERROR. VUELVE A SELECCIONAR UNA OPCION.");
				menu();
			break;
			}
		} while(opc != 0);
		
	}

	private void finDia() {
		long tiempo2 = System.currentTimeMillis();
		this.milis = (tiempo2 - this.milis ) / 1000;
		System.out.println("La partida ha durado " + this.milis + " segundos.");
	}

	private void seleccionarPersonaje() {
		if (personajes.isEmpty()) {
			System.out.println("Primero crea un personaje");
		} else {
			int pj = JOptionPane.showOptionDialog(null, "Selecciona personaje","PERSONAJES", JOptionPane.YES_NO_CANCEL_OPTION,
					 JOptionPane.PLAIN_MESSAGE, null, personajes.toArray(), null);
			if (pj != -1) {
				this.personajes.get(pj).menu();
			} else {
				System.out.println("Se ha cerrado la ventana de seleccion.");
			}
		}
	}

	private void nuevoPersonaje() {
		Personaje p = new Personaje();
		personajes.add(p);
		p.menu();
	}

	private void mostrarPersonaje() {
		if (personajes.isEmpty()) {
			System.out.println("No hay personajes a mostrar.");
		} else {
			for (int i = 0; i < personajes.size(); i++) {
				System.out.println(personajes.get(i) + " ");
			}
		}
		
	}
	public ArrayList <Personaje> getPersonaje() {
		return this.personajes;
	}

	@Override
	public String toString() {
		return "Partida: " + this.nombre + " de " + this.milis + " segundos.";
	}
}
