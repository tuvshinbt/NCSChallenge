/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.service;

import bt.pre.prob.ncs.challenge.entity.Book;
import java.util.List;

/**
 *
 * @author tuvshuu
 */
public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByTitle(String title);

    Book getBookById(Integer id);

    Integer addBook(Book book);

}
