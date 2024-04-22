package org.codegym.dictionary.service;

import org.codegym.dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String find(String word) {
        return dictionaryRepository.find(word);
    }
}
