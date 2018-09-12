package com.study.jsp.command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		MultipartRequest multi = null;
		
		int size = 1024 * 1024 * 10; //10M
		
		String savePath = request.getRealPath("img");
		System.out.println("savePath : "+ savePath);
		
		String bName = null;
		String bTitle = null;
		String bContent = null; 
		String fileName = null;
		String fileType = null; 
		
		try {
		
			multi = new MultipartRequest(request, savePath, size,
										 "UTF-8", new DefaultFileRenamePolicy());
			
			bName = multi.getParameter("bName");
			bTitle = multi.getParameter("bTitle");
			bContent = multi.getParameter("bContent");
			
			System.out.println(bName);
			System.out.println(bTitle);
			System.out.println(bContent);
			
			Enumeration files = multi.getFileNames();
		      System.out.println(files);
		      
		    String str = (String)files.nextElement();
		      System.out.println(files);
		      
		    fileName = multi.getFilesystemName(str);
		      System.out.println(fileName);
		      
		   String orifile = multi.getOriginalFileName(str);
		      System.out.println(orifile);
	
		    fileType = multi.getContentType(str);
		    String type = fileType.split("/")[0];
		    String path = savePath+"\\"+fileName;
			

		} catch (Exception e) {
			
			fileName = "none";
			fileType = "none";
		}	
			
			
					
			BDao dao = BDao.getInstance();
			dao.write(bName, bTitle, bContent,fileName,fileType);
		
	}

}
