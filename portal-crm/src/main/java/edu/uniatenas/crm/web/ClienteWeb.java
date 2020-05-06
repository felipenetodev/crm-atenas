package edu.uniatenas.crm.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.uniatenas.crm.cliente.Cliente;
import edu.uniatenas.crm.cliente.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteWeb {
	@Autowired
	private ClienteService  service;
	@GetMapping()
	public ModelAndView list(){
		ModelAndView view = new ModelAndView("cliente-list");
		view.addObject("clientes",service.getAllClientes());
		return view;
	}
	
	@RequestMapping("/novo")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("cliente");
		view.addObject("cliente", new Cliente());
		return view;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String save(@Valid Cliente cliente, BindingResult reults) {
		if(!reults.hasErrors()) {
			service.saveCliete(cliente);
			return "Dados salvos com sucesso!";
		}else {
			return "Um erro aconteceu!";
		}
	}
		
}
