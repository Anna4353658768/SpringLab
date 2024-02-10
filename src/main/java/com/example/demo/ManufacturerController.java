package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@GetMapping()
	public String home(Model model) {
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		return "manufacturers";
	}

}
