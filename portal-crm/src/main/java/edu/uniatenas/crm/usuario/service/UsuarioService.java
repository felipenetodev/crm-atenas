package edu.uniatenas.crm.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.uniatenas.crm.cliente.entity.Cliente;
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
		String senha = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senha);
		repository.save(usuario);
	}
	
	public Usuario getUserByUserName(String username) {
		Usuario u = repository.findByLogin(username);
		return u;
	}
	
	public Boolean getClienteByCPF(String cpf) {
		Usuario u = repository.findByCpf(cpf);
		if(u == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public Usuario getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nomeDeUsuario = ((UserDetails)principal).getUsername();
		Usuario user = getUserByUserName(nomeDeUsuario);
		return user;
	}
}