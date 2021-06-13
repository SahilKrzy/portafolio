package modelo;

import java.util.Scanner;

public class Ciudad {
	public static Scanner teclado;
	public int numero;
	public String recurso;
	
	public Ciudad(int alea, String recurso) {
		numero = alea;
		this.recurso = recurso;
	}
	public Ciudad() {
		generarRecurso();
		generarNumero();
	}
	public String generarRecurso(){
		int opc = 0;
		Scanner teclado = new Scanner (System.in);
		while (!(opc == 1 || opc == 2)){
			System.out.println("Que tipo de ciudad quieres?\n1.- Ciudad de Madera\n2.- Ciudad de Piedra");
			opc = teclado.nextInt();
			if (opc == 1) {
				this.recurso = "madera";
			} else if (opc == 2) {
				this.recurso = "piedra";
			} else {
				System.out.println("Numero invalido.");
			}	
		}
		return this.recurso;
	}
	
	public int generarNumero(){
		Scanner teclado = new Scanner (System.in);
		int q = 0;
		
		int xad = 0;
		while (xad  == 0){
			System.out.println("Escoge un numero vinculado a una ciudad del 2 al 12.");
			q = teclado.nextInt();
			if (q < 13 && q > 1) {
				this.numero = q;
				xad  = 1;
			} else {
				xad = 0;
			}	
		}
		return this.numero;
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int alea) {
		this.numero = alea;
	}
	
	public String getRecurso() {
		return this.recurso;
	}
	
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

}