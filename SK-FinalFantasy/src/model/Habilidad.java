package model;

import javax.swing.JOptionPane;

import main.Recursos;

public class Habilidad {
	private String nombre;
	private String descripcion;
	
	public Habilidad() {
		this.descripcion = Recursos.getDescripcionHabilidad();
		this.nombre = JOptionPane.showInputDialog(this.descripcion);
		  
	}

	@Override
	public String toString() {
		return nombre + " ("+ descripcion + ")";
	}
	
	
}
