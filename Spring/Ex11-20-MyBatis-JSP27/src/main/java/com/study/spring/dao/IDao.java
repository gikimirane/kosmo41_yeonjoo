package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String bName, String bTitle, String bContent);
	public void modifyDao(String bId, String bName, String bTitle, String bContent);
	public void upHit(int bId);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
	public ContentDto replyview(String str);
	public void replyDao(String bId, String bName, String bTitle, String bContent,
						 String bGroup, String bStep, String bIndent);
	public ContentDto contentView(int bId);
}
