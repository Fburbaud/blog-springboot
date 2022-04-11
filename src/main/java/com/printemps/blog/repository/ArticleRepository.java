package com.printemps.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printemps.blog.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
