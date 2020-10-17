package com.dxc.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Newspaper;
import com.dxc.service.NewspaperService;

@RestController 
@RequestMapping("/")

public class NewspaperController {


         @Autowired
		 private NewspaperService newspaperService;
		
         
		@GetMapping(value = "/newspapers", produces = "application/json")
		public List<Newspaper> findAll() {
			return  newspaperService.findAll();
		}
		
		@GetMapping("/newspaper/{name}")
		public List<Newspaper> getNewspaperByName(@PathVariable String name) {
			
			List<Newspaper> theNewspaper = (List<Newspaper>) newspaperService.findByName(name);
				
			if (theNewspaper == null) {
				throw new RuntimeException("Newspaper not found - " + name);
			}
			
			return theNewspaper;
		}
		
		@GetMapping("/newspapers/{date}")
		@ResponseBody
		public List<Newspaper> getNewspaperByDate(@PathVariable Date date) throws ParseException {
			
			List<Newspaper> theNewspaper = null;
			theNewspaper = (List<Newspaper>) newspaperService.findByDate(date);
			
			if (theNewspaper == null) {
				throw new RuntimeException("Newspaper not found - " + date);
			}
			
			return theNewspaper;
		}
		@InitBinder     
        public void initBinder(WebDataBinder binder){
             binder.registerCustomEditor(Date.class,     
                                 new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true, 10));   
        }
		

		@PostMapping("/newspaper")
		public  Newspaper addNewspaper(@RequestBody Newspaper theNewspaper) {
			
					
			newspaperService.save(theNewspaper);
			return theNewspaper;
		}
		@PutMapping("/newspaper")
		public Newspaper updateNewspaper(@RequestBody Newspaper theNewspaper) {
			
			newspaperService.save(theNewspaper);
			
			return theNewspaper;
		}
		
		    
	}


