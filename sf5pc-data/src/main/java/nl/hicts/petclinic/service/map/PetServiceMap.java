package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.Pet;
import nl.hicts.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
