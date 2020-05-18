package edu.uniatenas.crm.web;

import java.util.InputMismatchException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.stella.validation.InvalidStateException;
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
	public String save(@Valid Cliente cliente, BindingResult results) {
		if (!results.hasErrors()) {
			service.saveCliete(cliente);
			cliente = null;
			return "redirect:/cliente/";
		} else {
			System.out.println(results.getAllErrors());
			return "redirect:/novo";
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
		return list();
	}

	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cliente-update");
		Cliente cliente = service.getCliente(id);
		view.addObject("cliente", cliente);
		return view;
	}
	
	
	@RequestMapping("/update/save")
	public String attCliente(@Valid Cliente cliente, BindingResult results) {
		if (!results.hasErrors()) {
			service.saveCliete(cliente);
			return "redirect:/cliente/";
		} else {
			System.out.println(results.getAllErrors());
			return "redirect:/novo";
		}
	}
	
	@ExceptionHandler({ InvalidStateException.class })
    public void InvalidhandleException() {
		System.out.println("Teste");
    }
}