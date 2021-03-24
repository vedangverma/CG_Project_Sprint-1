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
import com.cg.aps.entity.FlatDetails;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.FlatDetailsService;

@SpringBootTest(classes = ApartmentSecurityAppApplication.class)
@Transactional
@Rollback(true)
public class FlatDetailsTest {

	@Autowired
	private FlatDetailsService flatService;
	
	public FlatDetails addDetails() throws DuplicateRecordException, RecordNotFoundException {
		FlatDetails details = new FlatDetails();
		details.setFlatNo(10);
		details.setFloorNo(5);
		Integer id = flatService.addFlatDetails(details);
		return flatService.findByPk(id);
	} 
	
	/*
	 * check add flat details
	 */
	@Test
	public void testAddDetails() throws DuplicateRecordException, RecordNotFoundException {
		FlatDetails details = addDetails();
		assertEquals(10, details.getFlatNo());
		assertNotEquals(15,details.getFloorNo());
	}
	
	/*
	 * check edit flat details
	 */
	@Test
	public void testEditDetails() throws DuplicateRecordException, RecordNotFoundException {
		FlatDetails details = addDetails();
		details.setFlatNo(20);
		details.setFloorNo(3);
		flatService.updateFlatDetails(details);
		assertNotEquals(10,flatService.findByPk(details.getFlatId()).getFlatNo());
		assertEquals(3,flatService.findByPk(details.getFlatId()).getFloorNo());
	}
	
	/*
	 * check delete flat details
	 */
	@Test
	public void testDeleteDetails() throws DuplicateRecordException, RecordNotFoundException {
		FlatDetails details = addDetails();
		flatService.deleteFlatDetails(details);
		assertThrows(RecordNotFoundException.class, ()->{
			flatService.findByPk(details.getFlatId());
			});
	}
}
