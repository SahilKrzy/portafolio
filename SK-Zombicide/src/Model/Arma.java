package Model;

import java.util.ArrayList;
import java.util.Random;

public class Arma {
	private String nombre, tipo;
	private int dano, alcance, acierto;
	
	public Arma(String nombre, String tipo, int dano, int alcance, int acierto) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.dano = dano;
		this.alcance = alcance;
		this.acierto = acierto;
	}
	
	public void habilidadEspecial(ArrayList<Zombie> z2) {
		System.out.println("No hay habilidad especial");
	}
	
	public int getAcie() {
		return this.acierto;
	}
	
	public int getDamage() {
		return this.dano;
	}

	@Override
	public String toString() {
		return "Arma ["+ nombre.toUpperCase()+ " DAÑO: " + dano + " DIST: " + alcance + " ACIER: " + acierto + "]";
	}

	public void atacarE(Jugador jugador, ArrayList<Zombie> z) {
		Random alea = new Random();
		int rand = alea.nextInt(z.size());
		if (jugador.getArma().getDamage() >= z.get(rand).getSalud()) {
			Random suerte = new Random();
			int dados = suerte.nextInt(5)+1;
			
			if (dados >= jugador.getArma().acierto) {
				System.out.println("Te has cargado al " + z.get(rand).getZombie() + " que habia cerca");
				z.remove(rand);
			} else {
				System.out.println("El " + z.get(rand).getZombie() + " ha esquivado el ataque");
			}
		} else {
			System.out.println("El " + z.get(rand).getZombie() + " ha esquivado el ataque");
		}
	}
}
