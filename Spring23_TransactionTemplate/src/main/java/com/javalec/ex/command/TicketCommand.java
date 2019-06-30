package com.javalec.ex.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.ex.dao.TicketDao;
import com.javalec.ex.dto.TicketDto;

public class TicketCommand implements iTicketCommand {
	private TicketDao ticketDaoBean;
	private TransactionTemplate transactionTemplateBean2;
	
	
	
	public void setTicketDaoBean(TicketDao ticketDao) {
		this.ticketDaoBean = ticketDao;
	}



	public void setTransactionTemplateBean2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplateBean2 = transactionTemplate2;
	}



	@Override
	public void execute(final TicketDto ticketDto) {
		final String id = ticketDto.getConsumerId();
		System.out.println("without cover transaction");
		//ÃÑ 4¹øÀÇ transaction ¼öÇà
		
		ticketDto.setConsumerId(id + "without");
		ticketDto.setAmount("1");
		ticketDaoBean.buyTicket(ticketDto);
		
		ticketDto.setConsumerId(id + "without");
		ticketDto.setAmount("5");
		ticketDaoBean.buyTicket(ticketDto);
		
		
		
		transactionTemplateBean2.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				System.out.println("with cover transaction");
				ticketDto.setConsumerId(id + "with");
				ticketDto.setAmount("1");
				ticketDaoBean.buyTicket(ticketDto);
				
				ticketDto.setConsumerId(id + "with");
				ticketDto.setAmount("5");
				ticketDaoBean.buyTicket(ticketDto);
			}
			
		});
	}

}
