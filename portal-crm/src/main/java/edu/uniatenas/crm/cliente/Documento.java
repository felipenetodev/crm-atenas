package edu.uniatenas.com.br.Entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Documento implements Serializable{
	
	@Id
	@GeneratedValue
	private int codigo;
	
	private String cpf;
	
	private String numeroCi;
	private Date emissao;
	private String orgãoEmissor;
	private String estadoEmissorIdent;
	
	private String tituloDeEleitor;
	private String zona;
	private String secao;
	private Date emissaoTituloDeEleitor;
	
	public Documento() {}
	
	public Documento(int codigo, String cpf, String numeroCi, Date emissao, String orgãoEmissor,
			String estadoEmissorIdent, String tituloDeEleitor, String zona, String secao, Date emissaoTituloDeEleitor) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.numeroCi = numeroCi;
		this.emissao = emissao;
		this.orgãoEmissor = orgãoEmissor;
		this.estadoEmissorIdent = estadoEmissorIdent;
		this.tituloDeEleitor = tituloDeEleitor;
		this.zona = zona;
		this.secao = secao;
		this.emissaoTituloDeEleitor = emissaoTituloDeEleitor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCi() {
		return numeroCi;
	}

	public void setNumeroCi(String numeroCi) {
		this.numeroCi = numeroCi;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public String getOrgãoEmissor() {
		return orgãoEmissor;
	}

	public void setOrgãoEmissor(String orgãoEmissor) {
		this.orgãoEmissor = orgãoEmissor;
	}

	public String getEstadoEmissorIdent() {
		return estadoEmissorIdent;
	}

	public void setEstadoEmissorIdent(String estadoEmissorIdent) {
		this.estadoEmissorIdent = estadoEmissorIdent;
	}

	public String getTituloDeEleitor() {
		return tituloDeEleitor;
	}

	public void setTituloDeEleitor(String tituloDeEleitor) {
		this.tituloDeEleitor = tituloDeEleitor;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public Date getEmissaoTituloDeEleitor() {
		return emissaoTituloDeEleitor;
	}

	public void setEmissaoTituloDeEleitor(Date emissaoTituloDeEleitor) {
		this.emissaoTituloDeEleitor = emissaoTituloDeEleitor;
	}
}
