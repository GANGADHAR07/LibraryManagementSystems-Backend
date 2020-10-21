package com.dxc.service;

import java.util.List;
import java.util.Optional;

import com.dxc.model.Books;

public interface BooksService {

	public List<Books> findAll();

	public void save(Books theBooks);
	public Books Update(Books theBooks);

	public Optional<Books> findByTitle(String title);

	public List<Books> findByAuthor(String author);

	public Books findById(String title, String author);

}
