package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.Owner;
import nl.hicts.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
}
