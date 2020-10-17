package com.dxc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Newspaper;
import com.dxc.repository.NewspaperRepository;

@Service
public class NewspaperServiceImpl implements NewspaperService {
    
	
	@Autowired
	private NewspaperRepository newspaperRepository;
	
	@Override
	@Transactional
	public void save(Newspaper theNewspaper) {
		newspaperRepository.save(theNewspaper);
		
	}

	@Override
	@Transactional
	public List<Newspaper> findByName(String name) {
		List<Newspaper> theNewspaper = newspaperRepository.findByName(name);
		
		return theNewspaper;
	
	}

	@Override
	@Transactional
	public List<Newspaper> findByDate(Date date) throws ParseException {
		List<Newspaper> theNewspaper = newspaperRepository.findByDate(new SimpleDateFormat("dd-MM-yyyy").parse("date"));
		
		return theNewspaper;
		
	}

	@Override
	@Transactional
	public List<Newspaper> findAll() {
		
		return newspaperRepository.findAll();
	}

	@Override
	public Newspaper findById(String name, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	@Transactional
//	public Newspaper findById(String name, Date date) throws ParseException {
//		Newspaper theNewspaper = newspaperRepository.findById(name, new SimpleDateFormat("dd-MM-yyyy").parse("date"));
//		return theNewspaper;
//		
//	}
//    
	

}
