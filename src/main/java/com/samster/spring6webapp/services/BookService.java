package com.samster.spring6webapp.services;

import com.samster.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
