package modelo;

import java.util.Arrays;
 
public class Jugador {

	public String nombre;
	public String[] cartas;
	public Ciudad[] ciudades;
	public int puntos;
	Ciudad ciudad1, ciudad2, recurso, numero;

	public Jugador(String nomjugador) {

		nombre = nomjugador;
		
		this.cartas = new String[7];
		
		Arrays.fill(cartas, "-");
		
		this.puntos = 0;
		
		this.ciudades = new Ciudad[10];
		Arrays.fill(ciudades, null);
		this.ciudades[0] =new Ciudad((int) (Math.random() * 10 + 2), "madera");
		this.ciudades[1] =new Ciudad((int) (Math.random() * 10 + 2), "piedra");
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String[] getCartas() {
		return this.cartas;
	}
	
	public int getCartasLenght() {
		return this.cartas.length;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public Ciudad[] getCiudades(){
		return this.ciudades;
	}
	
	public void setJugador(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCartas (String[] cartas) {
		this.cartas = cartas;
	}
	
	public void RellenarCartas () {
		Arrays.fill(cartas, "-");
	}
	
	public void setCiudades (int i, Ciudad ciudades) {
		this.ciudades[i] = ciudades;
	}
}
