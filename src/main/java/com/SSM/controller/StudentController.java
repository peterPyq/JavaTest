package com.SSM.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SSM.entity.Student;
import com.SSM.service.IStudentService;
import com.SSM.util.Result;

@Controller
public class StudentController {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private static final Logger logger = Logger
			.getLogger(StudentController.class);
	
	@Resource
	private IStudentService studentService;
	
	@RequestMapping("/student/doRead.do")	
	public String actList(@Param(value = "sysGuid")String sysGuid, ModelMap map) {
		boolean state = true; 
		Student student = studentService.doRead(sysGuid);
		if(null == student) {
			state=false;
			String error="not found!";
			map.put("models", new Result<Student>(state,error));
			return "Error";
		}
			
		map.put("models", new Result<Student>(state,student));
		return "StudentInfo";
	}
	
	@RequestMapping("/student/doDelete.do")	
	public String delete(@Param(value = "sysGuid")String sysGuid, ModelMap map) {
		boolean state = true; 
		int number = studentService.doDelete(sysGuid);
		if(number < 1) {
			state=false;
			String error="delete failed!";
			map.put("models", new Result<Student>(state,error));
			return "Error";
		}
			
		return "Success";
	}
	
	@RequestMapping("/student/doInsert.do")	
	public String insert(ModelMap map) {
		boolean state = true; 
		
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setSchoolId(request.getParameter("schoolId"));
		
		int number = studentService.doInsert(student);
		if(number < 1) {
			state=false;
			String error="insert failed!";
			map.put("models", new Result<Student>(state,error));
			return "Error";
		}
			
		map.put("models", new Result<Student>(state,student));
		return "StudentInfo";
	}
	
	@RequestMapping("/student/doSave.do")	
	public String save(@Param(value = "sysGuid")String sysGuid, ModelMap map) {
		boolean state = true; 
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setSchoolId(request.getParameter("schoolId"));
		
		int number = studentService.doSave(student);
		if(number < 1) {
			state=false;
			String error="update failed!";
			map.put("models", new Result<Student>(state,error));
			return "Error";
		}
			
		map.put("models", new Result<Student>(state,student));
		return "StudentInfo";
	}
	
}
