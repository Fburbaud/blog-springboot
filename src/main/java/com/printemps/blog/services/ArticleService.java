package com.printemps.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.printemps.blog.model.Article;
import com.printemps.blog.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepo;
	
	public void createArticle(Article article) {
		
		articleRepo.save(article);
	}
	
	public List<Article> findAll() {
	    return articleRepo.findAll();
	}
	
	public Optional<Article> findById(Long id) {
		
		return articleRepo.findById(id);
		//return null;
	}
}
