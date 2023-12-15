package com.reactive.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.crud.entity.Book;
import com.reactive.crud.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

//create impl 

	@PostMapping("/createBook")
	public Mono<Book> createBook(@RequestBody Book book) {
		return bookService.create(book);
	}

//GetAllbook 

	@GetMapping("/getAllBooks")
	public Flux<Book> getAllBook() {
		return bookService.getAll();
	}

//GetSingleBook 

	@GetMapping("/getBookById/{bookId}")
	public Mono<Book> getBookById(@PathVariable int bookId)
	{
		return bookService.getBook(bookId);
	}

//UpdateBook 

	@PutMapping("/updatebook/{bookId}")
	public Mono<Book> updateBook(@RequestBody Book book, @PathVariable int bookId) {
		return bookService.updateBook(book, bookId);
	}

//Delete 

	@DeleteMapping("/deletebook/{bookId}")
	public Mono<Void> deleteBook(@PathVariable int bookId) {
		return bookService.deleteBook(bookId);
	}

}
