package com.reactive.crud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.reactive.crud.entity.Book;
import com.reactive.crud.repository.BookRepository;
import com.reactive.crud.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Mono<Book> create(Book book) {
		Mono<Book> createdBook = bookRepository.save(book).log();
		return createdBook;

	}

	@Override
	public Flux<Book> getAll() {
		Flux<Book> findAllBook = bookRepository.findAll();
		return findAllBook;

	}

	@Override
	public Mono<Book> getBook(int bookId) {
		Mono<Book> findByIdBook = bookRepository.findById(bookId);
		return findByIdBook;
	}

	@Override
	public Mono<Book> updateBook(Book book, int bookId) {
		Mono<Book> updateBook = bookRepository.findById(bookId);
		return updateBook.flatMap(book1 -> {
			book1.setName(book.getName());
			book1.setPublisher(book.getPublisher());
			book1.setAuthor(book.getAuthor());
			book1.setDescription(book.getDescription());
			return bookRepository.save(book1);
		});

	}

	@Override
	public Mono<Void> deleteBook(int bookId) {
		return bookRepository.findById(bookId).flatMap(book -> bookRepository.delete(book));
	}

	@Override
	public Flux<Book> searchBook(String query) {
// TODO Auto-generated method stub 
		return null;

	}

	@Override
	public Flux<Book> searchBooks(String titleKeyword) {
		return this.bookRepository.searchBookByTitle("%" + titleKeyword + "%");
	}


	

}
