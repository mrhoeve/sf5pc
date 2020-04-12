package nl.hicts.petclinic.service;

import nl.hicts.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
}
