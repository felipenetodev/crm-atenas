package edu.uniatenas.crm.cliente.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;
import edu.uniatenas.crm.cliente.enums.EstadoCivil;
import edu.uniatenas.crm.cliente.enums.Grau;
import edu.uniatenas.crm.cliente.enums.Sexo;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	private String estadoNatal;
	private String naturalidade;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	@NotBlank
	@Email
	private String email;
	private String nacionalidade;
	@Enumerated(EnumType.STRING)
	private Grau grauDeInstrucao;
	@NotBlank
	private String telefonePrincipal;
	private String telefoneComplementar;
	@NotBlank
	private String CPF;
	private String documentoComplementar;
	
	private Boolean isAtivo = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
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

	public Grau getGrauDeInstrucao() {
		return grauDeInstrucao;
	}

	public void setGrauDeInstrucao(Grau grauDeInstrucao) {
		this.grauDeInstrucao = grauDeInstrucao;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneComplementar() {
		return telefoneComplementar;
	}

	public void setTelefoneComplementar(String telefoneComplementar) {
		this.telefoneComplementar = telefoneComplementar;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getDocumentoComplementar() {
		return documentoComplementar;
	}

	public void setDocumentoComplementar(String documentoComplementar) {
		this.documentoComplementar = documentoComplementar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((documentoComplementar == null) ? 0 : documentoComplementar.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((estadoNatal == null) ? 0 : estadoNatal.hashCode());
		result = prime * result + ((grauDeInstrucao == null) ? 0 : grauDeInstrucao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefoneComplementar == null) ? 0 : telefoneComplementar.hashCode());
		result = prime * result + ((telefonePrincipal == null) ? 0 : telefonePrincipal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (documentoComplementar == null) {
			if (other.documentoComplementar != null)
				return false;
		} else if (!documentoComplementar.equals(other.documentoComplementar))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (estadoNatal == null) {
			if (other.estadoNatal != null)
				return false;
		} else if (!estadoNatal.equals(other.estadoNatal))
			return false;
		if (grauDeInstrucao != other.grauDeInstrucao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (telefoneComplementar == null) {
			if (other.telefoneComplementar != null)
				return false;
		} else if (!telefoneComplementar.equals(other.telefoneComplementar))
			return false;
		if (telefonePrincipal == null) {
			if (other.telefonePrincipal != null)
				return false;
		} else if (!telefonePrincipal.equals(other.telefonePrincipal))
			return false;
		return true;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
}