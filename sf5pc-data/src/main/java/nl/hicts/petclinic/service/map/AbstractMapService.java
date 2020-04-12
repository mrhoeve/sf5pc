package nl.hicts.petclinic.service.map;

import nl.hicts.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	
	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if(object != null) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);

			return object;
		} else {
			throw new RuntimeException("Object cannot be null");
		}
	}
	
	void deleteById(Long id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.remove(object.getId());
	}
	
	private Long getNextId() {
		if(map.size() > 0) {
			return Collections.max(map.keySet()) + 1;
		}
		return 1L;
	}
}
