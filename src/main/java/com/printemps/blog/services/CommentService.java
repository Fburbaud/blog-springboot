package com.printemps.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.printemps.blog.model.Commentaire;
import com.printemps.blog.repository.CommentaireRepository;


@Service
public class CommentService {

	@Autowired
	private CommentaireRepository commentRepo;
	
	public void createComment(Commentaire comment) {
		
		commentRepo.save(comment);
	}
	
	public List<Commentaire> findAll() {
		
	    return commentRepo.findAll();
	}
}