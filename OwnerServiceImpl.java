package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.dao.OwnerDAO;
import com.cg.aps.entity.Owner;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
/**
 * 
 * @author Vedang
 * implementing the owner service interface
 *
 */
@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerDAO ownerDao;
	
	@Override
	public Integer addOwner(Owner owner) throws DuplicateRecordException {
		try {	
			ownerDao.save(owner);
			return owner.getOwnerId();
		}catch(DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		}catch(Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public void updateOwner(Owner owner) throws RecordNotFoundException {
		try {			
			ownerDao.save(owner);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public void deleteOwner(Owner owner) throws RecordNotFoundException {
		try {			
			ownerDao.delete(owner);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public Owner findByPk(Integer id) throws RecordNotFoundException {
		try {			
			Optional<Owner> optional = ownerDao.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid id");
			}
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Owner> search(Integer pageNo, Integer pageSize) throws DatabaseException {
		try {	
			PageRequest paging = PageRequest.of(pageNo, pageSize);
			Page<Owner> pagedResult = ownerDao.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				throw new Exception("Invalid pageNo and pageSize");
			}
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public List<Owner> search() throws DatabaseException {
		try {			
			return ownerDao.findAll();
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public List<Owner> findByOwnerName(String name) throws RecordNotFoundException {
		try {			
			return ownerDao.findByOwnerName(name);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}


}
