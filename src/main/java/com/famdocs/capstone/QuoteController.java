package com.famdocs.capstone;


import com.famdocs.capstone.core.Quote;
import com.famdocs.capstone.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/quotes")
public class QuoteController {
    @Autowired private QuoteDAO dao;


    @Autowired private QuoteRepository repo;

        @GetMapping(path= "/Quote/{id}")
        public Quote getQuoteById(@PathVariable("id") Long id) {

            return dao.getQuote(id);
        }




}


