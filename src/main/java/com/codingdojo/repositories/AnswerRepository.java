package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	@SuppressWarnings("unchecked")
	Answer save( Answer newAnswer );
	
	List<Answer> findAll();
}
