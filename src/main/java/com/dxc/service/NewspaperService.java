package com.dxc.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.dxc.model.Newspaper;

public interface NewspaperService {
	
  
	public void save(Newspaper theNewspaper);

	public List<Newspaper> findByName(String name);
	
	//public List<Newspaper> findByDate(Date date);

	public List<Newspaper> findAll();

	public List<Newspaper> findByDate(Date date) throws ParseException;
	
	public Newspaper findById(String name, Date date);
	


}
