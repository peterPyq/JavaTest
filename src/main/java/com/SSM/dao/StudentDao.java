package com.SSM.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SSM.entity.Student;

public class StudentDao {
	@Autowired
	StudentMapper mapper;
	
	public Student selectByPrimaryKey(String sysGuid){
		return mapper.selectByPrimaryKey(sysGuid);
	}
	
	public int deleteByPrimaryKey(String sysGuid){
		return mapper.deleteByPrimaryKey(sysGuid);
	}
	
	public int insert(Student record){
		return mapper.insert(record);
	}
	
	public int updateByPrimaryKey(Student record){
		return mapper.updateByPrimaryKey(record);
	}
}
