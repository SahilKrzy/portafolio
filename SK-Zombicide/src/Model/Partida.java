package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private int nivel, ronda;
	private ArrayList<Jugador> pj;
	private ArrayList<Zombie> z;
	private ArrayList<Arma> armas;
	
	public Partida(ArrayList<Jugador> seleccionados, int nivel) {
		pj = new ArrayList<Jugador>();
		z = new ArrayList<Zombie>();
		armas = new ArrayList<Arma>();
		this.nivel = nivel;
		pj.addAll(seleccionados);
		zombies();
		menu();
	}

	private void menu() {
		Scanner teclado = new Scanner(System.in);
		int ronda = this.ronda;
		int opc, pos = 0;
		boolean fin = true;
		while (fin) {
			for (int i = 0; i < pj.size(); i++) {
				System.out.print("|----- NIVEL: " + this.nivel + " - " + ronda + " -----|"
						+ "\n==| "); mZ(); System.out.print("|==\n"+ pj.get(i).toString() +"\n" + "1- Atacar\n2- Habilidad Especial \n3- Buscar\n4- Cambiar Arma\n0- Pasar");
				opc = teclado.nextInt();
				switch(opc) {
				case 1: atacar(pj.get(i), z); pos++; break;
				case 2: habilidadEspecial(pj.get(i), z); pos++; break;
				case 3: buscar(pj.get(i)); pos++; break;
				case 4: cambiarArma(pj.get(i)); pos++; break;
				case 0: pasar(); pos++; pos++; break;
				default: System.out.println("ERROR. Elige una opcion valida."); menu(); break;
				}
			}
			for(int i=0; i<z.size(); i++) {
                int movimiento = z.get(i).getMovimiento();
                Random alea = new Random();
                if(pj.size() != 0) {
                    int rand = alea.nextInt(pj.size());
                    pj.get(rand).setSalud(movimiento);
                    int salud = pj.get(rand).getSalud();
                    if(salud<=0) {
                        System.out.println("El personaje "+ pj.get(rand).getNombrePj() +" ha muerto. RIP por el 7n7.");
                        pj.remove(rand);
                    }
                }else {
                    System.out.println("Todos los personajeshan muerto asi que ha terminado la partida.");
                    fin = false;
                    break;
                }
                    
            }
			ronda++;
			zombies();
		}
	}

	private void habilidadEspecial(Jugador jugador, ArrayList<Zombie> z2) {
		jugador.getArma().habilidadEspecial(z2);
		
	}

	private void pasar() {
		System.out.println("Pasando turno...");
		
	}

	private void cambiarArma(Jugador jugador) {
		if (armas.isEmpty()) {
			System.out.println("No hay armas para cambiar.");
		} else {
			Scanner teclado= new Scanner(System.in);
			System.out.println("A que Arma quieres cambiar?");
			for (int i = 0; i < armas.size(); i++) {
				System.out.println(i + ".-" + armas.get(i).toString() + " ");
			}
			int armaS = teclado.nextInt();
			Arma a = jugador.getArma();
			jugador.setArma(armas.get(armaS));
			armas.add(a);
			armas.remove(armaS);
		}
		
	}

	private void buscar(Jugador jugador) {
		System.out.println("Buscando objetos...");
		Random alea = new Random(5);
		int obj = alea.nextInt();
		if (obj == 0) {
			System.out.println("Has encontrado una Hacha Doble!");
			armas.add(new Hacha());
		} else if (obj == 1) {
			System.out.println("Has encontrado una Espada Corta!");
			armas.add(new Espada());
		} else if (obj == 2) {
			System.out.println("Has encontrado una Daga!");
			armas.add(new Arma("Daga", "Básica", 1, 1, 4));
		} else if (obj == 3 ) {
			System.out.println("Has encontrado un Arco Largo!");
			armas.add(new Arco());
		} else {
			System.out.println("Has encontrado una Bola de Fuego!");
			armas.add(new Hechizo());
		}
	}

	private void atacar(Jugador jugador, ArrayList<Zombie> z2) {
		 jugador.getArma().atacarE(jugador, z);
	}
	
	private void zombies() {
		Random alea = new Random(2);
		for (int i = 0; i < this.nivel; i++) {
			int random = alea.nextInt(2);
			if(random == 0) {
				z.add(new Caminante());
			} else if (random == 1) {
				z.add(new Corredor());
			} else if(random == 2) {
				z.add(new Gordo());
			}
		}
	}
	private void mZ() {
		if (z.isEmpty()) {
			System.out.println("No hay zombies cerca.");
			this.nivel += 1;
			this.ronda = 0; 
		} else {
			for (int i = 0; i < z.size(); i++) {
				System.out.print(z.get(i).getZombie() + " ");
			}
		}
	}
	
}
