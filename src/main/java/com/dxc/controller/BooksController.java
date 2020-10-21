package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Books;
import com.dxc.service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksController  {
	@Autowired
	private BooksService booksService;
	
	
	@GetMapping(value = "/books", produces = "application/json")
	public List<Books> findAll() {
		return booksService.findAll();
	}
	@CrossOrigin
	@GetMapping("/book/{title}")
	public Optional<Books> getBooksByTitle(@PathVariable String title) {
		
		Optional<Books> theBook =  booksService.findByTitle(title);
		
		if (theBook == null) {
			throw new RuntimeException("Book not found - " + title);
		}
		
		return theBook;
	}
	@CrossOrigin
	@GetMapping("/books/{author}")
	public List<Books> getBooksByAuthor(@PathVariable String author) {
		
		List<Books> theBook = (List<Books>) booksService.findByAuthor(author);
		
		if (theBook == null) {
			throw new RuntimeException("Book not found - " + author);
		}
		
		return theBook;
	}
	@GetMapping("/books/{title}/{author}")
	public Books getBooks(@PathVariable String title, @PathVariable String author) {
		
		Books theBooks = booksService.findById(title,author);
		
		if (theBooks == null) {
			throw new RuntimeException("Books not found - " + title);
		}
		return theBooks ;
	}
	@CrossOrigin
	@PostMapping("/book")
	public  Books addBooks(@RequestBody Books theBooks) {
		
				
		booksService.save(theBooks);
		return theBooks;
	}
	@CrossOrigin
	@PutMapping("/book")
	public Books updateBook(@RequestBody Books theBooks) {
		
		booksService.Update(theBooks);
		
		return theBooks;
	}
	
}
