package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Tag;
import com.codingdojo.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public Tag insertIntoTags( Tag newTag ) {
		return tagRepository.save( newTag );
	}
	
	public List<Tag> selectAllFromTags(){
		List<Tag> tagsList = tagRepository.findAll();
		if ( tagsList.isEmpty() ) {
			Tag tagEmpty = new Tag();
			tagsList.add(tagEmpty);
		}
		return tagsList;
	}
	
	public Tag selectFromUsersWhereSubject( String subject ) {
		List<Tag> foundTag = tagRepository.findBySubject( subject );
		if ( foundTag.isEmpty() ) {
			return null;
		}
		else {
			return foundTag.get( 0 );
		}
	}
	
}
