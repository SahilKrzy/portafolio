package Model;

import java.util.Random;

public class Zombie extends Humanoide{
	private int salud, movimiento, damage;
	private String tipo;
	
	public Zombie(int salud,int moviemiento, int damage, String tipo) {
		super(tipo, salud);
		this.salud = salud;
		this.movimiento = moviemiento;
		this.damage = damage;
		this.tipo = tipo;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public String getZombie(){
		return this.tipo;
	}

	public int getMovimiento() {
		return this.movimiento;
	}
}
