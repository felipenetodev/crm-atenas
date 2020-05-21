package edu.uniatenas.crm.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uniatenas.crm.cliente.entity.Cliente;
import edu.uniatenas.crm.usuario.entity.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Cliente findByCPF(String CPF);
}
	