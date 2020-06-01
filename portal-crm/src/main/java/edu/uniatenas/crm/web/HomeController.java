package edu.uniatenas.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping()
@Controller
public class HomeController {

	public ModelAndView home() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
}