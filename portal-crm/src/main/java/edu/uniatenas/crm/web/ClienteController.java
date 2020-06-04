package edu.uniatenas.crm.web;

import java.util.InputMismatchException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import edu.uniatenas.crm.cliente.entity.Cliente;
import edu.uniatenas.crm.cliente.enums.Estado;
import edu.uniatenas.crm.cliente.service.ClienteService;
import edu.uniatenas.crm.usuario.entity.Role;
import edu.uniatenas.crm.usuario.entity.Usuario;
import edu.uniatenas.crm.usuario.enums.TipoRole;
import edu.uniatenas.crm.usuario.service.UsuarioService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private UsuarioService Uservice;

	@GetMapping("/{tipo}")
	public ModelAndView list(@PathVariable("tipo") String tipo) {
		
		Usuario u = Uservice.getCurrentUser();
		ModelAndView view = new ModelAndView("cliente-list");
		view.addObject("nomeUsuario", u.getNomeCompleto());
		view.addObject("permissoes", u.getRoles());		
		
		if(tipo.equals("lead")) {
			view.addObject("clientes", service.getClienteByEstado(Estado.LEAD));
		}else if(tipo.equals("prevestibular")) {
			view.addObject("clientes", service.getClienteByEstado(Estado.PRE_VESTIBULAR));
		}else if(tipo.equals("prematricula")) {
			view.addObject("clientes", service.getClienteByEstado(Estado.PRE_MATRICULA));
		}else if(tipo.equals("matriculados")) {
			view.addObject("clientes", service.getClienteByEstado(Estado.MATRICULADO));
		}else if(tipo.equals("pendentes")) {
			view.addObject("clientes", service.getClienteByEstado(Estado.PENDENTE));
		}else {
			view.addObject("clientes", service.getAllClientes());
		}
		
		return view;
	}

	@RequestMapping("/novo")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("form-cliente");
		Usuario u = Uservice.getCurrentUser();
		view.addObject("nomeUsuario", u.getNomeCompleto());
		view.addObject("permissoes", u.getRoles());	
		view.addObject("cliente", new Cliente());
		return view;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Cliente cliente, BindingResult results) {
		String mensagem = "";
		if (!results.hasErrors()) {
			if(isCPF(cliente.getCPF().replace(".", "").replace("-", ""))) {
				if(service.getClienteByCPF(cliente.getCPF())) {
					mensagem = "CPF Já Cadastrado";
					System.out.println(results.getAllErrors());
					ModelAndView view = new ModelAndView("form-cliente");
					view.addObject("mensagem", mensagem);
					return view;
				}else {
					service.saveCliete(cliente);
					mensagem = "Cadastrado com Sucesso!";
					ModelAndView view = new ModelAndView("form-cliente");
					view.addObject("mensagem", mensagem);
					return view;
				}
			}else {
				mensagem = "CPF Inválido";
				ModelAndView view = new ModelAndView("form-cliente");
				view.addObject("mensagem", mensagem);
				return view;
			}
		}else {
			System.out.println(results.getAllErrors());
			mensagem = "Erro";
			ModelAndView view = new ModelAndView("form-cliente");
			view.addObject("mensagem", mensagem);
			return view;
		}
	}
	
	@PostMapping("/saveLead")
	public ModelAndView saveLead(@Valid Cliente cliente, BindingResult results) {
		String mensagem = "";
		if (!results.hasErrors()) {
			if(isCPF(cliente.getCPF().replace(".", "").replace("-", ""))) {
				if(service.getClienteByCPF(cliente.getCPF())) {
					mensagem = "CPF Já Cadastrado";
					System.out.println(results.getAllErrors());
					ModelAndView view = new ModelAndView("landing-page");
					view.addObject("mensagem", mensagem);
					return view;
				}else {
					service.saveCliete(cliente);
					mensagem = "Cadastrado com Sucesso!";
					ModelAndView view = new ModelAndView("landing-page");
					view.addObject("mensagem", mensagem);
					return view;
				}
			}else {
				mensagem = "CPF inválido";
				ModelAndView view = new ModelAndView("landing-page");
				view.addObject("mensagem", mensagem);
				return view;
			}
		}else {
			mensagem = "Erro";
			ModelAndView view = new ModelAndView("landing-page");
			view.addObject("mensagem", mensagem);
			return view;
		}
			
	}

	@PostMapping("/delete")
	@ResponseBody
	public ModelAndView delete(@RequestBody Long id, BindingResult results) {
		if (!results.hasErrors()) {
			service.deleteCliente(id);
		} else {
			System.out.println(results.getAllErrors());
		}
		return list("lead");
	}

	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cliente-update");
		Cliente cliente = service.getCliente(id);
		view.addObject("cliente", cliente);
		return view;
	}
	
	@PostMapping("/updateEstado/{id}")
	@ResponseBody
	public String updateEstado(@PathVariable("id") Long id, @RequestBody String estado) {
		
		
		Cliente cliente = service.getCliente(id);
		if(estado.equals("1")) {
			cliente.setEstado(Estado.LEAD);
		}else if(estado.equals("2")) {
			cliente.setEstado(Estado.PRE_VESTIBULAR);
		}else if(estado.equals("3")) {
			cliente.setEstado(Estado.PRE_MATRICULA);
		}else if(estado.equals("4")) {
			cliente.setEstado(Estado.MATRICULADO);
		}else if(estado.equals("5")) {
			cliente.setEstado(Estado.PENDENTE);
		}
		
		service.saveCliete(cliente);
		return "Lead Convertido com Sucesso";
	}
	
	@RequestMapping("/update/save")
	public ModelAndView attCliente(@Valid Cliente cliente, BindingResult results) {
		String mensagem = "";
		if (!results.hasErrors()) {
			if(isCPF(cliente.getCPF().replace(".", "").replace("-", ""))) {
				service.saveCliete(cliente);
				mensagem = "Cadastrado com Sucesso!";
				ModelAndView view = new ModelAndView("form-cliente");
				view.addObject("mensagem", mensagem);
				return view;
			}else {
				mensagem = "CPF inválido";
				ModelAndView view = new ModelAndView("cliente-update");
				view.addObject("mensagem", mensagem);
				return view;
			}
		}else {
			mensagem = "Erro";
			ModelAndView view = new ModelAndView("cliente-update");
			view.addObject("mensagem", mensagem);
			return view;
		}
	}
	
	@GetMapping("/landing")
	public ModelAndView cadLead() {
		ModelAndView view = new ModelAndView("landing-page");
		view.addObject("cliente", new Cliente());
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