package com.codingdojo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.models.Answer;
import com.codingdojo.models.Question;
import com.codingdojo.models.Tag;
import com.codingdojo.services.AnswerService;
import com.codingdojo.services.QuestionService;
import com.codingdojo.services.TagService;

@Controller
@RequestMapping( "/questions" )
public class GeneralController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	public long millis = System.currentTimeMillis(); 
	public Date date = new Date(millis); 
	
	@GetMapping( "/" )
	public String question_G( Model model ) {
		List<Question> questionsList = questionService.selectAllFromQuestions();
		model.addAttribute( "questionsList", questionsList );
		return "dashboard.jsp";
	}
	
	@GetMapping( "/new" )
	public String new_G( Model model ) {
		model.addAttribute("newQuestion", new Question());
        return "new.jsp";
	}
	
	@PostMapping( "/new" )
	public String new_P( @Valid @ModelAttribute("newQuestion") Question newQuestion, 
			 			 BindingResult result, Model model, RedirectAttributes flash) {
		if( result.hasErrors() ) {
            return "new.jsp";
		}
		List<Tag> tagsList = new ArrayList<>();
		String[] tags = newQuestion.getSubject().split( " " );
		for( int i=0; i<tags.length; i++ ) {
			if( tags[i].length()<2 ) {
				System.out.println("no");
				flash.addFlashAttribute( "tagError", "Cada tema debe tener entre 2 y 40 caracteres." );
				return "redirect:/questions/new";
			}
		}
		for( int i=0; i<tags.length; i++ ) {
			Tag tagFound = tagService.selectFromUsersWhereSubject(tags[i]);
			if( tagFound == null ) {
				Tag newTag = new Tag();
				newTag.setSubject( tags[i] );
				newTag.setCreatedAt( date );
				newTag.setUpdatedAt( date );
				Tag tagCreated = tagService.insertIntoTags( newTag );
				tagsList.add(tagCreated);
			}
			else {
				tagsList.add(tagFound);
			}
		}
		newQuestion.setCreatedAt(date);
		newQuestion.setUpdatedAt(date);
		newQuestion.setTags(tagsList);
		questionService.insertIntoQuestions( newQuestion );
		return "redirect:/questions/";
	}
	
	@GetMapping( "/{id}" )
	public String show_G( @PathVariable("id") Long id, Model model ) {
		Question questionFound = questionService.selectFromQuestionsWhereId( id );
		if( questionFound == null ) {
			return "redirect:/questions/";
		}
		model.addAttribute( "question", questionFound );
		model.addAttribute("newAnswer", new Answer());
        return "show.jsp";
	}
	
	@PostMapping( "/{id}/answer" )
	public String rating_P( @PathVariable("id") Long id,
						   @Valid @ModelAttribute("newAnswer") Answer newAnswer,
						   BindingResult result, Model model, RedirectAttributes flash ) {
		List<Answer> answerList = answerService.selectAllFromAnswers();
		if( answerList.isEmpty() ) {
			newAnswer.setId(1);
		}
		else {
			newAnswer.setId(answerList.size()+1);
		}
		Question questionFound = questionService.selectFromQuestionsWhereId( id );
		newAnswer.setQuestion( questionFound );
		newAnswer.setCreatedAt( date );
		newAnswer.setUpdatedAt( date );
		answerService.insertIntoAnswers(newAnswer);
		return String.format( "redirect:/questions/%s", id );
	}
	
}
