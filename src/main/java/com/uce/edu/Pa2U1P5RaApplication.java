package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5RaApplication implements CommandLineRunner {

	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IBodegaService iBodegaService;

	@Autowired
	private IInventarioService iInventarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p1 = new Producto();
		p1.setCodigoBarras("12345");
		p1.setNombre("HP 15 Laptop");
		p1.setStock(0);
		this.iProductoService.guardar(p1);

		Producto p2 = new Producto();
		p2.setCodigoBarras("6789");
		p2.setNombre("DELL Teclado");
		p2.setStock(0);
		this.iProductoService.guardar(p2);

		Bodega bod1 = new Bodega();
		bod1.setCapacidad(10);
		bod1.setCodigo("123");
		bod1.setDireccion("Calderon");
		bod1.setNombre("Bodega Rosita");
		this.iBodegaService.guardar(bod1);

		Inventario inv = new Inventario();

		this.iInventarioService.registrar("123", "12345", 50);
		this.iInventarioService.registrar("123", "6789", 100);
		this.iInventarioService.registrar("123", "12345", 20);

		System.out.println("----------STOCK P1--------------");
		Producto prod1 = this.iProductoService.buscar("12345");
		System.out.println("El stock del producto 1 es: " + prod1.getStock());
		System.out.println("----------STOCK P2--------------");
		Producto prod2 = this.iProductoService.buscar("6789");
		System.out.println("El stock del producto 2 es: " + prod2.getStock());

	}
}
