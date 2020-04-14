package nl.hicts.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity {
	@Getter
	@Setter
	@Column(name = "first_name")
	private String firstName;
	@Getter
	@Setter
	@Column(name = "last_name")
	private String lastName;
}
