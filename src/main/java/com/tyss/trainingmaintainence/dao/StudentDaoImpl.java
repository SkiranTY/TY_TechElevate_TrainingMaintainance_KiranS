package com.tyss.trainingmaintainence.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.tyss.trainingmaintainence.dto.BatchInfo;
import com.tyss.trainingmaintainence.dto.StudentPk;
import com.tyss.trainingmaintainence.dto.StudentsFile;

@Repository
public class StudentDaoImpl implements StudentFileDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean uploadFile(MultipartFile file, String batchcode) throws Exception {

		// List<StudentsFile> tempStudentList = new ArrayList<StudentsFile>();

		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

		XSSFSheet worksheet = workbook.getSheetAt(0);

		StudentsFile students = new StudentsFile();

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String hql = "from StudentsFile";
		Query query = manager.createQuery(hql);
		List<StudentsFile> list = query.getResultList();
		System.out.println(list.size());
		transaction.commit();
		int getnorows = list.size();

		if (getnorows == 0) {
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

				XSSFRow row = worksheet.getRow(i);

//			int id=row.getCell(0).getRowIndex();
//			StudentPk pk=new StudentPk();

				students.setId(row.getCell(0).getRowIndex());
				students.setFirstName(row.getCell(0).getStringCellValue());
				students.setLastName(row.getCell(1).getStringCellValue());
				students.setUserType(row.getCell(2).getStringCellValue());
				students.setUserId((row.getCell(3).getStringCellValue()));
				students.setPassword(row.getCell(4).getStringCellValue());
				students.setEmailId(row.getCell(5).getStringCellValue());
				students.setMobileNumber((double) row.getCell(6).getNumericCellValue());
				students.setGender(row.getCell(7).getStringCellValue());
				students.setHomeTown(row.getCell(8).getStringCellValue());
				students.setState(row.getCell(9).getStringCellValue());
				students.setAggregate_10th((int) row.getCell(10).getNumericCellValue());
				students.setAggregate_12th((int) row.getCell(11).getNumericCellValue());
				students.setDegreeAggregate((int) row.getCell(12).getNumericCellValue());
				students.setDegree(row.getCell(13).getStringCellValue());
				students.setDegreeStream(row.getCell(14).getStringCellValue());
				students.setDegree_YOP((int) row.getCell(15).getNumericCellValue());
				students.setCollege_name(row.getCell(16).getStringCellValue());
				students.setCollege_location(row.getCell(17).getStringCellValue());

				EntityManager manager1 = factory.createEntityManager();
				EntityTransaction transaction1 = manager1.getTransaction();
				transaction1.begin();
				Query query1 = manager1.createNativeQuery(
						"INSERT INTO students_file(student_id,first_name,last_name,user_type,user_id,password,email_id,mobile_number,gender,home_town,State,10th_aggregate,12th_aggregate,degree_aggregate,degree,degree_stream,degree_YOP,college_name,college_location,batchcode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				query1.setParameter(1, students.getId());
				query1.setParameter(2, students.getFirstName());
				query1.setParameter(3, students.getLastName());
				query1.setParameter(4, students.getUserType());
				query1.setParameter(5, students.getUserId());
				query1.setParameter(6, students.getPassword());
				query1.setParameter(7, students.getEmailId());
				query1.setParameter(8, students.getMobileNumber());
				query1.setParameter(9, students.getGender());
				query1.setParameter(10, students.getHomeTown());
				query1.setParameter(11, students.getState());
				query1.setParameter(12, students.getAggregate_10th());
				query1.setParameter(13, students.getAggregate_12th());
				query1.setParameter(14, students.getDegreeAggregate());
				query1.setParameter(15, students.getDegree());
				query1.setParameter(16, students.getDegreeStream());
				query1.setParameter(17, students.getDegree_YOP());
				query1.setParameter(18, students.getCollege_name());
				query1.setParameter(19, students.getCollege_location());
				query1.setParameter(20, students.setBatchinfo(manager1.find(BatchInfo.class, batchcode)));
				int count = query1.executeUpdate();
				System.out.println("Count update" + count);
				transaction1.commit();

				System.out.println(students.getId() + " " + students.getFirstName());
			}
		} else {
			for (int i = getnorows + 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

				XSSFRow row = worksheet.getRow(i);

				students.setId(row.getCell(0).getRowIndex());
				students.setFirstName(row.getCell(0).getStringCellValue());
				students.setLastName(row.getCell(1).getStringCellValue());
				students.setUserType(row.getCell(2).getStringCellValue());
				students.setUserId((row.getCell(3).getStringCellValue()));
				students.setPassword(row.getCell(4).getStringCellValue());
				students.setEmailId(row.getCell(5).getStringCellValue());
				students.setMobileNumber((double) row.getCell(6).getNumericCellValue());
				students.setGender(row.getCell(7).getStringCellValue());
				students.setHomeTown(row.getCell(8).getStringCellValue());
				students.setState(row.getCell(9).getStringCellValue());
				students.setAggregate_10th((int) row.getCell(10).getNumericCellValue());
				students.setAggregate_12th((int) row.getCell(11).getNumericCellValue());
				students.setDegreeAggregate((int) row.getCell(12).getNumericCellValue());
				students.setDegree(row.getCell(13).getStringCellValue());
				students.setDegreeStream(row.getCell(14).getStringCellValue());
				students.setDegree_YOP((int) row.getCell(15).getNumericCellValue());
				students.setCollege_name(row.getCell(16).getStringCellValue());
				students.setCollege_location(row.getCell(17).getStringCellValue());

				EntityManager manager1 = factory.createEntityManager();
				EntityTransaction transaction1 = manager1.getTransaction();
				transaction1.begin();
				Query query1 = manager1.createNativeQuery(
						"INSERT INTO students_file(student_id,first_name,last_name,user_type,user_id,password,email_id,mobile_number,gender,home_town,State,10th_aggregate,12th_aggregate,degree_aggregate,degree,degree_stream,degree_YOP,college_name,college_location,batchcode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				query1.setParameter(1, students.getId());
				query1.setParameter(2, students.getFirstName());
				query1.setParameter(3, students.getLastName());
				query1.setParameter(4, students.getUserType());
				query1.setParameter(5, students.getUserId());
				query1.setParameter(6, students.getPassword());
				query1.setParameter(7, students.getEmailId());
				query1.setParameter(8, students.getMobileNumber());
				query1.setParameter(9, students.getGender());
				query1.setParameter(10, students.getHomeTown());
				query1.setParameter(11, students.getState());
				query1.setParameter(12, students.getAggregate_10th());
				query1.setParameter(13, students.getAggregate_12th());
				query1.setParameter(14, students.getDegreeAggregate());
				query1.setParameter(15, students.getDegree());
				query1.setParameter(16, students.getDegreeStream());
				query1.setParameter(17, students.getDegree_YOP());
				query1.setParameter(18, students.getCollege_name());
				query1.setParameter(19, students.getCollege_location());
				query1.setParameter(20, students.setBatchinfo(manager1.find(BatchInfo.class, batchcode)));
				int count = query1.executeUpdate();
				System.out.println("Count update" + count);
				transaction1.commit();

				System.out.println(students.getId() + " " + students.getFirstName());
			}

		}
		System.out.println("file is uploaded and stored in db");
		return true;
	}

	@Override
	public List<StudentsFile> getDetails() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String get = "from StudentsFile";
		Query query = manager.createQuery(get);
		List<StudentsFile> studentlist = query.getResultList();
		transaction.commit();
		manager.close();
		return studentlist;
	}

	@Override
	public List<StudentsFile> getFreeBatchStudents() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String hql = "select students from StudentsFile students where students.batchinfo in (select batch1.batchcode from BatchInfo batch1 where batch1.feeInfo=0)";
		Query query = manager.createQuery(hql);
		List<StudentsFile> list = query.getResultList();
		if(list == null) {
			return null;			
		}
		return list;
	}
}