package com.printemps.blog.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="article_id")
	private Article article;
	
	private String content;

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commentaire(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}

	public Commentaire(User user, Article article, String content) {
		super();
		this.user = user;
		this.article = article;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
