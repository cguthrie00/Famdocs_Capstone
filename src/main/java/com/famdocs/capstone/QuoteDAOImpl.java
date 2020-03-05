package com.famdocs.capstone;

import com.famdocs.capstone.core.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Component
public class QuoteDAOImpl implements QuoteDAO{

    @PersistenceContext
    private EntityManager template;

    private final String SELECT = "FROM Quote";

    @Override
    public List<Quote> getQuotes() {
        String sql = SELECT;
        return template.createQuery(sql).getResultList();
    }

    @Override
    public Object getQuote(long id) {
        String sql = SELECT + " where q.quoteid = ?";
        return template.createQuery(sql).getSingleResult();
    }

    @Override
    public void add(Quote quote) {

//        String sql = "INSERT INTO QUOTE (QUOTE, GENRE, SOURCE, DATE, ERA)";
//        template.update(sql, new Object[]{quote.getQuote(), quote.getGenre(), quote.getSource(), quote.getDate()});
        return;

    }
}
