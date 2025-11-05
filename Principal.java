package com.mx.SuperMercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		//Variables locales
		String producto;
		double precio;
		int stock;
		double total = 0;
		
		//Instancias
		SuperMercado producto1 = new SuperMercado("Jabon", 19.99, 25);
		SuperMercado producto2 = new SuperMercado("Cereal", 79.99, 50);
		SuperMercado producto3 = new SuperMercado("Leche", 29.99, 30);
		SuperMercado producto4 = new SuperMercado("Huevo", 2.99, 200);
		SuperMercado producto5 = new SuperMercado("Aceite", 39.99, 10);
		SuperMercado producto6 = new SuperMercado("Papel", 31.99, 20);
		
		//Comodin
		SuperMercado producto0;
		
		//Instanciamos la implementacion
		Implementacion imp = new Implementacion();
		
		//Guardamos
		imp.agregar(producto1);
		imp.agregar(producto2);
		imp.agregar(producto3);
		imp.agregar(producto4);
		imp.agregar(producto5);
		imp.agregar(producto6);
		
		//Variables para el menu
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int menuP = 0;
		boolean esEntero;
		
		System.out.println("¡Bienvenido! ¿Cual es tu nombre?: ");
		String nombreCliente = scan.nextLine();
		
		do {
			do {
				esEntero = false;
				
				System.out.println("Hola " + nombreCliente + ", bienvenido al Super!");
				System.out.println("1.- Agregar producto.");
				System.out.println("2.- Editar precio de un producto.");
				System.out.println("3.- Eliminar producto.");
				System.out.println("4.- Buscar producto.");
				System.out.println("5.- Comprar productos.");
				System.out.println("6.- Listar productos.");
				System.out.println("7. Salir.");
				System.out.print("Selecciona una opcion: ");
				
				if (scan.hasNextInt()) {
					menuP = scan.nextInt();
					scan.nextLine();
					esEntero = true;
				}else {
					System.out.println("Error, ingresa un numero entre 1 y 7");
					scan.nextLine();
				}
			}while(!esEntero);
			
			switch(menuP) {
			case 1:
				System.out.println("Opcion para agregar productos.");
				System.out.println("Ingresa los siguientes valores: \n");
				
				System.out.println("Nombre del producto: ");
				producto = scan.nextLine();
				
				boolean nombreRepetido = false;
				SuperMercado productoExistente = null;
				
				for(SuperMercado p : imp.lista) {
					if( p.getProductos().equalsIgnoreCase(producto)) {
						nombreRepetido = true;
						productoExistente = p;
						break;
					}
				}
				
				if(nombreRepetido) {
					System.out.println("Ya existe este producto. "
							+ "¿Deseas agregar mas productos en stock?");
					System.out.println("1. Si");
					System.out.println("2. No");
					
					int opcion = scan.nextInt();
					scan.nextLine();
					
					if(opcion == 1) {
						System.out.println("¿Cuantos productos deseas agregar?: ");
						int cantidadAgregar = scan.nextInt();
						scan.nextLine();
						productoExistente.setStock(productoExistente.getStock() + cantidadAgregar);
						System.out.println("Stock actualizado correctamente.");
					}else {
						System.out.println("No se realizaron cambios.\n");
					}
					
				}else {
					System.out.println("Precio del producto: ");
					precio = scan.nextDouble();
					scan.nextLine();
					
					System.out.println("Stock del producto: ");
					stock = scan.nextInt();
					scan.nextLine();
					
					producto0 = new SuperMercado(producto, precio, stock);
					imp.agregar(producto0);
					System.out.println("Producto agregado correctamente!\n");
				}
				break;
			
			case 2:
				System.out.println("Opcion para editar el precio de un producto.\n");
				System.out.println("Ingresa el nombre del producto: ");
				String nombreEditar = scan.nextLine();
				
				SuperMercado productoAEditar = null;
				int indiceEditar = 0;
				
				for(int i = 0; i< imp.getLista().size(); i++) {
					if(imp.getLista().get(i).getProductos().equalsIgnoreCase(nombreEditar)) {
						productoAEditar = imp.getLista().get(i);
						indiceEditar = i;
						break;
					}
				}
				
				if (productoAEditar != null) {
					System.out.println("Producto encontrado: \n\t"+ productoAEditar);
					
					System.out.println("Nuevo precio: ");
					double nuevoPrecio = scan.nextDouble();
					scan.nextLine();
					
					if( nuevoPrecio > 0) {
						productoAEditar.setPrecio(nuevoPrecio);
						imp.editar(indiceEditar, productoAEditar);
					}
				} else {
					System.out.println("Producto no encontrado.");
				}
				
				break;
				
			case 3:
				System.out.println("Opcion para eliminar un producto.\n");
				System.out.println("Ingresa el nombre del producto que deseas eliminar: ");
				String nombreEliminar = scan.nextLine();
				
				SuperMercado productoAEliminar = null;
				boolean encontrado = false;
				
				for(SuperMercado p : imp.getLista()) {
					if( p.getProductos().equalsIgnoreCase(nombreEliminar)) {
						productoAEliminar = p;
						encontrado = true;
						break;
					}
				}
				
				if(encontrado) {
					imp.eliminar(productoAEliminar);
					System.out.println("Producto " + nombreEliminar + " eliminado correctamente.");
				}else {
					System.out.println("Producto no encontrado!");
				}
				break;
				
			case 4:
				System.out.println("Opcion para buscar un producto. \n");
				System.out.println("Ingresa el nombre del producto que deseas buscar: ");
				String nombreBusqueda = scan.nextLine();
				
				SuperMercado productoBuscado = null;
				encontrado = false;
				
				for(SuperMercado p : imp.getLista()) {
					if(p.getProductos().equalsIgnoreCase(nombreBusqueda)) {
						productoBuscado = p;
						encontrado = true;
						break;
					}
				}
				
				if(encontrado) {
					System.out.println("Produco encontrado: ");
					System.out.println("Nombre: " + productoBuscado.getProductos());
					System.out.println("Precio: " + productoBuscado.getPrecio());
					System.out.println("Stock: " + productoBuscado.getStock());
				}else {
					System.out.println("Producto no encontrado.");
				}
				break;
				
			case 5:
				System.out.println("Opcion para comprar productos. \n");
				
				imp.mostrar();
				
				List<String[]> carritoDeCompra = new ArrayList<String[]>();
				
				while(true) {
					System.out.println("Ingresa el nombre del producto que deseas comprar: ");
					String nombreCompra = scan.nextLine();
					
					SuperMercado productoAComprar = null;
					
					for(SuperMercado p : imp.getLista()) {
						if(p.getProductos().equalsIgnoreCase(nombreCompra)) {
							productoAComprar = p;
							break;
						}
					}
					
					if(productoAComprar != null) {
						System.out.println("¿Cuantas pzas deseas comprar?: ");
						int cantidadComprar = scan.nextInt();
						scan.nextLine();
						
						double subtotalCompra = imp.comprar(cantidadComprar, productoAComprar, productoAComprar.getPrecio());
						
						if(subtotalCompra > 0) {
							carritoDeCompra.add(new String[] {
									productoAComprar.getProductos(),
									String.valueOf(productoAComprar.getPrecio()),
									String.valueOf(cantidadComprar),
									String.valueOf(subtotalCompra)
							});
							total += subtotalCompra;
						}
					}else {
						System.out.println("Producto no encontrado.");
					}
					
					System.out.println("¿Deseas agregar otro producto al carrito? (si/no): ");
					String continuarCompra = scan.nextLine();
					
					if(continuarCompra.equalsIgnoreCase("no")) {
						break;
					}
				}
				
				//Generamos ticket
				System.out.println("\n--------------------Ticket de compra---------------------");
				System.out.println("Cliente: " + nombreCliente);
				System.out.println("Producto \t Precio Unitario \t Cantidad \t Subtotal");
				for(String[] p : carritoDeCompra) {
					System.out.println(p[0] + " -\t " + p[1] + " -\t" + p[2] + " -\t " + p[3]);
				}
				
				System.out.println("\nTotal: $" + total);
				System.out.println("\n----------------------------------------------------------");
				
				break;
				
			case 6:
				System.out.println("Opcion para mostrar todos los productos del Super.\n");
				
				imp.mostrar();
				
				break;
			
			case 7:
				System.out.println("Hasta pronto!");
				break;
				
			default:
				System.out.println("Opcion invalida, intenta de nuevo.");
				break;
			}
		}while(menuP != 7);
	}

}