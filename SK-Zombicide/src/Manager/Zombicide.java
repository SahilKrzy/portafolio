package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Arma;
import Model.Jugador;
import Model.Partida;

public class Zombicide {
	private ArrayList<Jugador> personajes;
	private ArrayList<Jugador> seleccionados;
	public Zombicide() {
		personajes = new ArrayList<Jugador>();
		seleccionados = new ArrayList<Jugador>();
		personajes.add(new Jugador("James", 7, new Arma("Mandoble", "Básica", 2, 1, 4)));
		personajes.add(new Jugador("Marie", 5, new Arma("Daga", "Básica", 1, 1, 4)));
		personajes.add(new Jugador("Jaci", 5, new Arma("Daga", "Básica", 1, 1, 4)));
		menu();
	}

	private void menu() {
		Scanner teclado = new Scanner(System.in);
		int opc;
		System.out.println("Bienvenido a Zombicide!");
		do {
			System.out.println("1- Nueva partida\n2- Nuevo personaje\n0- Salir");
			opc = teclado.nextInt();
			switch(opc) {
			case 1: nuevaPartida(); break;
			case 2: nuevoPj(); break;
			case 0: System.err.println("Cerrando juego..."); opc = 0; break;
			default: System.out.println("ERROR. Elige una opcion valida."); menu(); break;
			}
		} while(opc != 0);
		
	}

	private void nuevoPj() {
		Scanner teclado = new Scanner(System.in);
		if (personajes.size() < 11) {
			System.out.println("Que nombre le quieres poner al personaje?");
			String pj = teclado.next();
			personajes.add(new Jugador(pj, 5, new Arma("Daga", "Básica", 1, 1, 4)));
		} else {
			System.out.println("Has llegado al máximo de personajes. No puedes crear más.");
		}
	}

	private void nuevaPartida() {
		Scanner teclado = new Scanner(System.in);
		int s = 0;
		if(personajes.size() == 3) {
			System.out.println("Todos tus personajes han sido selecccinados");
			seleccionados.addAll(personajes);
			Partida P = new Partida(seleccionados, seleccionados.size());
		} else {
			System.out.println("\n0.- Salir de la seleccion");
			System.out.println("Selecciona los personajes con los que vas a jugar: ");
			for (int i = 0; i < personajes.size(); i++) {
				System.out.println(i + 1 + ".- " + personajes.get(i).getNombrePj() + " ");
			}
			do {
				s = teclado.nextInt() - 1;
				if (s != -1) {
					seleccionados.add(personajes.get(s));
				}
			} while(!((seleccionados.size() > 3 || seleccionados.size() < 6) && s == -1));
			Partida P = new Partida(seleccionados, seleccionados.size());
		}
	}
}
