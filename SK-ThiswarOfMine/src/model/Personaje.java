package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Personaje {

	private String Nombre;
	private int Salud;
	private int Hambre;
	private int Sleep;
	private String Habilidad;
	private ArrayList<Objeto> objetos;

	public Personaje(String Nombre, String Habilidad) {
		this.Nombre = Nombre;
		this.Salud = 10;
		this.Hambre = 1;
		this.Sleep = 1;
		this.Habilidad = Habilidad;
		objetos = new ArrayList<Objeto>();
	}

	public String getNombre() {
		return this.Nombre;
	}

	public int getSalud() {
		return this.Salud;
	}
	public void setSalud(int salud) {
		this.Salud = salud;
	}

	public void restarSalud(int nivel) {
		this.Salud -= nivel;
	}

	public int getHambre() {
		return this.Hambre;
	}

	public void restarHambre() {
		this.Salud -= 1;
	}

	public int getSleep() {
		return this.Sleep;
	}

	public void setSleep() {
		this.Sleep += 1;
	}
	
	public void recuperarSalud() {
		this.Salud += 1;
	}

	public String getHabilidad() {
		return this.Habilidad;
	}

	public ArrayList<Objeto> getObjetos() {
		return this.objetos;
	}

	public void dormir() {
		this.Sleep -= 2;
	}

	public void vigilar(int nivel, String habilidad, Ubicacion ubica) {
		Random random = new Random();
		int alea = random.nextInt(51 - nivel);
		this.Sleep += 1;

		if (alea >= 0 && alea <= 5) {
			this.Salud -= 2;
		} else if (alea >= 39 && alea <= 51) {
			if (habilidad.equalsIgnoreCase("Elocuencia")) {
				for (int j = 0; j < ubica.getObjetos().size(); j++) {
					if (ubica.getObjetos().get(j).getTipo().equalsIgnoreCase("Comida")) {
						ubica.getObjetos().get(j).addCantidad(3);
					} else {
						if (ubica.getObjetos().get(j).getTipo().equalsIgnoreCase("Componentes")) {
							ubica.getObjetos().get(j).addCantidad(3);
						}
					}
				}
			} else {
				for (int j = 0; j < ubica.getObjetos().size(); j++) {
					if (ubica.getObjetos().get(j).getTipo().equalsIgnoreCase("Comida")) {
						ubica.getObjetos().get(j).addCantidad(2);
					} else {
						if (ubica.getObjetos().get(j).getTipo().equalsIgnoreCase("Componentes")) {
							ubica.getObjetos().get(j).addCantidad(2);
						}
					}
				}
			}
		}
	}

	public void explorar(Ubicacion ubicacion) {
		boolean lleno = false;
		Scanner teclado = new Scanner(System.in);
		int tecla;
		this.Sleep += 2;
		this.Hambre += 1;

		do {
			if (ubicacion.getObjetos() == null || ubicacion.getObjetos().isEmpty()) {
				System.out.println("NO HAY OBJETOS.");
				lleno = true;
			} else {
				for (int i = 0; i < 5; i++) {
					ubicacion.mostrarRecurso();
					System.out.println("Que objetos quieres guardar en la mochila?");
					tecla = teclado.nextInt();
					if (tecla > ubicacion.getObjetos().size()) {
						System.out.println("ERROR. POSICION INCORRECTA.");
						ubicacion.mostrarRecurso();
						System.out.println("Que objetos quieres guardar en la mochila?");
						tecla = teclado.nextInt();
					} else {
						System.out.println("Has guardado en la mochila:\n" + ubicacion.getObjeto(tecla));
						this.objetos.add(ubicacion.getObjeto(tecla));
						ubicacion.getObjetos().remove(tecla);

					}
					if (i == 4) {
						for (int j = 0; j < this.objetos.size(); j++) {
						System.out.println("ESTO ES UNA PRUEBA-----> " + this.objetos.get(j));
						}
						System.out.println("LA MOCHILA ESTA LLENA");
						System.out.println("");
						System.out.println("VOLVIENDO A CASA...");
						lleno = true;
					} else if (ubicacion.getObjetos().isEmpty()) {
						System.out.println("YA NO HAY OBJETOS PARA RECOLECTAR.");
						System.out.println("");
						System.out.println("VOLVIENDO A CASA...");
						lleno = true;
					}
				}
			}
		} while (lleno == false);
	}
}
