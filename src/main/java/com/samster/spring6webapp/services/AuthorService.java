package com.samster.spring6webapp.services;

import com.samster.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Iterable<Author> findAll();
}
