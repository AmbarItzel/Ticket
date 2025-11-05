package com.mx.SuperMercado;

public interface IMetodos {
	
	public void agregar(SuperMercado producto);
	
	public void editar(int indice, SuperMercado producto);
	
	public void eliminar(SuperMercado producto);
	
	public void mostrar();
	
	public SuperMercado buscar(int indice);
	
	public double comprar(int cantidad, SuperMercado producto, double precio);
	
	

}
