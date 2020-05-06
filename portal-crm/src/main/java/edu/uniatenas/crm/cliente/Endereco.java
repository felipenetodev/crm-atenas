package edu.uniatenas.com.br.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue
	private int codigo;
	
	private String cep;
	private String tipoDaRua;
	private String logradouro;
	private String numero;
	private String complemento;
	private String tipoDoBairro;
	private String bairro;
	private String estado;
	private String cidade;
	private String pais;
	private String telefoneResidencial;
	private String telefoneCelular;
	
	public Endereco() {}
	
	public Endereco(int codigo, String cep, String tipoDaRua, String logradouro, String numero, String complemento,
			String tipoDoBairro, String bairro, String estado, String cidade, String pais, String telefoneResidencial,
			String telefoneCelular) {
		super();
		this.codigo = codigo;
		this.cep = cep;
		this.tipoDaRua = tipoDaRua;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.tipoDoBairro = tipoDoBairro;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTipoDaRua() {
		return tipoDaRua;
	}
	public void setTipoDaRua(String tipoDaRua) {
		this.tipoDaRua = tipoDaRua;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTipoDoBairro() {
		return tipoDoBairro;
	}
	public void setTipoDoBairro(String tipoDoBairro) {
		this.tipoDoBairro = tipoDoBairro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
	
}
