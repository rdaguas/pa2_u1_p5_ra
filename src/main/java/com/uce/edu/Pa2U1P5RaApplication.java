package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5RaApplication implements CommandLineRunner {

	/*
	//Inyeccion por Métodos (Solo se usa el set)
	private ITransferenciaService iTransferenciaService;
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}
	*/
	
	/*
	//Inyeccion por Constructor
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	public Pa2U1P5RaApplication(ITransferenciaService iTransServi) {
		this.iTransferenciaService = iTransServi;
	}
	*/

	//Inyeccion por atributo
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		// 1. Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1724340391");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1710441617");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.iCuentaBancariaService.guardar(ctaDestino);
		 //int numeroDeTransaccionesARealizar = 5;
		//for (int i = 0; i < numeroDeTransaccionesARealizar; i++) {
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
		
		this.iCuentaBancariaService.depositar("1234", new BigDecimal(100));
		
//		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
//		System.out.println(ctaOrigen1);
//		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
//		System.out.println(ctaDestino1);
		
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
		this.iTransferenciaService.realizar("1234", "1234", new BigDecimal(10));
		
		
		//Construir un reporte del estado de cuenta de todas las transferencias
//		this.iTransferenciaService.reporte().stream().forEach(System.out::println);
		List<Transferencia> lista = this.iTransferenciaService.reporte();
		int indice=0;
		for(Transferencia trans: lista) {
			indice++;
			System.out.println(indice + ": " + trans);
		}
}
	}


