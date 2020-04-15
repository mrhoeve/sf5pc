package nl.hicts.petclinic.service.springdatajpa;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.Repository.PetTypeRepository;
import nl.hicts.petclinic.model.PetType;
import nl.hicts.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {
	private final PetTypeRepository petTypeRepository;
	
	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}
	
	@Override
	public PetType findById(Long aLong) {
		return petTypeRepository.findById(aLong).orElse(null);
	}
	
	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}
	
	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}
	
	@Override
	public void deleteById(Long aLong) {
		petTypeRepository.deleteById(aLong);
	}
}
