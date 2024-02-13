package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@GetMapping()
	public String manufacturers(Model model) {
		List<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		return "manufacturers";
	}
	
}





