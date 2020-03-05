package com.famdocs.capstone;


import com.famdocs.capstone.core.Quote;
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

   @GetMapping
   public List<Object>  getQuoteById() {
      return ((Collection<Quote>)dao.getQuotes()).stream().collect(Collectors.toList());
   }




}


