package nl.hicts.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
	@Getter
	@Setter
	@JoinColumn(name = "name")
	private String name;
	
}
