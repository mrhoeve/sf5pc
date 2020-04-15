package nl.hicts.petclinic.service.springdatajpa;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.Repository.SpecialtyRepository;
import nl.hicts.petclinic.model.Specialty;
import nl.hicts.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService {
	private final SpecialtyRepository specialtyRepository;
	
	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}
	
	@Override
	public Specialty findById(Long aLong) {
		return specialtyRepository.findById(aLong).orElse(null);
	}
	
	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}
	
	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}
	
	@Override
	public void deleteById(Long aLong) {
		specialtyRepository.deleteById(aLong);
	}
}
