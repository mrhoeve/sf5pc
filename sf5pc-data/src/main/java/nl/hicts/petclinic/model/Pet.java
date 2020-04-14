package nl.hicts.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	@Getter
	@Setter
	@Column(name = "name")
	private String name;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@Getter
	@Setter
	@Column(name = "birth_date")
	private LocalDate birthDate;
}
