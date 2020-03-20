package com.tyss.trainingmaintainence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.CalenderInfo;

@Repository
public class CalenderInfoDaoImpl implements CalenderInfoDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public CalenderInfo addCalenderInfo(CalenderInfo calenderinfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		// calenderinfo.setBatchinfo(manager.find(BatchInfo.class,
		// calenderinfo.getBatchinfo().getBatchcode()));
		manager.persist(calenderinfo);
		transaction.commit();
		manager.close();
		return calenderinfo;
	}

	@Override
	public List<CalenderInfo> getCalenderInfo() {
		CalenderInfo info = new CalenderInfo();
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = "From CalenderInfo";
		Query query = manager.createQuery(jpql);
		List<CalenderInfo> calinfo = query.getResultList();
		manager.close();
		return calinfo;
	}

}
