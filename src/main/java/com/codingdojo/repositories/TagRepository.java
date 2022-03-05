package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	@SuppressWarnings("unchecked")
	Tag save( Tag newTag );
	
	List<Tag> findAll();
	
	List<Tag> findByid( Long id );
	
	List<Tag> findBySubject( String subject );
	
}
