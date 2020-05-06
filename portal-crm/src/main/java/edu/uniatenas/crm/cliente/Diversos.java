package edu.uniatenas.com.br.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Diversos implements Serializable{
	
	//Ensino Básico
	@Id
	@GeneratedValue
	private int codigo;
	
	private String instituicao;
	private String ano;
	private String grau;
	
	public Diversos(String instituicao, String ano, String grau) {
		super();
		this.instituicao = instituicao;
		this.ano = ano;
		this.grau = grau;
	}
	
	public Diversos() {}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}
}
