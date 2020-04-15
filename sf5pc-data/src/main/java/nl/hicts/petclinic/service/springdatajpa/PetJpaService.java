package nl.hicts.petclinic.service.springdatajpa;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.Repository.PetRepository;
import nl.hicts.petclinic.model.Pet;
import nl.hicts.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class PetJpaService implements PetService {
	private final PetRepository petRepository;
	
	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}
	
	@Override
	public Pet findById(Long aLong) {
		return petRepository.findById(aLong).orElse(null);
	}
	
	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}
	
	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}
	
	@Override
	public void deleteById(Long aLong) {
		petRepository.deleteById(aLong);
	}
}
