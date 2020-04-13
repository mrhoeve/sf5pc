package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.Vet;
import nl.hicts.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
