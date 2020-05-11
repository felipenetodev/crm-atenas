package edu.uniatenas.crm.cliente.enums;

public enum EstadoCivil {
	CASADO("Casado"),
	SOLTEIRO("Solteiro"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	String name;

	private EstadoCivil(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}