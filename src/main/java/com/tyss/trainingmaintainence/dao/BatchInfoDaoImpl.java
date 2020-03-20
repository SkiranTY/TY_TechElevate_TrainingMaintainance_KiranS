package com.tyss.trainingmaintainence.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentsFile;

@Repository
public class BatchInfoDaoImpl implements BatchInfoDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	ValidatorFactory valid = Validation.buildDefaultValidatorFactory();
	Validator validator = valid.getValidator();
	
	@Override
	public String addbatch(BatchInfo batchinfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(batchinfo);
		transaction.commit();
		return batchinfo.getBatchcode();
	}

	@Override
	public boolean updateBatch(BatchInfo batchinfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		BatchInfo getinfo = manager.find(BatchInfo.class, batchinfo.getBatchcode());
		if (getinfo == null) {
			return false;
		}
		transaction.begin();
		getinfo.setClient(batchinfo.getClient());
		getinfo.setTechnologies(batchinfo.getTechnologies());
		getinfo.setBatchType(batchinfo.getBatchType());
		getinfo.setFeeInfo(batchinfo.getFeeInfo());
		getinfo.setCostPerCandidate(batchinfo.getCostPerCandidate());
		getinfo.setLocation(batchinfo.getLocation());
		getinfo.setTypeOfJoining(batchinfo.getTypeOfJoining());
		getinfo.setStartdate(batchinfo.getStartdate());
		getinfo.setEnddate(batchinfo.getEnddate());
		getinfo.setModeOfTraining(batchinfo.getModeOfTraining());
		getinfo.setInvoiceDate(batchinfo.getInvoiceDate());
		getinfo.setStudentfile(batchinfo.getStudentfile());
		transaction.commit();
		// manager.close();
		return true;
	}

	@Override
	public List<BatchInfo> getBatchDetails() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String info = "From BatchInfo";
		Query query = manager.createQuery(info);
		List<BatchInfo> list = query.getResultList();
		if (list == null) {
			return null;
		}
		// manager.close();
		return list;
	}

	@Override
	public List<BatchInfo> getTechnologywise() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "from BatchInfo batch group by batch.technologies";
		Query query = manager.createQuery(hql);
		List<BatchInfo> list = query.getResultList();
		if (list == null) {
			return null;
		}
		// manager.close();
		return list;
	}

	@Override
	public List<BatchInfo> getBatchStatus() throws ParseException {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "select batch from BatchInfo batch where batch.enddate < current_date()";
		Query query = manager.createQuery(hql);
		List<BatchInfo> listbycomplted = query.getResultList();
		System.out.println(listbycomplted.size());
		if (listbycomplted == null) {
			return null;
		}
		return listbycomplted;
	}

	@Override
	public List<BatchInfo> getBatchOngoing() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "select batch from BatchInfo batch where batch.enddate > current_date()";
		Query query = manager.createQuery(hql);
		List<BatchInfo> listbyOngoing = query.getResultList();
		System.out.println(listbyOngoing.size());
		if (listbyOngoing == null) {
			return null;
		}
		return listbyOngoing;
	}

	@Override
	public List<BatchInfo> getbatchYetTostart() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "select batch from BatchInfo batch where batch.startdate < current_date() and batch.startdate not in (select batch1.startdate from BatchInfo batch1 where batch1.enddate > current_date())";
		Query query = manager.createQuery(hql);
		List<BatchInfo> listbyYetTostart = query.getResultList();
		System.out.println(listbyYetTostart.size());
		if (listbyYetTostart == null) {
			return null;
		}
		return listbyYetTostart;
	}

	@Override
	public List<BatchInfo> getFreeBatches() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "select batch from BatchInfo batch where batch.feeInfo=0";
		Query query = manager.createQuery(hql);
		List<BatchInfo> freeBatches = query.getResultList();
		if (freeBatches == null) {
			return null;
		}
		return freeBatches;
	}

	@Override
	public List<BatchInfo> getPaidBatches() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String hql = "select batch from  BatchInfo batch where batch.feeInfo > 0";
		Query query = manager.createQuery(hql);
		List<BatchInfo> paidBatches = query.getResultList();
		if(paidBatches == null) {
			return null;
		}
		return paidBatches;
	}

}
