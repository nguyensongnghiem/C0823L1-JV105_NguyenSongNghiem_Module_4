package org.codegym.dictionary.repository;

import org.springframework.stereotype.Repository;


public interface IDictionaryRepository {
    public String find(String word);
}
