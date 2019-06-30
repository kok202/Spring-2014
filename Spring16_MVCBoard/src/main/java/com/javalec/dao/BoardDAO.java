package com.javalec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.dto.BoardDTO;

public class BoardDAO {
	
	private DataSource dataSource;
	
	
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				BoardDTO dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
				
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
		}
		return dtos;
	}
	
	
	
	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
			finally {
			}
		}
	}
	
	
	
	public BoardDTO contentPage(String boardId) {
		BoardDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String queryUpHit = "update mvc_board set bHit = bHit + 1 where bId = ?";
		String queryGetCon = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(queryUpHit);
			preparedStatement.setInt(1, Integer.parseInt(boardId));
			preparedStatement.executeUpdate();
			if(preparedStatement != null)
				preparedStatement.close();
			
			preparedStatement = connection.prepareStatement(queryGetCon);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
		}
		return dto;
	}
	
	
	
	public void modify(String boardId, String boardName, String boardTitle, String boardContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, boardName);
			preparedStatement.setString(2, boardTitle);
			preparedStatement.setString(3, boardContent);
			preparedStatement.setInt(4, Integer.parseInt(boardId));
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	
	
	public void delete(String boardId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "delete from mvc_board where bId=?";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(boardId));
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	
	
	public BoardDTO replyPage(String boardId) {
		BoardDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from mvc_board where bId=?";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(boardId));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
		}
		return dto;
	}
	
	
	
	public BoardDTO reply(String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		BoardDTO dto = new BoardDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String queryStep = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		String queryInsert = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, ?, ?, ?)";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(queryStep);
			preparedStatement.setInt(1, Integer.parseInt(bGroup));
			preparedStatement.setInt(2, Integer.parseInt(bStep));
			preparedStatement.executeUpdate();
			if(preparedStatement != null)
				preparedStatement.close();
			
			preparedStatement = connection.prepareStatement(queryInsert);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				
			}
			finally {
			}
		}
		return dto;
	}
}
