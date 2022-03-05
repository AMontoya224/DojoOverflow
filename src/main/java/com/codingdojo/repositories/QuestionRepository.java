package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	@SuppressWarnings("unchecked")
	Question save( Question newQuestion );
	
	List<Question> findAll();
	
	List<Question> findByid( Long id );
	
}
