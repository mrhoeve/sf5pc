package nl.hicts.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Person {
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
}
