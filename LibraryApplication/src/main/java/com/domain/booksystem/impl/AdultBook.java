package com.domain.booksystem.impl;


import com.domain.booksystem.Books;
import com.domain.booksystem.RegisterBook;

/**
 * Created by Anita on 2016/04/16.
 */
public class AdultBook extends BookDetails implements RegisterBook {

    public Books registerBook() {
        Books adultBook = new Books.Builder()
                .bookTitle("Eat pray love")
                .author("Elizabeth Gilbert")
                .pages(300)
                .publisher("New York times")
                .build();
        return adultBook;
    }

    public Books handleRequest(String request) {
        if (request.equalsIgnoreCase("Adult")) {
            return registerBook();
        } else {
            if (request != null) {
                return nextType.handleRequest(request);
            }
            return null;
        }
    }
}
