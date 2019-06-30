package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.dto.BoardDTO;
import com.javalec.util.Constant;

public class BoardDAO {
	private JdbcTemplate template;
	
	
	public BoardDAO() {
		template = Constant.getInstance().template;
	}
	
	
	
	public ArrayList<BoardDTO> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		ArrayList<BoardDTO> dtos = (ArrayList<BoardDTO>)template.query(query, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		return dtos;
	}
	
	
	
	public void write(final String bName, final String bTitle, final String bContent) {
		String query = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
			}
		});
	}
	
	
	
	public BoardDTO contentPage(final String boardId) {
		String queryUpHit = "update mvc_board set bHit = bHit + 1 where bId = ?";
		String queryGetCon = "select * from mvc_board where bId = " + boardId;
		template.update(queryUpHit, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, Integer.parseInt(boardId));
			}
		});
		BoardDTO dto = template.queryForObject(queryGetCon, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		return dto;
	}
	
	
	
	public void modify(final String boardId, final String boardName, final String boardTitle, final String boardContent) {
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				pstmt.setInt(4, Integer.parseInt(boardId));
			}
		});
	}
	
	
	
	public void delete(final String boardId) {
		String query = "delete from mvc_board where bId=?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, Integer.parseInt(boardId));
			}
		});
	}
	
	
	
	public BoardDTO replyPage(String boardId) {
		String query = "select * from mvc_board where bId=" + boardId; 
		BoardDTO dto = template.queryForObject(query,  new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		return dto;
	}
	
	
	
	public void reply(final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
		String queryStep = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		String queryInsert = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, ?, ?, ?)";
		
		template.update(queryStep, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, Integer.parseInt(bGroup));
				pstmt.setInt(2, Integer.parseInt(bStep));
			}
		});
		
		template.update(queryInsert, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bGroup));
				pstmt.setInt(5, Integer.parseInt(bStep) + 1);
				pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}
}
