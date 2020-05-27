package edu.uniatenas.crm.cliente.enums;

public enum Estado {
	LEAD("Lead"),
	PRE_VESTIBULAR("Pre-Vestibular"),
	PRE_MATRICULA("Pre-Matrícula"),
	MATRICULADO("Matriculado"),
	PENDENTE("Pendente");
	private String name;

	private Estado(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}