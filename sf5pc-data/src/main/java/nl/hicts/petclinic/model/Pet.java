package nl.hicts.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
public class Pet {
	@Getter
	@Setter
	private PetType petType;
	@Getter
	@Setter
	private Owner owner;
	@Getter
	@Setter
	private LocalDate birthDate;
}
