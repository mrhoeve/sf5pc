package nl.hicts.petclinic.bootstrap;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.model.Owner;
import nl.hicts.petclinic.model.Vet;
import nl.hicts.petclinic.service.OwnerService;
import nl.hicts.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService verService;
	
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");

		verService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		verService.save(vet2);
		
		System.out.println("Loaded Vets...");
	}
}
