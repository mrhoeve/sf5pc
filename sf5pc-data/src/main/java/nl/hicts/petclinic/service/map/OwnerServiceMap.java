package nl.hicts.petclinic.service.map;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.model.Owner;
import nl.hicts.petclinic.service.OwnerService;
import nl.hicts.petclinic.service.PetService;
import nl.hicts.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId()==null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required");
					}
					if(pet.getId() == null) {
						petService.save(pet).getId();
					}
				});
			}
			return super.save(object);
		}
		return null;
	}
	
	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
}
