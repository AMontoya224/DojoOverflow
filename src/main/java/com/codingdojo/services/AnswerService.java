package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Answer;
import com.codingdojo.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	public Answer insertIntoAnswers( Answer newAnswer ) {
		return answerRepository.save( newAnswer );
	}
	
	public List<Answer> selectAllFromAnswers(){
		List<Answer> answersList = answerRepository.findAll();
		return answersList;
	}
}
