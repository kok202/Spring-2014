package com.javalec.ex.command;

import com.javalec.ex.dto.TicketDto;

public interface iTicketCommand {

	void execute(TicketDto ticketDto);

}