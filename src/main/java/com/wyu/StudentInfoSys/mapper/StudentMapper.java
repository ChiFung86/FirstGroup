package com.wyu.StudentInfoSys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wyu.StudentInfoSys.entity.Student;

@Mapper
public interface StudentMapper {
	/*查找1个学生*/
	public Student getStudent(String studentNumber);
	
	/*查找所有学生*/
	public List<Student> selectStudents();
	
	/*增加学生*/
	public void saveStudent(Student student);
	
	/*删除学生*/
	public void deleteStudent(String studentNumber);
	
	/*修改学生*/
	public void updateStudent(Student student);
	
	//统计学生信息
	public void summaryStudent();
}
