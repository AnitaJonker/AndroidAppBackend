package com.client;

import com.domain.booksystem.Books;
import com.services.ServiceBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by Anita on 2016/08/27.
 *
 *
 *
 *
 * Android app talks to this class.
 */

@RestController
public class ControllerBooks {

    // Inject Service
    @Autowired
    private ServiceBooks serviceBooks;

    //-------------------Add a Book--------------------------------------------------------

    @RequestMapping(value = "/createbook/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdmin(@RequestBody Books books, UriComponentsBuilder ucBuilder) {
        serviceBooks.create(books);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/createadmin/{id}").buildAndExpand(books.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve a Single Books details--------------------------------------------------------
    @RequestMapping(value = "/getbook/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Books> getLogin(@PathVariable("getbook") long id) {
        Books book= serviceBooks.readById(id);
        if (book == null) {
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(book, HttpStatus.OK);
    }

    //-------------------Retrieve All Books Details--------------------------------------------------------

    @RequestMapping(value = "/getbooks/", method = RequestMethod.GET)
    public ResponseEntity<Set<Books>> getAdmins() {
        Set<Books> book = serviceBooks.readAll();
        if(book.isEmpty()){
            return new ResponseEntity<Set<Books>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Books>>(book, HttpStatus.OK);
    }

    //------------------- Update one Books's Details --------------------------------------------------------

    @RequestMapping(value = "/updatebook/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Books> updateWorker(@PathVariable("id") long id, @RequestBody Books book) {

        Books currentBook = serviceBooks.readById(id);

        if (currentBook==null) {
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
        Books updatedWorker = new Books.Builder().copy(currentBook)
                .bookTitle(currentBook.getBookTitle())
                .author(currentBook.getAuthor())
                .iSBN(currentBook.getiSBN())
                .pages(currentBook.getPages())
                .publisher(currentBook.getPublisher())
                .build();
        serviceBooks.update(updatedWorker);
        return new ResponseEntity<Books>(updatedWorker, HttpStatus.OK);
    }

    //------------------- Delete a Books --------------------------------------------------------

    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Books> deleteAdmin(@PathVariable("id") long id) {
        Books book = serviceBooks.readById(id);
        if (book == null) {
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
        serviceBooks.delete(book);
        return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
    }

}