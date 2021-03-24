package com.cg.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.aps.application.ApartmentSecurityAppApplication;
import com.cg.aps.entity.Owner;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.OwnerService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class OwnerTest {

	@Autowired
	private OwnerService ownerService;
	
	public Owner addOwner() throws DuplicateRecordException, RecordNotFoundException {
		Owner owner = new Owner();
		owner.setOwnerId(1001);
		owner.setOwnerName("Harsh");
		owner.setMobileNo(9876543210L);
		owner.setEmailId("harsh@agarwal.com");
		Integer id = ownerService.addOwner(owner);
		return ownerService.findByPk(id);
	} 
	
	/*
	 * check add owner
	 */
	@Test
	public void testAddOwner() throws DuplicateRecordException, RecordNotFoundException {
		Owner owner = addOwner();
		assertEquals(1001, owner.getOwnerId());
		assertNotEquals("xyz",owner.getOwnerName());
		assertEquals(9876543210L,owner.getMobileNo());
		assertNotEquals("anna@gmail.com",owner.getEmailId());
	}
	
	/*
	 * check edit owner
	 */
	@Test
	public void testEditOwner() throws DuplicateRecordException, RecordNotFoundException {
		Owner owner = addOwner();
		owner.setOwnerName("Harsh Agarwal");
		owner.setMobileNo(9012345678L);
		ownerService.updateOwner(owner);
		assertNotEquals("Anna",ownerService.findByPk(owner.getOwnerId()).getOwnerName());
		assertEquals(9012345678L,ownerService.findByPk(owner.getOwnerId()).getMobileNo());
	}
	
	/*
	 * check delete owner
	 */
	@Test
	public void testDeleteOwner() throws DuplicateRecordException, RecordNotFoundException {
		Owner owner = addOwner();
		ownerService.deleteOwner(owner);
		assertThrows(RecordNotFoundException.class, ()->{
			ownerService.findByPk(owner.getOwnerId());
			});
	}
}
