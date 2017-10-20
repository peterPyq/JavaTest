package com.SSM.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SSM.dao.StudentDao;
import com.SSM.entity.Student;
import com.SSM.service.IStudentService;

@Service
@Lazy(false)
public class StudentServiceImpl implements IStudentService {

	@Resource
	private StudentDao dao;
	
	public Student doRead(String sysGuid) {
		return dao.selectByPrimaryKey(sysGuid);
	}

	@Transactional
	public int doDelete(String sysGuid) {
		return dao.deleteByPrimaryKey(sysGuid);
	}

	@Transactional
	public int doInsert(Student record) {
		record.setSysGuid(newPK());
		return dao.insert(record);
	}

	@Transactional
	public int doSave(Student record) {
		return dao.updateByPrimaryKey(record);
	}
	
	public String newPK() {
		return java.util.UUID.randomUUID().toString();
	}
}
