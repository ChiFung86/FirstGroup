package com.wyu.StudentInfoSys.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public  class   UploadImg {
	//将img文件存入本地
	public static  boolean upload(String projectPath, MultipartFile file, String fileName) {
		// TODO Auto-generated method stub
		//img在本地文件的路径
		String path = projectPath + "\\" + fileName;
		System.out.println("进入到upload方法------img存放在本地的路径" + path);
		File dest  = new File(path);
		
		//判断img父目录是否存在
		if(!dest.getParentFile().exists()) {
			//创建父文件
			boolean flag = dest.getParentFile().mkdir();
			if(!flag) {
				System.out.println("创建父文件失败！");
				return flag;
			}
		}
		try {
			file.transferTo(dest);
			return true;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
