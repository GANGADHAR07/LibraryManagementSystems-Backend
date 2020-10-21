package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Books;
import com.dxc.repository.BooksRepository;

@Service
public class BooksServiceImplementation implements BooksService {

	public  BooksServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Override
	@Transactional
	public List<Books> findAll() {
		return booksRepository.findAll();	
		}

	@Override
	@Transactional
	public void save(Books theBooks) {
		
		booksRepository.save(theBooks);
	}

	@Override
	@Transactional
	public Optional<Books> findByTitle(String title) {
		 Optional<Books> theBooks = booksRepository.findByTitle(title);
		
			return theBooks;
		
	}

	@Override
	@Transactional
	public List<Books> findByAuthor(String author) {
		 List<Books> theBooks = booksRepository.findByAuthor(author);
			
			return theBooks;
		}

	@Override
	public Books findById(String title, String author) {
		Books theBooks = booksRepository.findById(title, author);
		return theBooks;
	}
	
	public Books Update(Books theBooks) {
		Optional<Books> res = booksRepository.findByTitle(theBooks.getTitle());
		if(res.isPresent()) {
			booksRepository.save(theBooks);
		}
		return theBooks;
	}
}
