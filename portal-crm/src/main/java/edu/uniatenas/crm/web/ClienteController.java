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
			if(isCPF(cliente.getCPF().replace(".", "").replace("-", ""))) {
				service.saveCliete(cliente);
				return "redirect:/cliente/";
			}else {
				return "redirect:/cliente/";
			}
		}else {
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
			if(isCPF(cliente.getCPF().replace(".", "").replace("-", ""))) {
				System.out.println("Funcionando");
				service.saveCliete(cliente);
				return "redirect:/cliente/";
			}else {
				System.out.println("Não Funcionando");
				return "redirect:/cliente/";
			}
		}else {
			System.out.println(results.getAllErrors());
			return "redirect:/novo";
		}
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