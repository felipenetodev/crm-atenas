package edu.uniatenas.crm.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniatenas.crm.usuario.entity.Role;
import edu.uniatenas.crm.usuario.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getAll(){
		return repository.findAll();
	}
}