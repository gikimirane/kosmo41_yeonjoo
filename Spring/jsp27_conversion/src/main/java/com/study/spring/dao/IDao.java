package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dao.BPageInfo;
import com.study.spring.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String bName, String bTitle, String bContent);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
	public BPageInfo articlePage(int curPage);
	public ContentDto contentView(int bId);
	public void modify(int bId, String bName, String bTitle, String bContent);
	public void upHit(int bId);
	public void delete(int bId);
	public void reply(int bId, int bGroup, int bStep, int bIndent, 
						String bName, String bTitle, String bContent);
	public void replyshape(int strGroup, int strStep);
	
	
}
