package Model;

import java.util.ArrayList;
import java.util.Random;

public class Espada extends Arma{

	public Espada() {
		super("Espada Corta", "Espada", 1, 1, 4);
	}
	
	@Override
	public void habilidadEspecial(ArrayList<Zombie> z2) {
		Random alea = new Random();
		int rand = 0;
		
		for (int i = 0; i < 2; i++) {
			rand = alea.nextInt(z2.size());
			z2.remove(rand);
		}
		
	}
}
