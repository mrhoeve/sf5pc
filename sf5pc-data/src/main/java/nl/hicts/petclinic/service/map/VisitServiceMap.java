package nl.hicts.petclinic.service.map;

import lombok.RequiredArgsConstructor;
import nl.hicts.petclinic.model.Visit;
import nl.hicts.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null ||
				visit.getPet().getOwner() == null ||
				visit.getPet().getId() == null ||
				visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}
		return super.save(visit);
	}
}
