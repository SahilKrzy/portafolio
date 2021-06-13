package model;

import java.util.ArrayList;
import java.util.Scanner;

import main.Recursos;

public class Arma {
	private ArrayList<Habilidad> habilidad;
	private String nombre;
	private String tipo;
	
	public Arma(){
		habilidad = new ArrayList<Habilidad>();
		this.nombre = Recursos.getNombreArma();
		this.tipo = Recursos.getTipoArma();
	}

	public void menu() {
		Scanner teclado = new Scanner(System.in);
		int opc;
		 do {
			System.out.println("--Menú Arma--\n1: Mostrar habilidades\n2: Crear nueva habilidad\n0: Salir");
			opc = teclado.nextInt();
			switch(opc) {
			case 0:
				opc = 0;
			break;
			case 1:
				mostrarHabilidad();
			break;
			case 2:
				nuevaHabilidad();
			break;
			default:
				System.out.println("ERROR. Opcion incorrecta. Vuelve a introducir:");
				opc = teclado.nextInt();
			break;
			} 
		} while (opc != 0);
		
		
	}
	
	private void nuevaHabilidad() {
		Habilidad h = new Habilidad();
		habilidad.add(h);
	}
	
	private void mostrarHabilidad() {
		if (habilidad.isEmpty()) {
			System.out.println("No hay habilidades a mostrar.");
		} else {
			for (int i = 0; i < habilidad.size(); i++) {
				System.out.println(i + ".- " +habilidad.get(i).toString() + " ");
			}
		}
	}
	
	public ArrayList <Habilidad> getHabilidad(){
		return this.habilidad;
	}
	
	@Override
	public String toString() {
		return "Arma: " + nombre + " (" + tipo + ")";
	}

}
