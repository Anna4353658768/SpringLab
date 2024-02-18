package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;

import jakarta.validation.Valid;;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

	private static final Logger log = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	
	@ModelAttribute
	public void addManufacturersToModel(Model model) {
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
	}	
	
	
	@GetMapping
	public String manufacturers() {
		return "manufacturers";
	}
	
	
	@GetMapping(value = "/delete")
	public String manufacturerDelete(@RequestParam Long id) {
		Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow();
		manufacturerRepository.delete(manufacturer);
		return "redirect:/manufacturers";
	}
	
	
	@GetMapping(value = "/add")
	public String newManufacturer(Model model) {
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);
		return "new-manufacturer";
	}
	
	
	@GetMapping(value = "/edit")
	public String manufacturerEdit(Model model, @RequestParam Long id) {
		Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow();
		model.addAttribute("manufacturer", manufacturer);
		return "manufacturer-edit";
	}
	
	
	@PostMapping(value = "/add")
	public String saveNewManufacturer(@Valid @ModelAttribute Manufacturer manufacturer, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			log.error("Ошибка >> " + bindingResult.getAllErrors());
			return "new-manufacturer";
		}
		else {
			manufacturerRepository.save(manufacturer);
			log.info(manufacturer.toString());
			return "redirect:/manufacturers";
		}
	}
	
	
	@PostMapping(value = "/edit")
	public String saveEditManufacturer(@Valid @ModelAttribute Manufacturer manufacturer, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "manufacturer-edit";
		}
		else {
			manufacturerRepository.save(manufacturer);
			return "redirect:/manufacturers";
		}
	}
	
}






