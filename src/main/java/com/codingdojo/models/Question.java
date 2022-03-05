package com.codingdojo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name= "questions" )
public class Question {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@Size( min=3, max=40, message="La pregunta debe tener al menos 3 caracteres" )
	private String question;
	
	private Date createdAt;
    private Date updatedAt;
    
    @Transient
    @NotNull
	@Size( min=3, max=40, message="Los tags deben tener al menos 3 caracteres" )
	private String subject;
    
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answersList;
	
	public Question() {
		
	}
	
	public Question( String question, Date createdAt, Date updatedAt, String subject, List<Tag> tags ) {
		this.question = question;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.subject = subject;
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<Answer> answersList) {
		this.answersList = answersList;
	}
	
}
