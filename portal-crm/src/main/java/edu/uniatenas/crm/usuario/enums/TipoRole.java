package edu.uniatenas.crm.usuario.enums;

import org.springframework.security.core.GrantedAuthority;

public enum TipoRole implements GrantedAuthority{
	
	ADMIN("Administrador"),
	ATENDENTE("Atendente");
	String name;

	public String getName() {
		return name;
	}

	private TipoRole(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		
		return "ROLE_" + this.name;
	}
}