package nl.hicts.petclinic.bootstrap;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.model.*;
import nl.hicts.petclinic.service.OwnerService;
import nl.hicts.petclinic.service.PetTypeService;
import nl.hicts.petclinic.service.SpecialtyService;
import nl.hicts.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService verService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	
	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		
		if(count==0) {
			loadData();
		}
	}
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType typeDog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType typeCat = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(typeDog);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");
		
		Pet fionasCat = new Pet();
		fionasCat.setPetType(typeCat);
		fionasCat.setName("Just Cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty surgery = new Specialty();
		radiology.setDescription("Surgery");
		Specialty dentistry = new Specialty();
		radiology.setDescription("Dentistry");
		specialtyService.save(radiology);
		specialtyService.save(surgery);
		specialtyService.save(dentistry);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(radiology);
		
		verService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(surgery);
		
		verService.save(vet2);
	}
}
