package com.famdocs.capstone;

import java.util.List;

public interface QuoteDAO {

    public List<Quote> getQuotes();
    public Quote getQuote(long id);
    public void add(Quote quote);

}
