package Model;

import java.util.ArrayList;

public class Arco extends Arma{

	public Arco() {
		super("Arco Largo", "Arco", 1, 2, 3);
	}
	
	@Override
	public void habilidadEspecial(ArrayList<Zombie> z2) {
		int parar = 0;
		for (int i = 0; i < z2.size(); i++) {
			if (z2.get(i).getZombie().equals("Corredor") && parar == 0) {
				z2.remove(i);
				parar++;
			}
		}
		
	}
}
