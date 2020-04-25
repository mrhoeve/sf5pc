package nl.hicts.petclinic.service.springdatajpa;

import nl.hicts.petclinic.Repository.OwnerRepository;
import nl.hicts.petclinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
	Long ownerId = 1L;
	String lastName = "lastName";
	Owner returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
	
	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerJpaService service;
	
	@BeforeEach
	void setUp() {
	
	}
	
	@Test
	void findByLastName() {
		when(ownerRepository.findByLastName(lastName)).thenReturn(returnOwner);
		Owner owner = service.findByLastName(lastName);
		Assertions.assertEquals(lastName, owner.getLastName());
		verify(ownerRepository).findByLastName(lastName);
	}
	
	@Test
	void findAll() {
		when(ownerRepository.findAll()).thenReturn(new HashSet<Owner>(Collections.singletonList(returnOwner)));
		Set<Owner> ownerSet = service.findAll();
		assertEquals(1, ownerSet.size());
	}
	
	@Test
	void findById() {
		when(ownerRepository.findById(ownerId)).thenReturn(Optional.ofNullable(returnOwner));
		Owner owner = service.findById(ownerId);
		Assertions.assertEquals(ownerId, owner.getId());
		verify(ownerRepository).findById(ownerId);
	}
	
	@Test
	void save() {
		long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		when(ownerRepository.save(owner2)).thenReturn(owner2);
		
		Owner savedOwner = service.save(owner2);
		assertEquals(id, savedOwner.getId());
		verify(ownerRepository).save(owner2);
	}
	
	@Test
	void delete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(returnOwner);
	}
	
	@Test
	void deleteById() {
		service.deleteById(ownerId);
		verify(ownerRepository).deleteById(ownerId);
	}
}