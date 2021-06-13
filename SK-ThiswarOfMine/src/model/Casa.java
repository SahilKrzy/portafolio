package model;

import java.util.ArrayList;

public class Casa {

	private boolean cama;
	public ArrayList<Objeto> objetos;

	public Casa() {
		objetos = new ArrayList<Objeto>();
		this.cama = false;
	}

	public ArrayList<Objeto> getObjetos() {
		return this.objetos;
	}
	
	public void generarComida() {
		objetos.add(new Objeto ("Comida", 2));
	}
	
	public void generarCama(boolean sino) {
		this.cama = sino;
	}
}