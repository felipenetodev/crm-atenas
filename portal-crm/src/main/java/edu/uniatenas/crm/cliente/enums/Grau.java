package edu.uniatenas.crm.cliente.enums;

public enum Grau {
	ENSINO_MEDIO_COMPLETO("Ensino Médio Completo"),
	ENSINO_MEDIO_INCOMPLETO("Ensino Médio incompleto"),
	SUPERIO_COMPLETO("Ensino Superior Completo"),
	SUPERIOR_INCOMPLETO("Ensino Superior incompleto");
	String name;

	private Grau(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	
}
