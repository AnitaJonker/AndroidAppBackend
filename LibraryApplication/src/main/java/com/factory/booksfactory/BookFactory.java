package com.factory.booksfactory;
import com.domain.booksystem.Books;

/**
 * Created by Anita on 2016/04/16.
 */


public interface BookFactory {
    Books getBook(String bookTitle);
}
