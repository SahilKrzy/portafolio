package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Casa;
import model.Objeto;
import model.Personaje;
import model.Ubicacion;

public class ThisWarOfMine {

	public static Casa casa;

	public static void main(String[] args) {
		generateCharacter();
	}

	public static void generateCharacter() {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		personajes.add(new Personaje("ARICA", "SIGILO"));
		personajes.add(new Personaje("BRUNO", "COCINA"));
		personajes.add(new Personaje("KATIA", "ELOCUENCIA"));
		personajes.add(new Personaje("PAVEL", "RAPIDEZ"));
		getCharacter(personajes);
	}

	public static void getCharacter(ArrayList<Personaje> personajes) {
		Scanner teclado = new Scanner(System.in);
		int per1, per2, per3;
		ArrayList<Personaje> seleccionados = new ArrayList<Personaje>();
		for (int i = 0; i < personajes.size(); i++) {
			System.out.println(i + 1 + ".- " + personajes.get(i).getNombre());
		}

		System.out.println("Seleccione los personajes con los que desee jugar: (SOLO SE PUEDEN ELEGIR 3)");
		per1 = teclado.nextInt();
		per2 = teclado.nextInt();
		per3 = teclado.nextInt();

		if (per1 < 5 && per2 < 5 && per3 < 5) {
			seleccionados.add(personajes.get(per1 - 1));
			seleccionados.add(personajes.get(per2 - 1));
			seleccionados.add(personajes.get(per3 - 1));
			nuevaPartida(seleccionados);
		} else {
			System.out.println(" ");
			System.out.println("ERROR. SOLO PUEDES SELECCIONAR ESOS PERSONAJES");
			generateCharacter();
		}

	}

	public static void nuevaPartida(ArrayList<Personaje> seleccionados) {
		casa = new Casa();
		Scanner teclado = new Scanner(System.in);
		int nivel = 1, opc = 0;
		System.out.println("SE HA INIZIADO UNA NUEVA PARTIDA\n");
		while (!(checkSalud(seleccionados.get(nivel)) == false)) {
			mostrarObjetos();

			Ubicacion ubica = generateUbicacion(nivel, seleccionados);
			nivel++;
		}
		System.out.println("GAME OVER. Ha muerto uno de los civiles.");
	}

