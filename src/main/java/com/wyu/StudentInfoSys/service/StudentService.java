package com.wyu.StudentInfoSys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wyu.StudentInfoSys.entity.Infor;
import com.wyu.StudentInfoSys.entity.Student;

public interface StudentService {
	 List<Student> getStudent(Student student);   //模糊查询
     List<Student> selectStudents();      //查询所有学生
	 boolean addStudent(Student student);   //添加学生
	 boolean deleteStudent(String studentNumber);   //删除学生
	 boolean updateStudent(Student student);  //修改学生信息
	
	PageInfo<Student> getStudentPage(int pageNum, int pageSize,String way);    //分页查询
	
	List<Infor> allInfors();   //统计学生信息
	
	List<Infor> departInfors();  //返回系部种类
	
}
