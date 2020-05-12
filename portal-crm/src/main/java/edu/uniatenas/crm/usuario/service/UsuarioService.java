package edu.uniatenas.crm.usuario.service;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.uniatenas.crm.usuario.entity.Usuario;
import edu.uniatenas.crm.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> getAll(){
		return repository.findAll(Sort.by(Direction.ASC, "login"));
	}
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	public void alterStatus(Usuario usuario) {
		if(usuario.isAtividade()) {
			usuario.setAtividade(false);
		}else {
			usuario.setAtividade(true);
		}
		repository.save(usuario);
	}
	public Usuario login(String login, String senha) {
		Usuario usuario = repository.findByLoginAndSenha(login, senha);
		return usuario;
	}

}
