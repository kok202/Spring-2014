package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.ex.dto.TicketDto;

public class TicketDao {
	JdbcTemplate templateBean;
	TransactionTemplate transactionTemplateBean1;
	
	
	
	public TicketDao() {
		System.out.println(templateBean);
	}



	public void setTemplateBean(JdbcTemplate template) {
		this.templateBean = template;
	}

	
	
	public void setTransactionTemplateBean1(TransactionTemplate transactionTemplate) {
		this.transactionTemplateBean1 = transactionTemplate;
	}
	
	
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		transactionTemplateBean1.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				templateBean.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
						String query = "insert into payedMoney (consumerId, amount) values (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						return pstmt;
					}
				});
				
				templateBean.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
						String query = "insert into ticketBuyed (consumerId, amount) values (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						return pstmt;
					}
				});
			}
			
		});
	}

	
}
