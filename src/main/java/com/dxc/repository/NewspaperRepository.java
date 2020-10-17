package com.dxc.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxc.model.Newspaper;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, Integer> {
	

		@Query(value = "SELECT * FROM newspaper WHERE name = :name", nativeQuery = true)
	    List<Newspaper> findByName(@Param("name") String name );
	 
	    @Query(value = "SELECT * FROM newspaper WHERE date = :date AND name = :name", nativeQuery = true)
	    Newspaper findById(@Param("name") String name, @Param("date") Date date);
	 
	    @Query(value = "SELECT * FROM newspaper WHERE date = :date", nativeQuery = true)
	    List<Newspaper> findByDate(@Param("date") Date date );
	 

}

