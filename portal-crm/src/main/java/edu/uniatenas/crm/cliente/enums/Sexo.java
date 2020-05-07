package edu.uniatenas.crm.cliente.enums;

public enum Sexo {
	
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	String name;
	
	Sexo(String name) {
		this.name = name;
	}

	String  getName(String name) {
		return name;
	}
	
	
}
