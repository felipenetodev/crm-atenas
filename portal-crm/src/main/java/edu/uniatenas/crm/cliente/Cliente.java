package edu.uniatenas.crm.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author FelipeNetoVasconcelo
 *
 */
@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "O campo nome não pode estar vazio!")
	private String nome;
	@NotBlank(message = "O campo cpf não pode estar vazio!")
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + "]";
	}

}
