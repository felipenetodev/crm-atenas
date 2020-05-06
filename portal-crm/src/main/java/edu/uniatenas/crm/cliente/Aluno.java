package edu.uniatenas.com.br.Entidades;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String RegistroAcademico;
	private String nome;
	private String sobreNome;
	private String nomeSocial;
	private String Apelido;
	private String estadoNatal;
	private String naturalidade;
	private Date dtNascimento;
	private String sexo;
	private String tipoAluno;
	private String estadoCivil;
	private String email;
	private String nacionalidade;
	private String usuario;
	private String cor;
	private String grauDeInstrucao;
	private Endereco endereco;
	private Documento documentos;
	private ResponsavelFinanceiro responsavelFinanceiro;
	private Diversos diversos;
	

	public Aluno() {}
	
	public Aluno(Long codigo, String registroAcademico, String nome, String sobreNome, String nomeSocial, String apelido,
			String estadoNatal, String naturalidade, Date dtNascimento, String sexo, String tipoAluno,
			String estadoCivil, String email, String nacionalidade, String usuario, String cor, String grauDeInstrucao,
			Endereco endereco, Documento documentos, ResponsavelFinanceiro responsavelFinanceiro, Diversos diversos) {
		super();
		this.codigo = codigo;
		RegistroAcademico = registroAcademico;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.nomeSocial = nomeSocial;
		Apelido = apelido;
		this.estadoNatal = estadoNatal;
		this.naturalidade = naturalidade;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.tipoAluno = tipoAluno;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.nacionalidade = nacionalidade;
		this.usuario = usuario;
		this.cor = cor;
		this.grauDeInstrucao = grauDeInstrucao;
		this.endereco = endereco;
		this.documentos = documentos;
		this.responsavelFinanceiro = responsavelFinanceiro;
		this.diversos = diversos;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getRegistroAcademico() {
		return RegistroAcademico;
	}
	public void setRegistroAcademico(String registroAcademico) {
		RegistroAcademico = registroAcademico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public String getApelido() {
		return Apelido;
	}
	public void setApelido(String apelido) {
		Apelido = apelido;
	}
	public String getEstadoNatal() {
		return estadoNatal;
	}
	public void setEstadoNatal(String estadoNatal) {
		this.estadoNatal = estadoNatal;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipoAluno() {
		return tipoAluno;
	}
	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getGrauDeInstrucao() {
		return grauDeInstrucao;
	}
	public void setGrauDeInstrucao(String grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Documento getDocumentos() {
		return documentos;
	}
	public void setDocumentos(Documento documentos) {
		this.documentos = documentos;
	}
	public ResponsavelFinanceiro getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}
	public void setResponsavelFinanceiro(ResponsavelFinanceiro responsavelFinanceiro) {
		this.responsavelFinanceiro = responsavelFinanceiro;
	}
	public Diversos getDiversos() {
		return diversos;
	}
	public void setDiversos(Diversos diversos) {
		this.diversos = diversos;
	}
	
}