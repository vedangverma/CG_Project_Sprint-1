package com.cg.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.FlatDetails;

/**
 * 
 * @author Vedang
 * repository for flat details
 *
 */
@Repository
public interface FlatDetailsDAO extends JpaRepository<FlatDetails,Integer>{

}
