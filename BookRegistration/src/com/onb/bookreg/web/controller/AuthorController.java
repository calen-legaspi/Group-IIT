package com.onb.bookreg.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onb.bookreg.domain.Author;
import com.onb.bookreg.service.AuthorService;

@Controller
public class AuthorController {
	private AuthorService authorService;

	@Autowired(required=true)
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value = "/author/add", method = RequestMethod.GET)
	public String showAddAuthorForm(@ModelAttribute Author author) {
		return "author/add";
	}
	
	@RequestMapping(value = "/author/add", method = RequestMethod.POST)
	public String addAuthor(@ModelAttribute Author author, BindingResult bindingResult) {
		authorService.create(author);
		return "redirect:/author/list";
	}
	
	@RequestMapping(value = "/author/list", method = RequestMethod.GET)
	public String showAuthorList(HttpServletRequest request) {
		request.setAttribute("authors", authorService.getAll());
		return "/author/list";
	}
	
	@RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
	public String showEditForm(@PathVariable("id") long id, HttpServletRequest request) {
		request.setAttribute("author", authorService.get(id));
		return "author/edit";
	}
	
	@RequestMapping(value = "/author/edit", method = RequestMethod.POST)
	public String submitEditForm(@ModelAttribute Author author) {
		authorService.update(author);
		return "redirect:/author/list";
	}
	
	@RequestMapping(value = "/author/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") long id) {
		authorService.delete(id);
		return "redirect:/author/list";
	}
}
