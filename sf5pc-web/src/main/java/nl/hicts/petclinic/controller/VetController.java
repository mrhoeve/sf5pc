package nl.hicts.petclinic.controller;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
@RequiredArgsConstructor
public class VetController {
	private final VetService vetService;
	
	@RequestMapping({"/", "", "/index", "/index.html"})
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
}
