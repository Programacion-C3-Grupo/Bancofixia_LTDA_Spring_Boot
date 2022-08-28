package com.ProgramacionC3.ProyectoCiclo3;

import Entidades.Employee;
import Entidades.Enterprise;
import Entidades.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ProyectoCiclo3Application {

	public static void main(String[] args) {

		//Se comenta por concepto de pruebas en clase main:
		//SpringApplication.run(ProyectoCiclo3Application.class, args);

		Enterprise empresaX = new Enterprise("nit-1234","Nombre EmpresaX","+5733232344","Direccion Enrique segoviano");

		Employee empleadoX = new Employee(new Long(1930223039),"Juan Carlos","juan.ca@correo.com","no_image","+57223232",false,empresaX);
		Employee empleadoY = new Employee(new Long(1930224545),"Manuel","Manu@correo.com","no_image1","+572233243",true,empresaX);

		empresaX.addEmployee(empleadoX);
		empresaX.addEmployee(empleadoY);

		Transaction transactionX = new Transaction("MovimientoPrueba",new Float(10000),empleadoX,empresaX);
		Transaction transactionY = new Transaction("MovimientoPrueba2",new Float(12000),empleadoY,empresaX);

		empresaX.addTransaction(transactionX);
		empresaX.addTransaction(transactionY);

		empresaX.getEmployeeList().get(0).addTransaction(transactionX);
		empresaX.getEmployeeList().get(1).addTransaction(transactionY);

		System.out.println("Primera Transacción: "+ empresaX.getEmployeeList().get(0).getTransactionList().get(0).getConcept());
		System.out.println("Segunda Transacción: "+ empresaX.getEmployeeList().get(1).getTransactionList().get(0).getConcept());
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);

	}
}
