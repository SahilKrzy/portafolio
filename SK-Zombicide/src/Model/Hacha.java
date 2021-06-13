package Model;

import java.util.ArrayList;

public class Hacha extends Arma{

	public Hacha() {
		super("Hacha Doble", "Hacha", 2, 1, 3);
	}
	@Override
	public void habilidadEspecial(ArrayList<Zombie> z2) {
		int parar = 0;
		for (int i = 0; i < z2.size(); i++) {
			if (z2.get(i).getZombie().equals("Gordo") && parar == 0) {
				z2.remove(i);
				parar++;
			}
		}
		
	}

}
