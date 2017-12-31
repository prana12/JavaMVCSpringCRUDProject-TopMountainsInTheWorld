package com.project.mountains.service;

import java.util.List;

import com.project.mountains.entity.Mountain;

public interface MountainService {

	public List<Mountain> getMountains();

	public void saveMountain(Mountain theMountain);

	public Mountain getMountain(int theRank);

	public void deleteMountain(int theRank);
}
