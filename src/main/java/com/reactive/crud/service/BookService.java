package com.reactive.crud.service;

import com.reactive.crud.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

	public Mono<Book> create(Book book);

	public Flux<Book> getAll();

	public Mono<Book> getBook(int bookId);

	public Mono<Book> updateBook(Book book, int bookId);

	public Mono<Void> deleteBook(int bookId);

	public Flux<Book> searchBook(String query);

	Flux<Book> searchBooks(String titleKeyword);

}
