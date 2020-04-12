package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID> {
	
	protected Map<ID, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		map.put((ID)object.getId(), object);
		
		return object;
	}
	
	void deleteById(Long id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.remove(object.getId());
	}
}
