package org.opi.sports.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "app", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {				
		
		ModelAndView modeloVista = new ModelAndView();
		modeloVista.setViewName("Op-i-Sports");
		return modeloVista;
	}
	
}
