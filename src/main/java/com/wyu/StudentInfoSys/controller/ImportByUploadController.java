package com.wyu.StudentInfoSys.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wyu.StudentInfoSys.entity.Student;
import com.wyu.StudentInfoSys.service.StudentService;


@RestController
public class ImportByUploadController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/test/ImportByUpload")
	public String testImport(@RequestParam("file") MultipartFile multipartFile) throws IOException {

		String fileName = multipartFile.getOriginalFilename();

		System.out.println(fileName);

		InputStream inputStream = multipartFile.getInputStream();
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		List<Student> list = new ArrayList<Student>();
		Student student;
		for (int i = 1; i < rowNum; i++) {

			HSSFRow row = sheet.getRow(i);

			student = new Student();

			HSSFCell cell = row.getCell(0);
			cell.setCellType(CellType.STRING);
			student.setStudentNumber(cell.getStringCellValue());
			
			cell = row.getCell(1);
			student.setName(cell.getStringCellValue());

			cell = row.getCell(2);
			student.setBirth(cell.getStringCellValue());

			cell = row.getCell(3);
			student.setSex(cell.getStringCellValue());
			
			cell = row.getCell(4);
			student.setPhoneNumber(cell.getStringCellValue());

			cell = row.getCell(5);
			student.setClassName(cell.getStringCellValue());

		
			cell = row.getCell(6);
			student.setDepartment(cell.getStringCellValue());
			
			
			cell = row.createCell(7);
//			if (cell==null) {
//				row.createCell(8).setCellValue(new HSSFRichTextString(String.valueOf(row.getCell(8))));
//			}else {
//				student.setEntryTime(cell.getStringCellValue());
//			}
			student.setEntryTime(cell.getStringCellValue());
			list.add(student);

		}

		System.out.println("录入成功~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (Student student1 : list) {
			studentService.addStudent(student1);
		}
		return "录入成功";
	}

}
