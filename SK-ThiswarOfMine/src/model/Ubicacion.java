package model;

import java.util.ArrayList;
import java.util.Random;

import main.ThisWarOfMine;

public class Ubicacion {

	public ArrayList<Objeto> objetos;
	private int peligrosidad;

	public Ubicacion(int nivel, ArrayList<Personaje> seleccionados) {
		peligrosidad(nivel, seleccionados);
		productos(nivel);
		mostrarRecurso();
	}

	public void productos(int nivel) {
		objetos = new ArrayList<Objeto>();
		Random rand = new Random();
		int productos = rand.nextInt(10);
		productos -= nivel;
		for (int i = 0; i < productos; i++) {

			int dado = rand.nextInt(100);

			if (dado < 11 && dado > 0) {
				objetos.add(new Objeto("Arma", 1));
			} else if (dado < 31 && dado > 10) {
				objetos.add(new Objeto("Comida", 1));
			} else if (dado < 46 && dado > 30) {
				objetos.add(new Objeto("Medicamentos", 1));
			} else if (dado < 101 && dado > 45) {
				objetos.add(new Objeto("Componentes", 1));
			}
		}
	}

	public int peligrosidad(int nivel, ArrayList<Personaje> seleccionados) {
		Random rand = new Random();
		peligrosidad = rand.nextInt(nivel);
		if (peligrosidad != 0) {
			System.out.println("DEBIDO AL PELIGRO QUE HAY EN EL SITIO. SE LE RESTA " + nivel + " DE SALUD.");
			seleccionados.get(nivel).restarSalud(nivel);
		}
		return peligrosidad;
	}

	public ArrayList<Objeto> getObjetos() {
		return this.objetos;
	}

	public Objeto getObjeto(int posi) {
		return this.objetos.get(posi);
	}

	public void mostrarRecurso() {
		if (objetos.size() == 0) {
			System.out.println("NO SE HAN ENCONTRADO RECURSOS.\n");
		} else {
			System.out.println("RECURSOS ENCONTRADOS:\n");
			for (int i = 0; i < objetos.size(); i++) {
				System.out.println(i + ".- " + objetos.get(i));
			}
		}
	}
}
