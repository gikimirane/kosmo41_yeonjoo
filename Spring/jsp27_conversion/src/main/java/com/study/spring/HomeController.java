package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	ContentDao dao;
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Autowired
//	public void setDao(ContentDao dao) {
//		this.dao = dao;
//	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ArrayList<ContentDto> dtos = dao.listDao();
		IDao dao = sqlSession.getMapper(IDao.class);
//		ArrayList<ContentDto> dtos = dao.listDao();
		model.addAttribute("list", dao.listDao());		
		return "/list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "/write_view";
	}
	
	@RequestMapping("/write") // bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent
	public String write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(Integer.parseInt((request.getParameter("bId"))));
		return "redirect:list";
	}
	
	@RequestMapping(value = "/content_view", method = RequestMethod.GET)
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bId = Integer.parseInt(((String)request.getParameter("bId")));
		
		
		System.out.println("HomeController 'content_view' : " + bId);
		
		dao.upHit(bId);
		model.addAttribute("content_view", dao.contentView(bId));
		
		return "/content_view";
	}
	
	@RequestMapping(value = "/modify_view", method = RequestMethod.GET)
	public String modify_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bId = Integer.parseInt(((String)request.getParameter("bId")));
		
		
		System.out.println("HomeController 'modify_view' : " + bId);
		
		model.addAttribute("content_view", dao.contentView(bId));
		
		return "/modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		System.out.println("HomeController modify : " + bId + bName + bTitle + bContent);
		
		dao.modify(bId, bName, bTitle, bContent);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bId = Integer.parseInt(((String)request.getParameter("bId")));
		
		System.out.println("HomeController 'reply_view' : " + bId);
		
		model.addAttribute("reply_view", dao.contentView(bId));
		
		return "/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bId = Integer.parseInt(((String)request.getParameter("bId")));
		int bGroup = Integer.parseInt(((String)request.getParameter("bGroup")));
		int bStep = Integer.parseInt(((String)request.getParameter("bStep")));
		int bIndent = Integer.parseInt(((String)request.getParameter("bIndent")));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		dao.replyshape(bGroup, bStep);
		dao.reply(bId, bGroup, bStep, bIndent, bName, bTitle, bContent);
		return "redirect:list";
	}
	
}
