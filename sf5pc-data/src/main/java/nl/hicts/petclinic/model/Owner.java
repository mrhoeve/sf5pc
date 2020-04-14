package nl.hicts.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {
	@Getter
	@Setter
	@Column(name = "address")
	private String address;
	@Getter
	@Setter
	@Column(name = "city")
	private String city;
	@Getter
	@Setter
	@Column(name = "telephone")
	private String telephone;
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
}
