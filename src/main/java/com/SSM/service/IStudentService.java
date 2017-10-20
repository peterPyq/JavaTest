package com.SSM.service;

import java.util.List;

import com.SSM.entity.Student;

public interface IStudentService {
	
	Student doRead(String sysGuid);
	
	int doDelete(String sysGuid);
	
	int doInsert(Student record);
	
	int doSave(Student record);
	
}
