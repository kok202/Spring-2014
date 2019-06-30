package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.ex.dto.ContentDTO;

public class ContentDAO implements IDAO{
	JdbcTemplate templateBean;
	
	
	
	public ContentDAO() {
		
	}
	
	
	
	public void setTemplateBean(JdbcTemplate template) {
		this.templateBean = template;
	}
	
	

	@Override
	public ArrayList<ContentDTO> listDao() {
		String query = "select * from mvc_board_mybatis order by mId desc";
		ArrayList<ContentDTO> dtos = (ArrayList<ContentDTO>) templateBean.query(query, new BeanPropertyRowMapper<ContentDTO>(ContentDTO.class));
		return dtos;
	}

	
	
	@Override
	public void writeDao(final String mWriter, final String mContent) {
		System.out.println("writeDao()");
		this.templateBean.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String query = "insert into mvc_board_mybatis (mId, mWriter, mContent) values (mvc_board_mybatis_seq.nextval, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, mWriter);
				pstmt.setString(2, mContent);
				return pstmt;
			}
		});
	}

	
	
	@Override
	public ContentDTO viewDao(String strID) {
		System.out.println("viewDao()");
		String query = "select * from mvc_board_mybatis where mId = " + strID;
		return templateBean.queryForObject(query, new BeanPropertyRowMapper<ContentDTO>(ContentDTO.class));
	}

	
	
	@Override
	public void deleteDao(final String bId) {
		System.out.println("deleteDao()");
		String query = "delete from mvc_board_mybatis where mId = ?";
		this.templateBean.update(query, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});	
	}
}
