package nl.hicts.petclinic.service;

import nl.hicts.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
	
}
