package com.wyu.StudentInfoSys.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.service.StudentService;
import com.wyu.StudentInfoSys.utils.UploadImg;

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
			public boolean addStudent(@RequestBody Student student,
					                 @RequestParam MultipartFile file,HttpServletRequest req) {
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
			
			@RequestMapping(value = "/upLoadImg",method = RequestMethod.POST)
			public  String uploadImg(@RequestParam MultipartFile file,HttpServletRequest req) throws IOException {
				if(file.isEmpty()) {
					System.out.println("空文件！");
					return null;
				}
				//获取文件格式
				String fileType = file.getContentType();
				System.out.println("文件格式："+fileType);
				if(!fileType.contains("image")) {
					System.out.println("文件格式不正确");
					return null;
				}
				
				//获取文件名
				String fileName = file.getOriginalFilename();
				System.out.println("获取文件名:" + fileName);
				//获取文件后缀名
				String lastName = fileName.substring(fileName.lastIndexOf("."));
				if(lastName.equals("")) {
					lastName = ".jpg";
				}
				System.out.println("文件后缀名:" + lastName);
				
				
				//重新生成文件名
				fileName = UUID.randomUUID() + lastName;
				System.out.println("新文件名：" + fileName);
				//获取项目路径
		        String projectPath = req.getServletContext().getRealPath("") + "\\img";
		        System.out.println("项目路径" + projectPath);
		        if(UploadImg.upload(projectPath,file,fileName)) {
		        	//文件存放的相对路径（存于数据库）
		        	String relative = "img/" + fileName;
		        	System.out.println("文件相对路径:" + relative);
		        	return relative;
		        }else {
		        	System.out.println("上传图片到本地失败！");
		        	return null;
		        }
			}
			

}
