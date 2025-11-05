//Ambar Itzel Cruz Zarza
package com.mx.SuperMercado;

public class SuperMercado {
	
	//Atributos
	private String productos;
	private double precio;
	private int stock;
	
	//Constructor
	public SuperMercado(String productos, double precio, int stock) {
		this.productos = productos;
		this.precio = precio;
		this.stock = stock;
	}
	//constructor vacio
	public SuperMercado() {
	}
	
	//toString
	@Override
	public String toString() {
		return "SuperMercado [productos=" + productos + ", precio=" + precio + 
				", stock=" + stock + "]\n";
	}
	
	//get and set
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
