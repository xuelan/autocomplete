package com.xsu.autocomplete.controller;

import com.xsu.autocomplete.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = {"/search/{prefix}"}, method = RequestMethod.GET)
    public List<String> index(@PathVariable(value="prefix") String prefix) {

        //4 suggestions maximum
        final List<String> topWords = searchService.getTopNWords(4, prefix);

        return topWords;
    }
}
