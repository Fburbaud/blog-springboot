package com.printemps.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printemps.blog.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
