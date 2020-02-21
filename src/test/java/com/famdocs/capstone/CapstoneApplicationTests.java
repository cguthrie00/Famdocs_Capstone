package com.famdocs.capstone;

import com.famdocs.capstone.core.Quote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class CapstoneApplicationTests {

	QuoteDAO dao;
	List<Quote> list;
	Quote quote;
	String resultQuote;
	long id;

	@Before
	public void setUp(){
		dao = Mockito.mock(QuoteDAO.class);
		quote = Mockito.mock(Quote.class);
		list = Mockito.mock(List.class);
		id = 5;
	}

	@After()
	public void tearDown(){
		dao = null;
		quote = null;
		id = 0;
		resultQuote = null;
	}
//	@Test
//	void contextLoads() {
//	}

	@Test
	void getQuotesList() {
		List<Quote> resultList = (List<Quote>) Mockito.when(dao.getQuotes()).thenReturn(list);
		assertEquals(resultList, list);

	}

	@Test
	void getQuote(long id) {
		Quote result = (Quote) Mockito.when(dao.getQuote(id)).thenReturn(quote);
		assertEquals(result, quote);
	}

	@Test
	void add(Quote quote) {

	}
}
