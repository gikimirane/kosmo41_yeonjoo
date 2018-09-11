package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		int nPage = 1;
		
		String keyField = null;
		String keyWord = null;
	

		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);	
			
		} catch (Exception e) {
			System.out.println("페이지오류");
		}
		
		if(request.getParameter("keyField") !=null){

			keyField = request.getParameter("keyField");
			keyWord = request.getParameter("keyWord");
			
			System.out.println(keyField);				
			System.out.println(keyWord);
			
			System.out.println("검색값저장");

			request.getSession().setAttribute("keyField", keyField);
			request.getSession().setAttribute("keyWord", keyWord);

		} else if(request.getSession().getAttribute("keyField") != null){ 

			keyField = (String)request.getSession().getAttribute("keyField");
			keyWord = (String)request.getSession().getAttribute("keyWord");
		}
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage, keyField, keyWord);
		request.setAttribute("page", pinfo);
		
		nPage = pinfo.getCurPage();
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
	
		ArrayList<BDto> dtos = dao.list(nPage,keyField,keyWord);
		request.setAttribute("list", dtos);	
		
	}

}
