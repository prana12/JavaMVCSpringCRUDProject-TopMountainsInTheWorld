package com.project.mountains.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.mountains.dao.MountainDAO;
import com.project.mountains.entity.Mountain;

@Service
public class MountainServiceImpl implements MountainService{

	@Autowired
	private MountainDAO mountainsDAO;
	
	@Override
	@Transactional
	public List<Mountain> getMountains() {
		return mountainsDAO.getMountains();
	}

	@Override
	@Transactional
	public void saveMountain(Mountain theMountain) {
		mountainsDAO.saveMountain(theMountain);		
	}

	@Override
	@Transactional
	public Mountain getMountain(int theRank) {
		return mountainsDAO.getMountain(theRank);
	}

	@Override
	@Transactional
	public void deleteMountain(int theRank) {
		mountainsDAO.deleteMountain(theRank);
	}

}
