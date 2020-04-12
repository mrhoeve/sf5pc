package nl.hicts.petclinic.controller;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
@RequiredArgsConstructor
public class OwnerController {
	private final OwnerService ownerService;
	
	@RequestMapping({"/", "", "/index", "/index.html"})
	public String index(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
}
