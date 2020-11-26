package com.wyu.StudentInfoSys.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.service.StudentService;



@RestController
public class ExportController {

	@Autowired
	StudentService studentService;

	private static String PATH = "C:\\Users\\Administrator\\Desktop\\";

	@GetMapping("/test/export")
	public String testExport() throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("学生表");

		List<Student> studentList = studentService.selectStudents();

		String fileName = "students" + ".xls";

		int rowNum = 1;

		String[] headers = { "序号", "学号", "姓名", "出生日期", "性别","电话号码","班级" ,"系部"};

		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);

			cell.setCellValue(headers[i]);
		}

		for (Student student : studentList) {
			HSSFRow row_temp = sheet.createRow(rowNum);
			row_temp.createCell(0).setCellValue(student.getId());
			row_temp.createCell(1).setCellValue(student.getStudentNumber());
			row_temp.createCell(2).setCellValue(student.getName());
			row_temp.createCell(3).setCellValue(student.getBirth());
			row_temp.createCell(4).setCellValue(student.getSex());
			row_temp.createCell(5).setCellValue(student.getPhoneNumber());
			row_temp.createCell(6).setCellValue(student.getClassName());
			row_temp.createCell(7).setCellValue(student.getDepartment());
			rowNum++;
		}

		FileOutputStream fileOutputStream = new FileOutputStream(PATH + fileName);
		workbook.write(fileOutputStream);
		fileOutputStream.close();

		return "导出成功";
	}

}
