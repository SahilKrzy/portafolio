package main;

import java.util.Random;
import java.util.Scanner;
import modelo.Jugador;
import modelo.Ciudad;

public class Catan {

	public static Scanner teclado;
	public static Jugador[] jugadores;
	public static String cartas;
	public static int opc, cont;
	public static String nomjugador;
	public static Jugador cartass;
	public static int contador;
	
	public static void main(String[] args) {
		InicializarJugadores();
		nuevaPartida();
		turnoJugador(jugadores[cont]);
	}

	public static void InicializarJugadores() {
		jugadores = new Jugador[4];
		teclado = new Scanner(System.in);
		opc = 0;
		cont = 0;
		contador = 0;
		for (int i = 0; i < 4; i++) {
			System.out.println("Introduce nombre del Jugador " + (i + 1) + ": ");
			nomjugador = teclado.next();
			jugadores[i] = new Jugador(nomjugador);
		}

	}

	public static void nuevaPartida() {
		System.out.println("Se ha iniciado una nueva partida.");
		turnoJugador(jugadores[cont]);
	}

	private static void turnoJugador(Jugador player) {
		int auxi = 0;

		while (auxi != 1) {
			System.out.println("Le toca al jugador " + jugadores[cont].getNombre());

			player = jugadores[cont];
			menu();
			opc = teclado.nextInt();

			switch (opc) {
			case 1:
				player.getCiudades()[0].getRecurso();
				mostrarCartas(player);
				break;

			case 2:
				comprarCiudad(player);
				break;
			case 3:
				tirarDados(player);
				cont++;
				break;
			}
			if (cont == 4) {
				cont = 0;
			}
		}
	}

	public static void menu() {
		System.out.println("1.- Mostrar cartas");
		System.out.println("2.- Comprar ciudad");
		System.out.println("3.- Tirar dados");
	}

	public static void comprarCiudad(Jugador player) {
		int piedra = 0, madera = 0;
		for (int i = 0; i < player.getCartasLenght(); i++) {
			if (player.getCartas()[i] != "-") {
				if (player.getCartas()[i].equalsIgnoreCase("madera")) {
					madera++;
				} else {
					piedra++;
				}
			}
		}
		if (madera >= 2 && piedra >= 2) {
			boolean sal = true;
			int i = 0;
			while (player.getCiudades()[i] != null && sal) {
				if (i < 10) {
					i++;
				} else {
					i = 0;
					sal = false;
				}
			} 
			if (player.getCiudades()[i] == null) {
					Ciudad city = new Ciudad();
					player.setCiudades(i, city);
					player.RellenarCartas();
					sal = false;
			}
			
		} else {
			System.out.println("No tienes recursos suficientes para comprar una Ciudad.");
		}
	}

	public static void mostrarCartas(Jugador player) {
		for (int x = 0; x < player.getCartasLenght(); x++) {
			System.out.print(player.getCartas()[x] + " ");
		}
		System.out.println();
	}

	public static void tirarDados(Jugador player) {
		Random alea = new Random();
		int dado = alea.nextInt(11) + 2;
		recogerRecursos(dado, player);
	}

	public static void recogerRecursos(int alea, Jugador player) {
		boolean xad = true;
		for (int i = 0; i < player.getCiudades().length; i++) {
			if (player.getCiudades()[i] != null) {
				if (player.getCiudades()[i].getNumero() == alea) {
					for (int x = 0; x < player.getCartasLenght(); x++) {
						if (player.getCartas()[x].equals("-") && xad) {
								String recu = player.getCiudades()[i].getRecurso();
								player.getCartas()[x] = recu;
								xad = false;
								contador++;
						}
					}
				}
			}
		}
	}
}
