package com.mx.SuperMercado;

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements IMetodos {

	List<SuperMercado> lista = new ArrayList<SuperMercado>();

	@Override
	public void agregar(SuperMercado producto) {
		lista.add(producto);

	}

	@Override
	public void editar(int indice, SuperMercado producto) {
		lista.set(indice, producto);

	}

	@Override
	public void eliminar(SuperMercado producto) {
		lista.remove(producto);

	}

	@Override
	public void mostrar() {
		// System.out.println("Nombre precio Stock");
		if (!lista.isEmpty()) {
			for (SuperMercado producto : lista) {
				System.out.println(producto);
			}
		} else {
			System.out.println("No existen productos en la lista.");
		}
	}

	@Override
	public SuperMercado buscar(int indice) {
		return lista.get(indice);
	}

	@Override
	public double comprar(int cantidad, SuperMercado producto, double precio) {
		if (producto == null) {
			System.out.println("El producto no existe.");
			return 0;
		}
		if (cantidad <= 0) {
			System.out.println("La cantidad debe ser mayor a cero.");
			return 0;
		}

		if (cantidad > producto.getStock()) {
			System.out.println("No hay suficiente stock disponible.");
			return 0;
		}

		double subtotal = (cantidad * producto.getPrecio());
		producto.setStock(producto.getStock() - cantidad);

		System.out.println("\nCompra realizada con exito de " + producto.getProductos());
		System.out.println("Cantidad comprada: " + cantidad);
		System.out.println("Subtotal: " + subtotal);

		return subtotal;
	}

	public List<SuperMercado> getLista() {
		return lista;
	}
}