package Model;

import java.util.ArrayList;

public class Hechizo extends Arma{

	public Hechizo() {
		super("Bola de fuego", "Hechizo", 1, 3, 4);
	}
	
	@Override
	public void habilidadEspecial(ArrayList<Zombie> z2) {
		int parar = 0;
		
		for (int i = 0; i < z2.size(); i++) {
			if (z2.get(i).getZombie().equals("Caminante") && parar < 2) {
				z2.remove(i);
				parar++;
			}
		}
		
	}
	
}
