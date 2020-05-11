package edu.uniatenas.crm.cliente.enums;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	String name;
	
	private Sexo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
}