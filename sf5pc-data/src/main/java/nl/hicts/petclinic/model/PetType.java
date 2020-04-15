package nl.hicts.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PetType extends BaseEntity {
	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}
	
	@JoinColumn(name = "name")
	private String name;
	
}
