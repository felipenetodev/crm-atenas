package edu.uniatenas.crm.cliente.enums;

public enum Estado {
	LEAD("Lead"),VESTIBULAR("Vestibular"),PRE_MATRICULA("Pre-Matrícula"),MATRICULADO("Matriculado");
	private String name;

	private Estado(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
}
