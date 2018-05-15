/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.controller;

import bt.pre.prob.ncs.challenge.entity.Book;
import bt.pre.prob.ncs.challenge.logger.MyLogger;
import bt.pre.prob.ncs.challenge.service.BookService;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tuvshuu
 */
@RestController
@RequestMapping(value = "/restapi/book")
public class BookRestController {

    @MyLogger
    private static Logger logger;

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        System.out.println("*** BookService has been autowired by setter method");
        this.bookService = bookService;
    }

    @GetMapping("all")
    public List<Book> getAllBook() {
        logger.info("getAllBook() has been called.");
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        logger.info("getBookById() has been called. id - " + id);
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("author/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        logger.info("getBooksByAuthor() has been called. authorName - " + authorName);
        return bookService.getBooksByAuthor(authorName);
    }

    @GetMapping("title/{partialTitle}")
    public List<Book> getBooksByTitle(@PathVariable String partialTitle) {
        logger.info("getBooksByTitle() has been called. partialTitle - " + partialTitle);
        return bookService.getBooksByTitle(partialTitle);
    }

    @PostMapping("")
    public ResponseEntity<String> addBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
        logger.info("addBook() has been called. Book - " + book);
        Integer id = bookService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/restapi/book/{id}").buildAndExpand(id).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex) {
        logger.error("", ex);
        return new ResponseEntity<>("Oops! ERROR " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
