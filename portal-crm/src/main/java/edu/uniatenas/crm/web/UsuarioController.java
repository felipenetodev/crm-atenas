package edu.uniatenas.crm.web;

import java.util.InputMismatchException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.uniatenas.crm.usuario.entity.Usuario;
import edu.uniatenas.crm.usuario.service.RoleService;
import edu.uniatenas.crm.usuario.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService Uservice;
	
	@Autowired
	private RoleService Rservice;
	
	@GetMapping("/todos")
	public ModelAndView list() {
		
		Usuario u = Uservice.getCurrentUser();
		ModelAndView view = new ModelAndView("usuario-list");
		view.addObject("nomeUsuario", u.getNomeCompleto());
		view.addObject("permissoes", u.getRoles());	
		view.addObject("usuarios", Uservice.getAll());
		
		return view;
	}	
	
	@RequestMapping("/novo")
	public ModelAndView create() {
		
		ModelAndView view = new ModelAndView("form-usuario");
		Usuario u = Uservice.getCurrentUser();
		view.addObject("nomeUsuario", u.getNomeCompleto());
		view.addObject("permissoes", u.getRoles());	
		view.addObject("usuario", new Usuario());
		view.addObject("roles", Rservice.getAll());
		return view;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult results) {
		String mensagem = "";
		if (!results.hasErrors()) {
			if(isCPF(usuario.getCpf().replace(".", "").replace("-", ""))) {
				if(Uservice.getUsuarioByCPF(usuario.getCpf())) {
					mensagem = "CPF Já Cadastrado";
					System.out.println(results.getAllErrors());
					ModelAndView view = new ModelAndView("form-usuario");
					view.addObject("mensagem", mensagem);
					view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
					view.addObject("roles", Rservice.getAll());
					return view;
				}else {
					Uservice.save(usuario);
					mensagem = "Cadastrado com Sucesso!";
					ModelAndView view = new ModelAndView("form-usuario");
					view.addObject("mensagem", mensagem);
					view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
					view.addObject("roles", Rservice.getAll());
					return view;
				}
			}else {
				mensagem = "CPF Inválido";
				ModelAndView view = new ModelAndView("form-usuario");
				view.addObject("mensagem", mensagem);
				view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
				view.addObject("roles", Rservice.getAll());
				return view;
			}
		}else {
			System.out.println(results.getAllErrors());
			mensagem = "Erro";
			ModelAndView view = new ModelAndView("form-usuario");
			view.addObject("mensagem", mensagem);
			view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
			view.addObject("roles", Rservice.getAll());
			return view;
		}
	}
	
	@RequestMapping("/update/save")
	public ModelAndView attUsuario(@Valid Usuario usuario, BindingResult results) {		
		String mensagem = "";

		if (!results.hasErrors()) {
			if(isCPF(usuario.getCpf().replace(".", "").replace("-", ""))) {
				System.out.println(usuario.getNomeCompleto());
				Uservice.save(usuario);
				mensagem = "Alterado com Sucesso!";
				ModelAndView view = new ModelAndView("usuario-update");
				view.addObject("mensagem", mensagem);
				view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
				view.addObject("roles", Rservice.getAll());
				return view;
			}else {
				mensagem = "CPF inválido";
				ModelAndView view = new ModelAndView("usuario-update");
				view.addObject("mensagem", mensagem);
				view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
				view.addObject("roles", Rservice.getAll());
				return view;
			}
		}else {
			mensagem = "Erro";
			ModelAndView view = new ModelAndView("usuario-update");
			view.addObject("mensagem", mensagem);
			view.addObject("roleAtual", usuario.getRoles().get(0).getAuthority());
			view.addObject("roles", Rservice.getAll());
			return view;
		}
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public ModelAndView delete(@RequestBody String login, BindingResult results) {
		if (!results.hasErrors()) {
			Uservice.deleteUsuario(login);
		} else {
			System.out.println(results.getAllErrors());
		}
		return list();
	}
	
	@RequestMapping("/update/{nomeDeUsuario}")
	public ModelAndView update(@PathVariable("nomeDeUsuario") String nomeDeUsuario) {
		ModelAndView view = new ModelAndView("usuario-update");
		Usuario u = Uservice.getCurrentUser();
		view.addObject("nomeUsuario", u.getNomeCompleto()); 
		Usuario user = Uservice.getUserByUserName(nomeDeUsuario);
		user.setSenha("#$@#$GE");
		view.addObject("usuario", user);
		view.addObject("roleAtual", user.getRoles().get(0).getAuthority());
		view.addObject("roles", Rservice.getAll());
		return view;
	}

	@RequestMapping("/minhaconta/")
	public ModelAndView updateMinhaConta() {
		ModelAndView view = new ModelAndView("usuario-update-minhaconta");

		Usuario u = Uservice.getCurrentUser();

		view.addObject("nomeUsuario", u.getNomeCompleto()); 
		Usuario user = Uservice.getUserByUserName(u.getLogin());
		user.setSenha("");
		view.addObject("usuario", user);
		view.addObject("roleAtual", user.getRoles().get(0).getAuthority());
		view.addObject("roles", Rservice.getAll());
		return view;
	}
	
	public static boolean isCPF(String CPF) {
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
      
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
}