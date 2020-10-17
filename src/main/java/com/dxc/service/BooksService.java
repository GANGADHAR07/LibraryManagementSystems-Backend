package com.dxc.service;

import java.util.List;

import com.dxc.model.Books;

public interface BooksService {

	public List<Books> findAll();

	public void save(Books theBooks);

	public List<Books> findByTitle(String title);

	public List<Books> findByAuthor(String author);

	public Books findById(String title, String author);

}
