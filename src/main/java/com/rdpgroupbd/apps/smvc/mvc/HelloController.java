package com.rdpgroupbd.apps.smvc.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rdpgroupbd.apps.smvc.domain.T01I001;
import com.rdpgroupbd.apps.smvc.serv.IT01I001Service;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	IT01I001Service continentService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		for(T01I001 m:continentService.findAll()) {
			log.info(m.getNameEn());
		}
		log.info("Hello world");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	public void setContinentService(IT01I001Service continentService) {
		this.continentService = continentService;
	}

}