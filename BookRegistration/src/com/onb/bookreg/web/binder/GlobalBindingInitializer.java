package com.onb.bookreg.web.binder;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.onb.bookreg.domain.Author;
import com.onb.bookreg.service.AuthorService;

public class GlobalBindingInitializer implements WebBindingInitializer {
	private AuthorService authorService;

	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Author.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String authorIdAsText) throws IllegalArgumentException {
				if(authorIdAsText.equals("0")) {
					setValue(null);
					return;
				}
				Author author = authorService.get(Long.parseLong(authorIdAsText));
				setValue(author);
			}
		});
	}

}
