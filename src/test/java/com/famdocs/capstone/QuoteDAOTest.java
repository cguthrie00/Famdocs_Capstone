package com.famdocs.capstone;

import com.famdocs.capstone.core.Quote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class QuoteDAOTest {


    @Autowired private WebApplicationContext wac;
    @MockBean private QuoteDAO mock;

    @Test
    public void testgetQuote() throws Exception{

        Quote quote = new Quote();
        quote.setGenre("Politics");
        quote.setSource("Twitter");
        Mockito.when(mock.getQuote(Mockito.anyLong())).thenReturn(quote);
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/healthPlan/{id}", 1);
        ResultActions actions = mvc.perform(request);
        actions.andExpect(MockMvcResultMatchers.status().isOk());
        actions.andDo(print());
        actions.andExpect(jsonPath("$.genre", equalTo(quote.getGenre())));

    }

}
