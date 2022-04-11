package com.printemps.blog.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String resume;


    @ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Article(Long id, String titre, String resume) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;;
	}


	public Article(String titre, String resume) {
		super();
		this.titre = titre;
		this.resume = resume;
	}

	public Article(String titre, String resume, User user) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Article [titre=" + titre + ", resume=" + resume + ", user=" + user + "]";
	}

}
