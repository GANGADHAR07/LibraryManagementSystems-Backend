package com.dxc.repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxc.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

//	Optional<Books> findByTitle(String title);
//
//	Optional<Books> findByAuthor(String author);
	@Query(value = "SELECT * FROM books WHERE title = :title", nativeQuery = true)
    List<Books> findByTitle(@Param("title") String title );
 
 @Query(value = "SELECT * FROM books WHERE title = :title AND author = :author", nativeQuery = true)
    Books findById(@Param("title") String title, @Param("author") String author);
 
 @Query(value = "SELECT * FROM books WHERE author = :author", nativeQuery = true)
 List<Books> findByAuthor(@Param("author") String author );
 

	void save(Book theBook);

}
