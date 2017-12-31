package com.project.mountains.dao;

import java.util.List;

import com.project.mountains.entity.Mountain;

public interface MountainDAO {

	public List<Mountain> getMountains();

	public void saveMountain(Mountain theMountain);

	public Mountain getMountain(int theRank);

	public void deleteMountain(int theRank);
}
