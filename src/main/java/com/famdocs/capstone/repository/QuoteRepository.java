package com.famdocs.capstone.repository;

import com.famdocs.capstone.core.Quote;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {

    //List<Quote> allQuotes;
}
