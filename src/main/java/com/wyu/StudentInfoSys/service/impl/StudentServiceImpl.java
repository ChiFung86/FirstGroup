package com.wyu.StudentInfoSys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.mapper.StudentMapper;
import com.wyu.StudentInfoSys.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	/*查找1个学生
	 * param 学号*/
	public Student getStudent(String studentNumber) {
		// TODO Auto-generated method stub
		Student student = studentMapper.getStudent(studentNumber);
		return student;
	}

	@Override
	/*查找所有学生*/
	public List<Student> selectStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		students = studentMapper.selectStudents();
		return students;
	}

	@Override
	/*查找所有学生
	 * param Student*/
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			studentMapper.saveStudent(student);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("错误");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	/*删除学生
	 * param 学号*/
	public boolean deleteStudent(String studentNumber) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			studentMapper.deleteStudent(studentNumber);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("错误");
			e.printStackTrace();
		}
		return flag;
	}

	/*修改学生信息
	 * param Student*/
	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			studentMapper.updateStudent(student);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	/*分页查询
	 * param1 页数
	 * param2 页*/
	@Override
	public PageInfo<Student> getStudentPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize,true);
		List<Student> students = studentMapper.selectStudents();
		PageInfo<Student> pageInfo = new PageInfo<Student>(students);
		return pageInfo;
	}

}
