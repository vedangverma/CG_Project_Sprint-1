package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.dao.FlatDetailsDAO;
import com.cg.aps.entity.FlatDetails;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;

/**
 * 
 * @author Vedang
 * implementation class of flat details service
 *
 */
@Service
@Transactional
public class FlatDetailsServiceImpl implements FlatDetailsService{

	@Autowired
	private FlatDetailsDAO flatDetailsDao;
	
	@Override
	public Integer addFlatDetails(FlatDetails flatDetails) throws DuplicateRecordException {
		try {			
			flatDetailsDao.save(flatDetails);
			return flatDetails.getFlatId();
		}catch(DataAccessException e) {
			throw new DuplicateRecordException(e.getMessage());
		}catch(Exception e) {
			throw new DuplicateRecordException(e.getMessage());
		}
	}

	@Override
	public void updateFlatDetails(FlatDetails flatDetails) throws RecordNotFoundException {
		try {			
			flatDetailsDao.save(flatDetails);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deleteFlatDetails(FlatDetails flatDetails) throws RecordNotFoundException {
		try {			
			flatDetailsDao.delete(flatDetails);
		}catch(DataAccessException e) {
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new RecordNotFoundException(e.getMessage());
		}
	}

	@Override
	public FlatDetails findByPk(Integer id) throws RecordNotFoundException {
		try {			
			Optional<FlatDetails> optional = flatDetailsDao.findById(id);
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
	public List<FlatDetails> search(Integer pageNo, Integer pageSize) throws DatabaseException {
		try {	
			PageRequest paging = PageRequest.of(pageNo, pageSize);
			Page<FlatDetails> pagedResult = flatDetailsDao.findAll(paging);
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
	public List<FlatDetails> search() throws DatabaseException {
		try {			
			return flatDetailsDao.findAll();
		}catch(DataAccessException e) {
			throw new DatabaseException(e.getMessage());
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		
		}
	}

}
