package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.PetType;
import nl.hicts.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long>  implements PetTypeService {
}
