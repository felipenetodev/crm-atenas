package edu.uniatenas.crm.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniatenas.crm.cliente.entity.Cliente;
import edu.uniatenas.crm.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;

	public List<Cliente> getAllClientes(){

		return repository.findAll();

	}

	public void saveCliete(Cliente cliente ) {
		repository.save(cliente);
	}

	public void deleteCliente(Long id) {
		Cliente cliente = repository.getOne(id);
		repository.delete(cliente);
	}

}

