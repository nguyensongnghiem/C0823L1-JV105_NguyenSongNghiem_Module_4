package org.codegym.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static LinkedHashMap<String, String> words = new LinkedHashMap<>();
    static {
        words.put("Apple","Táo");
        words.put("Orange","Cam");
        words.put("Lemon","Chanh");
    }
    @Override
    public String find(String word) {
        String meaning = words.get(word);
        return meaning;
    }
}
