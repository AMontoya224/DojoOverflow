package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Question;
import com.codingdojo.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question insertIntoQuestions( Question newQuestion ) {
		return questionRepository.save( newQuestion );
	}
	
	public List<Question> selectAllFromQuestions(){
		List<Question> questionsList = questionRepository.findAll();
		if ( questionsList.isEmpty() ) {
			Question questionEmpty = new Question();
			questionsList.add(questionEmpty);
		}
		return questionsList;
	}
	
	public Question selectFromQuestionsWhereId( Long id ) {
		List<Question> questionProgram = questionRepository.findByid( id );
		if ( questionProgram.isEmpty() ) {
			return null;
		}
		else {
			return questionProgram.get( 0 );
		}
	}
	
}
