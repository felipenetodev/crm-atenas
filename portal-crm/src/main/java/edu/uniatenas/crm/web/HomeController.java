package edu.uniatenas.crm.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping()
public class HomeController {

	public ModelAndView home() {
		
		ModelAndView view = new ModelAndView("index");
		return view;
	}
}
