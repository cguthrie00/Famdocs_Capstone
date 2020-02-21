package com.famdocs.capstone;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/quotes")
public class QuoteController {

    @GetMapping("/{id}")
    public String getQuote(Model model){

        List<Quote> quotes = dao.getPlans().stream()
                //.filter(p-> p.getName().equalsIgnoreCase(type))
                //.filter(p-> p.getDeductableIndividual() <= planProperties.getMaxDeductableIndividual())
                //.filter(p-> p.getCopay() <= planProperties.getMaxCopay()).collect(Collectors.toList());

        model.addAttribute("quotes", quotes);

        return "quote";

    }


