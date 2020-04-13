package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.Specialty;
import nl.hicts.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
