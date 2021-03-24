package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.FlatDetails;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * 
 * @author Vedang
 * service layer interface of flat details
 *
 */

public interface FlatDetailsService {

	public Integer addFlatDetails(FlatDetails flatDetails) throws DuplicateRecordException;
	public void updateFlatDetails(FlatDetails flatDetails) throws RecordNotFoundException;
	public void deleteFlatDetails(FlatDetails flatDetails) throws RecordNotFoundException;
	public FlatDetails findByPk(Integer id) throws RecordNotFoundException;
	public List<FlatDetails> search(Integer pageNo, Integer pageSize) throws DatabaseException;
	public List<FlatDetails> search() throws DatabaseException;
}
