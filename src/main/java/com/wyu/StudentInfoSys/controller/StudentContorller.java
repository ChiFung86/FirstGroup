package com.wyu.StudentInfoSys.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wyu.StudentInfoSys.entity.Infor;
import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.service.StudentService;
import com.wyu.StudentInfoSys.utils.UploadImg;

@RestController
public class StudentContorller {

	@Autowired
	private StudentService studentService;

	/*
	 * 删除信息 
	 * studentNumber 学号
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean delete(@RequestParam String studentNumber) {
		System.out.println("删除开始");
		return studentService.deleteStudent(studentNumber);
	}
	

	/*
	 * 增加信息
	 *  Student 学生对象 
	 *  file 图片
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean addStudent(@RequestBody Student student, HttpServletRequest req) {
		System.out.println("开始增加...");
		return studentService.addStudent(student);
	}
	

	/*模糊查询
	 * Student 学生对象*/
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public List<Student> getStudent(@RequestBody Student student) {
		System.out.println("开始模糊查找...");
		System.out.println(student);
		return studentService.getStudent(student);
	}
	

	/*
	 * 修改信息
	 * Student 学生对象*/
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateStudent(@RequestBody Student student) {

		System.out.println("开始修改.....");
		return studentService.updateStudent(student);
	}
	

	/*分页查询
	 * pageNum 页码
	 * pageSize 每页行数*/
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public Object getStudentPage(@RequestParam("pageNum") int pageNum, 
			                     @RequestParam("pageSize") int pageSize,
			                     @RequestParam("way") String way) {
		System.out.println("开始分页.......");
		return studentService.getStudentPage(pageNum, pageSize,way);
	}
	

	/*上传图片
	 * file 图片
	 * req 请求类*/
	@RequestMapping(value = "/upLoadImg", method = RequestMethod.POST)
	public String uploadImg(@RequestParam MultipartFile file, HttpServletRequest req) throws IOException {
		if (file.isEmpty()) {
			return null;
		}
		// 获取文件格式
		String fileType = file.getContentType();
		if (!fileType.contains("image")) {
			return null;
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		
		// 获取文件后缀名
		String lastName = fileName.substring(fileName.lastIndexOf("."));
		if (lastName.equals("")) {
			lastName = ".jpg";
		}
		
		// 重新生成文件名
		fileName = UUID.randomUUID() + lastName;
		System.out.println("新文件名：" + fileName);
		// 获取项目路径
		String projectPath = req.getServletContext().getRealPath("") + "\\img";
		if (UploadImg.upload(projectPath, file, fileName)) {
			// 文件存放的路径（存于数据库）
			String relative = "http://localhost:8081/img/" + fileName;
			return relative;
		} else {
			return null;
		}
	}
	
	//删除图片
	@RequestMapping(value = "/deleteImg",method = RequestMethod.POST)
	public boolean  deleteImg(@RequestParam String imgSrc, HttpServletRequest req) {
		// TODO Auto-generated method stub
		System.out.println("............." + imgSrc);
		String relative = imgSrc.replace("http://localhost:8081/", "");
		System.out.println("------------" + relative);
		String projectPath = req.getServletContext().getRealPath("");
		String path = projectPath + "\\" + relative;
		File dest = new File(path);
		if (dest.exists()) {
			return dest.delete();
		}
		return true;
	}
	
	
	/*统计学生信息*/
	@RequestMapping(value = "/getInfors",method = RequestMethod.GET)
	public List<Infor> getInfors() {
		System.out.println("开始统计----------");
		return studentService.allInfors();
	}



	/*统计部门种类*/
	@RequestMapping(value="/depart",method = RequestMethod.GET)
	public List<Infor> getDepart(){
		System.out.println("开始统计-----");
		return studentService.departInfors();
	}
	

}
