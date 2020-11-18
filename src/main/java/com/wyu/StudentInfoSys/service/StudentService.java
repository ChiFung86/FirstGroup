package com.wyu.StudentInfoSys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wyu.StudentInfoSys.entity.Student;

public interface StudentService {
	 Student getStudent(String studentNumber);
     List<Student> selectStudents();
	 boolean addStudent(Student student);
	 boolean deleteStudent(String studentNumber);
	 boolean updateStudent(Student student);
	 void summaryStudent();
	 PageInfo<Student> getStudentPage(int pageNum, int pageSize);
}
