package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.PetType;
import nl.hicts.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long>  implements PetTypeService {
}
