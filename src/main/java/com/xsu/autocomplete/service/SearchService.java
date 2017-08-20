package com.xsu.autocomplete.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
public class SearchService {

    public List<String> getTopNWords(int topNumber, String inputString){

        TernarySearchTree t = new TernarySearchTree();
        t.insert("Pandora");
        t.insert("Pinterest");
        t.insert("Paypal");
        t.insert("Pg&e");
        t.insert("Project");
        t.insert("free");
        t.insert("tv");
        t.insert("Priceline");
        t.insert("Press");
        t.insert("democrat");
        t.insert("Progressive");
        t.insert("Project");
        t.insert("runway");
        t.insert("Proactive");
        t.insert("Programming");
        t.insert("Progeria");
        t.insert("Progesterone");
        t.insert("Progenex");
        t.insert("Procurable");
        t.insert("Processor");
        t.insert("Proud");
        t.insert("Print");
        t.insert("Prank");
        t.insert("Bowl");
        t.insert("Owl");
        t.insert("River");
        t.insert("Phone");
        t.insert("Kayak");
        t.insert("Stamps");
        t.insert("Reprobe");

        TreeSet<String> wordsFound = t.prefixSearch(inputString, topNumber);

        List<String> results = new ArrayList<String>(wordsFound);


        return results;
    }
}
