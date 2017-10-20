package com.SSM.dao;

import java.util.List;

import com.SSM.entity.Student;

public interface StudentMapper {
	
	Student selectByPrimaryKey(String sysGuid);
	
	int deleteByPrimaryKey(String sysGuid);
	
	int insert(Student record);
	
	int updateByPrimaryKey(Student record);
}
