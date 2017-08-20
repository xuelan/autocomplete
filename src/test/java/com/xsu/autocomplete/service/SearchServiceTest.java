package com.xsu.autocomplete.service;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchServiceTest {

    @Test
    public void test(){

        SearchService searchService = new SearchService();
        final List<String> topWords = searchService.getTopNWords(4, "P");

        assertEquals(topWords.size() ,4);
        assertEquals(topWords.get(0), "Pandora");
        assertEquals(topWords.get(1), "Paypal");
        assertEquals(topWords.get(2), "Pg&e");
        assertEquals(topWords.get(3), "Phone");
    }

}
