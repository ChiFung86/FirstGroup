package com.wyu.StudentInfoSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.service.StudentService;

@RestController
public class StudentContorller {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public boolean delete(
			  @RequestBody String studentNumber) {
		        System.out.println(studentNumber);
				System.out.println("删除开始"); 
				return studentService.deleteStudent(studentNumber);
			}
			
			@RequestMapping(value="/save",method = RequestMethod.POST)
			public boolean addStudent(@RequestBody Student student) {
				System.out.println("开始增加...");
//				studentService.addStudent(student);
//				String name = student.getName();
//				for(int i=2;i<=100;i++) {
//					student = new Student();
//					student.setStudentNumber(String.valueOf(i));
//					student.setName(name + i);
//					student.setClassName("" + i + "班");
//					System.out.println(student.toString());
//					studentService.addStudent(student);
//				}
				return studentService.addStudent(student);
			}
			
			@RequestMapping(value="/get",method = RequestMethod.GET)
			public Student getStudent(@RequestBody String studentNumber) {
				System.out.println("开始查找...");
				return studentService.getStudent(studentNumber);
			}
			
			@RequestMapping(value = "/update",method = RequestMethod.PUT)
			public boolean updateStudent(@RequestBody Student student) {
				
				System.out.println("开始修改.....");
				return studentService.updateStudent(student);
			}
			
			@RequestMapping(value = "/page",method = RequestMethod.GET)
			public Object getStudentPage(@RequestParam("pageNum") int pageNum, 
					                     @RequestParam("pageSize") int pageSize) {
				System.out.println("开始分页.......");
				return studentService.getStudentPage(pageNum, pageSize);
			}
			
			@RequestMapping("@uploadImg")
			public String uploadImg(@RequestParam("fileName") MultipartFile file) {
				return null;
			}
}
