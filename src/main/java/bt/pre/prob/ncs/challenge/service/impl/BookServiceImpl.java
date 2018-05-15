/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.service.impl;

import bt.pre.prob.ncs.challenge.entity.Book;
import bt.pre.prob.ncs.challenge.repository.BookRepository;
import bt.pre.prob.ncs.challenge.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tuvshuu
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        System.out.println("*** BookRepository has been autowired by constructor method");
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Integer addBook(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findBookById(id);
    }
    

}
