package edu.uniatenas.crm.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.uniatenas.crm.cliente.entity.Cliente;
import edu.uniatenas.crm.cliente.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService service;

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cliente-list");
		view.addObject("clientes", service.getAllClientes());
		return view;
	}

	@RequestMapping("/novo")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("form-cliente");
		view.addObject("cliente", new Cliente());
		return view;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Cliente cliente, BindingResult results) {
		if (!results.hasErrors()) {
			service.saveCliete(cliente);
			cliente = null;
			return list();
		} else {
			System.out.println(results.getAllErrors());
			return create();
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody Long id, BindingResult results) {
		if (!results.hasErrors()) {
			service.deleteCliente(id);
			System.out.println(id);
			return "Registro Excluido.";
		} else {
			System.out.println(results.getAllErrors());
			return "Erro";
		}
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cliente-update");
		Cliente cliente = service.getCliente(id);
		view.addObject("cliente", cliente);
		return view;
	}
}