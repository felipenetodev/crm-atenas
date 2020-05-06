package edu.uniatenas.com.br.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResponsavelFinanceiro implements Serializable{
	
	@Id
	@GeneratedValue
	private String codigo;
	
	private String responsavelFinanceiro;
	
	public ResponsavelFinanceiro() {}
	
	public ResponsavelFinanceiro(String codigo, String responsavelFinanceiro) {
		super();
		this.codigo = codigo;
		this.responsavelFinanceiro = responsavelFinanceiro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}
	public void setResponsavelFinanceiro(String responsavelFinanceiro) {
		this.responsavelFinanceiro = responsavelFinanceiro;
	}
		
}