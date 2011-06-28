package com.onb.bookreg.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onb.bookreg.domain.Author;
import com.onb.bookreg.domain.Book;
import com.onb.bookreg.service.AuthorService;
import com.onb.bookreg.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	private AuthorService authorService;

	@Autowired(required=true)
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Autowired(required=true)
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value = "/book/add", method = RequestMethod.GET)
	public String showAddBookForm(@ModelAttribute Book book, HttpServletRequest request) {
		request.setAttribute("authors", authorService.getAll());
		return "/book/add";
	}
	
	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book, @RequestParam int authorId) {
		book.setAuthor(new Author(authorId, "", null));
		bookService.create(book);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String showBookList(HttpServletRequest request) {
		request.setAttribute("books", bookService.getAll());
		return "book/list";
	}
}
