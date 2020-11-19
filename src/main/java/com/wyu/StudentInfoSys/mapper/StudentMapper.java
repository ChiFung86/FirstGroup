package com.wyu.StudentInfoSys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wyu.StudentInfoSys.entity.Infor;
import com.wyu.StudentInfoSys.entity.Student;

@Mapper
public interface StudentMapper {
	/*模糊查找学生*/
	public List<Student> getStudent(Student student);
	
	/*查找所有学生*/
	public List<Student> selectStudents();
	
	/*增加学生*/
	public void saveStudent(Student student);
	
	/*删除学生*/
	public void deleteStudent(String studentNumber);
	
	/*修改学生*/
	public void updateStudent(Student student);
	
	/*统计学生信息*/
	public List<Infor> departInfors();
	public List<Infor>classInfors();
	public List<Infor>sexInfors();
	public List<Infor>stuInfors();
	
}
