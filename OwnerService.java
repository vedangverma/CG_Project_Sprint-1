package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.Owner;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Vedang
 * interface of owner service and it's methods
 *
 */
public interface OwnerService {

	public Integer addOwner(Owner owner) throws DuplicateRecordException;
	public void updateOwner(Owner owner) throws RecordNotFoundException;
	public void deleteOwner(Owner owner) throws RecordNotFoundException;
	public List<Owner> findByOwnerName(String name) throws RecordNotFoundException;
	public Owner findByPk(Integer id) throws RecordNotFoundException;
	public List<Owner> search(Integer pageNo, Integer pageSize) throws DatabaseException;
	public List<Owner> search() throws DatabaseException;
}
