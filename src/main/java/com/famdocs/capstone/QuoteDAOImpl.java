package com.famdocs.capstone;

import com.famdocs.capstone.core.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public class QuoteDAOImpl implements QuoteDAO{

    @Autowired
    private JdbcTemplate template;

    private final String SELECT = "SELECT *";

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public List<Quote> getQuotes() {
        String sql = SELECT;
        return template.query(sql, BeanPropertyRowMapper.newInstance(Quote.class));
    }

    @Override
    public Quote getQuote(long id) {
        String sql = SELECT + " where q.quoteid = ?";
        return template.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Quote.class));
    }

    @Override
    public void add(Quote quote) {

        String sql = "INSERT INTO QUOTE (QUOTE, GENRE, SOURCE, DATE, ERA)";
        template.update(sql, new Object[]{quote.getQuote(), quote.getGenre(), quote.getSource(), quote.getDate()});

    }
}
