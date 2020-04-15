package nl.hicts.petclinic.service.map;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.model.Vet;
import nl.hicts.petclinic.service.SpecialtyService;
import nl.hicts.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	private final SpecialtyService specialtyService;
	
	@Override
	public Vet save(Vet vet) {
		if(vet.getSpecialities() != null) {
			vet.getSpecialities().forEach(specialty -> {
				if(specialty.getId()==null) {
					specialtyService.save(specialty);
				}
			});
		}
		return super.save(vet);
	}
}
