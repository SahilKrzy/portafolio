package model;

public class Objeto {
	private String tipo;
	private int cantidad;

	public Objeto(String tipo, int cantidad) {
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return this.tipo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void addCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

	public void lessCantidad() {
		this.cantidad -= 1;
	}

	@Override
	public String toString() {
		return "Objeto --> " + this.tipo + " (" + this.cantidad + ")";
	}

}
