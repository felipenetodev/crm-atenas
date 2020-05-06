package edu.uniatenas.crm.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

