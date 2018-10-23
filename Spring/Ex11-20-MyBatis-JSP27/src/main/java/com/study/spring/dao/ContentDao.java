package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.ContentDto;

public class ContentDao implements IDao{

	   JdbcTemplate template;
	   
	   @Autowired
	   public void setTemplate(JdbcTemplate template) {
	      this.template = template;
	   }
	   
	   public ContentDao() {
	      // TODO Auto-generated constructor stub
	   }
	   
	   @Override
	   public ArrayList<ContentDto> listDao() {
	      String query = "select * from ex_board order by bId desc";
	      ArrayList<ContentDto> dtos = 
	    		  (ArrayList<ContentDto>) 
	    		  template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	      return dtos;
	   }
	   
	   
	   @Override
	   public void writeDao(final String bName, final String bTitle, final String bContent) {
	      System.out.println("writeDao()실행");
	      
	      this.template.update(new PreparedStatementCreator() {
	         
	         @Override
	         public PreparedStatement createPreparedStatement(Connection con)
	               throws SQLException {
	            String query = "insert into ex_board (bId, bName, bTitle, bContent) values "
	            		+ " (ex_board_seq.nextval, ?, ?, ?)";
	            PreparedStatement pstmt = con.prepareStatement(query);
	        	pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
	            return pstmt;
	         }
	      });
	      
	   }
	   
	   @Override
	   public void modifyDao(final String bName, final String bTitle, final String bContent, final String bId ) {
	      System.out.println("modifyDao()실행");
	      
	      this.template.update(new PreparedStatementCreator() {
	         
	         @Override
	         public PreparedStatement createPreparedStatement(Connection con)
	               throws SQLException {
	            String query = "update ex_board set bName = ?, bTitle = ?, bContent = ? where bId =?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setString(4, bId);
				return pstmt;
	         }
	      });
	      
	   }
	  
	   @Override 
	   public void upHit(final int bId) {
		   System.out.println("upHit실행");
		   
		      this.template.update(new PreparedStatementCreator() {
		         
		      @Override
		      public PreparedStatement createPreparedStatement(Connection con)
	               throws SQLException {
	            String query = "update ex_board set bHit = bHit + 1 where bId = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, bId);
	            
				return pstmt;
	         }
	      });
	      
	   }

	   
	   @Override
	   public ContentDto viewDao(String strID) {
	      System.out.println("viewDao()실행");
	      
	      String query = "select * from ex_board where bId = " + strID;
	      return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	   }

	   
	   @Override
	   public void deleteDao(final String bId) {
	      System.out.println("deleteDao()실행");
	      
	      String query = "delete from ex_board where bId = ?";
	      this.template.update(query, new PreparedStatementSetter() {
	         
	         @Override
	         public void setValues(PreparedStatement ps) throws SQLException {
	            ps.setInt(1, Integer.parseInt(bId));
	         }
	      });
	      
	   }

	@Override
	public ContentDto replyview(final String str) {
		System.out.println("replyview()실행");
		final ResultSet rs = null;
		
		this.template.update(new PreparedStatementCreator() {
	         
	         @Override
	         public PreparedStatement createPreparedStatement(Connection con)
	               throws SQLException {
	            String query = "select * from ex_board where bId = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1,Integer.parseInt(str));
	            if (rs.next()) {
					 int bId = rs.getInt("bId");
					 String bName = rs.getString("bName");
					 String bTitle = rs.getString("bTitle");
					 String bContent = rs.getString("bContent");
					 Timestamp bDate = rs.getTimestamp("bDate");
					 int bHit = rs.getInt("bHit");
					 int bGroup = rs.getInt("bGroup");
					 int bStep = rs.getInt("bStep");
					 int bIndent = rs.getInt("bIndent");
				 }
				return pstmt;
	         }
	      });
		return null;
	      
	   }
	@Override
	public void replyDao(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		// TODO 자동 생성된 메소드 스텁
		
	}

	@Override
	public ContentDto contentView(int bId) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}
	   
	   

	}