package com.javalec.ex.dao;

import java.util.ArrayList;

import com.javalec.ex.dto.ContentDTO;

public interface IDAO {
	
	public ArrayList<ContentDTO> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDTO viewDao(String strID);
	public void deleteDao(String bId);
	
}
