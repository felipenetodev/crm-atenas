package edu.uniatenas.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsuarioWeb {

	@RequestMapping("/login")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("form-cliente");
		return view;
	}
	
}
