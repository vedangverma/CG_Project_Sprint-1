package com.cg.aps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.Owner;
/**
 * 
 * @author Vedang
 * owner class DAO layer
 *
 */
@Repository
public interface OwnerDAO extends JpaRepository<Owner,Integer> {

	@Query("select o from Owner o where o.ownerName = :name")
	public List<Owner> findByOwnerName(String name) throws Exception;
}
