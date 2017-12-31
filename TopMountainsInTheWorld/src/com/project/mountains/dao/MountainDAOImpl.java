package com.project.mountains.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mountains.entity.Mountain;

@Repository
public class MountainDAOImpl implements MountainDAO{

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	//@Transactional
	public List<Mountain> getMountains() {

		Session session = sessionFactory.getCurrentSession();
		//Query<Mountain> theQuery = session.createQuery("from Mountains", Mountain.class);
		Query<Mountain> theQuery = session.createQuery("from Mountain order by rank", Mountain.class);

		List<Mountain> mountains = theQuery.getResultList();

		return mountains;

	}

	@Override
	public void saveMountain(Mountain theMountain) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		//save the mountain info
		//session.save(theMountain);
		session.saveOrUpdate(theMountain);
	}

	@Override
	public Mountain getMountain(int theRank) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		//get the mountain info using rank
		Mountain theMountain = session.get(Mountain.class, theRank);
		return theMountain;
	}

	@Override
	public void deleteMountain(int theRank) {
		//get the current hibernate session
		Session session=sessionFactory.getCurrentSession();

		//delete the mountain using rank 
		/*Mountain theMountain = session.get(Mountain.class, theRank);
		session.delete(theMountain);*/
				
		Query theQuery = session.createQuery("delete from Mountain where rank=:theRank");
		theQuery.setParameter("theRank", theRank);
		theQuery.executeUpdate();
	}
	

}
