/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.repository.impl;

import bt.pre.prob.ncs.challenge.entity.Book;
import bt.pre.prob.ncs.challenge.logger.MyLogger;
import bt.pre.prob.ncs.challenge.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author tuvshuu
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    @MyLogger
    private static Logger logger;

    private static List<Book> books;

    @PostConstruct
    void init() {
        logger.info("BOOK REPOSITORY INITIALIZE");
        books = new ArrayList();
        books.add(new Book(books.size() + 1, "Head First Java", 323, "Kathy Sierra"));
        books.add(new Book(books.size() + 1, "Thinking in Java", 425, "Bruce Eckel"));
        books.add(new Book(books.size() + 1, "Core Java", 301, "Gary Cornell"));
        books.add(new Book(books.size() + 1, "JavaEE", 400, "Anthony"));
        logger.info("--------------------------------");
        books.forEach(System.out::println);
        logger.info("--------------------------------");
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream().filter((book) -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return books.stream().filter((book) -> (book.getTitle().toLowerCase().contains(title.toLowerCase()))).collect(Collectors.toList());
    }

    @Override
    public Integer add(Book book) {
        Integer id = books.size() + 1;
        book.setId(id);
        books.add(book);
        return id;
    }

    @Override
    public Book findBookById(Integer id) {
        Optional<Book> optional = books.stream().filter((book) -> book.getId() == id).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

}
