package com.printemps.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.printemps.blog.model.Commentaire;
import com.printemps.blog.model.User;
import com.printemps.blog.model.UserLogin;
import com.printemps.blog.repository.UserRepository;
import com.printemps.blog.services.CommentService;


@Controller
public class CommentController {

	@Autowired
	private CommentService commentServ;
	
	@Autowired UserRepository userRepository;
	
	@GetMapping("/ajout-comment")
	public String ajout(Model model) {
				
		return "article/form";
	}
	
	@PostMapping("/ajout-comment")
	public String ajout(@Validated Commentaire comment, BindingResult bindingResult) {
		System.out.println("-----------" +comment.getArticle());
		
		//On recupere le nom de l'utilisateur connecté
		String username = ((UserLogin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		
		if(username != null) {
			//Instnacie un nouvel objet avec le mail de user connecté
			User user = new User();
			user = userRepository.findByEmail(username);
			
			System.out.println(user);
			
			comment.setUser(user);
			comment.setArticle(comment.getArticle());
			
			commentServ.createComment(comment);
			
			return "commentaire/list";
		}
		
		return "commentaire/form";
	}
	
	@GetMapping("/list-comment")
	public String list(Model model) {
		
		List<Commentaire> comments = commentServ.findAll();

        model.addAttribute("comments", comments);
        
        return "commentaire/list";
	}
}
