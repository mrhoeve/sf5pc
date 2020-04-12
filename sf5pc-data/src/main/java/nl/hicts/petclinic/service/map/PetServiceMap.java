package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.Pet;
import nl.hicts.petclinic.service.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
	
	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}
	
}
