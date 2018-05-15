/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.repository;

import bt.pre.prob.ncs.challenge.entity.Book;
import java.util.List;

/**
 *
 * @author tuvshuu
 */
public interface BookRepository {

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    Integer add(Book book);

    Book findBookById(Integer id);

}
