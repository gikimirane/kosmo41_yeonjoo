package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileuploadController {
	
	//파일 업로드 폼
	@RequestMapping("/uploadForm")
	public String uploadForm() {
		
		return "FileUpload/uploadForm";
	}
	
	//파일의 물리적경로 가져오기
	@RequestMapping("/uploadPath")
	public void uploadPath(HttpServletResponse resp, HttpServletRequest req) 
			throws IOException
	{
		//컨트롤러에서 폴더의 물리적경로 가져오기
		String path = 
				req.getSession().getServletContext().getRealPath("/resources/upload");
		
		//컨트롤러에서 직접 출력하는 경우
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter print = resp.getWriter();
		print.println("upload폴더의 물리적경로");
		print.print(path);
	}
	
		//파일목록보기
		@RequestMapping("/uploadList")
		public String uploadList(HttpServletResponse req,Model model, HttpServletRequest resp) 
				throws IOException
		{
			//서버의
			String path = 
					req.getSession().getServletContext().getRealPath("/resources/upload");
			
			//컨트롤러에서 직접 출력하는 경우
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter print = resp.getWriter();
			print.println("upload폴더의 물리적경로");
			print.print(path);
		}
		
		//파일목록보기
		@RequestMapping("/uploadList")
		public String uploadList(HttpServletRequest req, Model medel, HttpServletResponse resp)
				throws IOException {
			
			//서버의 물리적 경로 얻어오기
			String saveDirectory =
					req.getSession().getServletContext().getRealPath(path)
			
		}

}