	public static boolean checkSalud(Personaje personaje) {
		if (personaje.getSalud() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private static void mostrarObjetos() {
		System.out.println("INVENTARIO DE LA CASA:\n");
		for (int i = 0; i < casa.getObjetos().size(); i++) {
			System.out.println(i + 1 + ".- " + casa.getObjetos().get(i).toString());
		}
	}

	public static Ubicacion generateUbicacion(int nivel, ArrayList<Personaje> seleccionados) {
		Ubicacion ubi = new Ubicacion(nivel, seleccionados);
		if (ubi.getObjetos().isEmpty()) {
			System.out.println("BUSCANDO OTRA UBICACION...");
			generateUbicacion(nivel, seleccionados);
		} else {
			escogerRoles(seleccionados, nivel, ubi);
		}
		return ubi;
	}

	public static void escogerRoles(ArrayList<Personaje> seleccionados, int nivel, Ubicacion ubica) {
		Scanner teclado = new Scanner(System.in);
		boolean salir = true;
		int rol = 0, pj = 0;
		System.out.println(" ");
		System.out.println("SELECCIONA EL ROL Y LUEGO EL JUGADOR.");

		for (int x = 0; x < seleccionados.size(); x++) {
			System.out.println("1)DURMIENDO\n2)VIGILANDO\n3)EXPLORANDO");
			rol = teclado.nextInt();
			for (int i = 0; i < seleccionados.size(); i++) {
				System.out.println(i + ".- " + seleccionados.get(i).getNombre());
			}
			pj = teclado.nextInt();
			if (rol == 1 && pj == 0 || rol == 1 && pj == 1 || rol == 1 && pj == 2) {
				seleccionados.get(pj).dormir();
			} else if (rol == 2 && pj - 1 == 0 || rol == 2 && pj - 1 == 1 || rol == 2 && pj - 1 == 2) {
				String player = seleccionados.get(pj).getHabilidad();
				seleccionados.get(pj).vigilar(nivel, player, ubica);
			} else if (rol == 3 && pj - 1 == 0 || rol == 3 && pj - 1 == 1 || rol == 3 && pj - 1 == 2) {
				seleccionados.get(pj).explorar(ubica);
			} else {
				System.out.println("ERROR. NUMERO INVALIDO.");
				x--;
			}
		}
		finDia(seleccionados);
	}

	public static void finDia(ArrayList<Personaje> seleccionados) {
		Scanner teclado = new Scanner(System.in);
		int opc = 0;
		int count = 0;
		System.out.println("DEJANDO LAS COSAS DE LA MOCHILA EN CASA...");
		for (int x = 0; x < seleccionados.size(); x++) {
			for (int i = 0; i < seleccionados.get(x).getObjetos().size(); i++) {
				casa.objetos.addAll(seleccionados.get(x).getObjetos());
				seleccionados.get(x).getObjetos().clear();
			}
			seleccionados.get(x).setSleep();
		}
		for (int i = 0; i < casa.objetos.size(); i++) {
			if (casa.objetos.get(i).getTipo().equals("Comida") && casa.objetos.get(i).getCantidad() == 1) {
				System.out.println("Gastar 1 de comida a cambio de disminuir 1 el hambre de un jugador?\n1.- SI\n2.- NO");
				opc = teclado.nextInt();
				if (opc == 1) {
					int player = 0;
					casa.objetos.remove(casa.objetos.get(i));
					System.out.println("A quien le quieres dar de comer?");
					for (int j = 0; j < seleccionados.size(); j++) {
						System.out.println(j + ".- " + seleccionados.get(j).getNombre() + " ----> Hambre: "
								+ seleccionados.get(j).getHambre());
					}
					player = teclado.nextInt();
					seleccionados.get(player).restarHambre();
					while (player > 2 && player < 0) {
						System.out.println("ERROR. ELIGE UNO DE LOS JUGADORES.");
						player = teclado.nextInt();
					}
				}
				while (opc > 2 && opc < 1) {
					System.out.println("ERROR. ELIGE 1 o 2.");
					opc = teclado.nextInt();
				}
			}
			if (casa.objetos.get(i).getTipo().equals("Componentes")) {
				count++;
				casa.objetos.remove(casa.objetos.get(i));
				if (count == 5) {
					System.out.println("Tienes 5 de componentes, que quieres hacer? 1.-Generar 2 de comida.\n2.- Generar 1 de medicamentos.");
					opc = teclado.nextInt();
					if (opc == 1) {
						System.out.println("Gastar 5 componentes a cambio de generar 2 de comida?1.- SI\n2.- NO");
						opc = teclado.nextInt();
						if (opc == 1) {
							casa.generarComida();
						}
						while (opc > 2 && opc < 1) {
							System.out.println("ERROR. ELIGE 1 o 2.");
							opc = teclado.nextInt();
						}
					} else if (opc == 2) {
						System.out.println("Gastar 5 componentes a cambio de generar 1 de medicamentos?1.- SI\n2.- NO");
						opc = teclado.nextInt();
						if (opc == 1) {
							casa.objetos.add(new Objeto("Medicamentos", 1));
						}
						while (opc > 2 && opc < 1) {
							System.out.println("ERROR. ELIGE 1 o 2.");
							opc = teclado.nextInt();
						}
					}
					while (opc > 2 && opc < 1) {
						System.out.println("ERROR. ELIGE 1 o 2.");
						opc = teclado.nextInt();
					}
				} else if (count == 10) {
					System.out.println("Gastar 10 componentes a cambio de generar una cama?1.- SI\n2.- NO");
					opc = teclado.nextInt();
					if (opc == 1) {
						casa.generarCama(true);
					}
					while (opc > 2 && opc < 1) {
						System.out.println("ERROR. ELIGE 1 o 2.");
						opc = teclado.nextInt();
					}
				}
			}
			
			if (casa.objetos.get(i).getTipo().equals("Medicamentos") && casa.objetos.get(i).getCantidad() == 1) {
				System.out.println("Gastar 1 de medicamentos a cambio de aumentar 1 la vida de un jugador?\n1.- SI\n2.- NO");
				opc = teclado.nextInt();
				if (opc == 1) {
					casa.objetos.remove(casa.objetos.get(i));
					System.out.println("A quien quieres curar?");
					for (int j = 0; j < seleccionados.size(); j++) {
						System.out.println(j + ".- " + seleccionados.get(j).getNombre() + " ----> Salud: "+ seleccionados.get(j).getSalud());
					}
					int healt = teclado.nextInt();
					seleccionados.get(healt).recuperarSalud();
					while (healt > 2 && healt < 0) {
						System.out.println("ERROR. ELIGE UNO DE LOS JUGADORES.");
						healt = teclado.nextInt();
					}
					
				}
				while (opc > 2 && opc < 0) {
					System.out.println("ERROR. ELIGE UNO DE LOS JUGADORES.");
					opc = teclado.nextInt();
				}
			}
			for (int j = 0; j < seleccionados.size(); j++) {
				if (seleccionados.get(j).getHambre() >= 1) {
					seleccionados.get(j).restarSalud(1);
				}
				if (seleccionados.get(j).getHambre() == 5) {
					seleccionados.get(j).setSalud(0);
				}
				if (seleccionados.get(j).getSleep() % 2 == 0) {
					seleccionados.get(j).restarSalud(1);
				}
				if (seleccionados.get(j).getSleep() == 5) {
					seleccionados.get(j).setSalud(0);
				}
			}
			
		}

	}
}
