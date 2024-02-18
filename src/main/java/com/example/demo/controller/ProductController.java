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
import com.example.demo.model.Product;
import com.example.demo.repository.ManufacturerRepository;
import com.example.demo.repository.ProductRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	
	@ModelAttribute
	public void addProductsToModel(Model model) {
		Iterable<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
	}
	
	
	@GetMapping
	public String products() {
		return "products";
	}
	
	
	@GetMapping(value = "/delete")
	public String productDelete(@RequestParam Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		productRepository.delete(product);
		return "redirect:/products";
	}
	
	
	@GetMapping(value = "/add")
	public String newProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		return "new-product";
	}
	
	
	@GetMapping(value = "/edit")
	public String productEdit(Model model, @RequestParam Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		model.addAttribute("product", product);
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		return "product-edit";
	}
	
	
	@PostMapping(value = "/add")
	public String saveNewProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		if (bindingResult.hasErrors()) {
			log.error("Ошибка >> " + bindingResult.getAllErrors());
			return "new-product";
		}
		else {
			productRepository.save(product);
			log.info(product.toString());
			return "redirect:/products";
		}
	}
	
	
	@PostMapping(value = "/edit")
	public String saveEditProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
		Iterable<Manufacturer> manufacturers = manufacturerRepository.findAll();
		model.addAttribute("manufacturers", manufacturers);
		if (bindingResult.hasErrors()) {
			return "product-edit";
		}
		else {
			productRepository.save(product);
			return "redirect:/products";
		}
	}
	
}








