package com.famdocs.capstone;

import com.famdocs.capstone.core.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class CmdLineRunner implements CommandLineRunner {

    @PersistenceContext private EntityManager em;

    @Override @Transactional
    public void run(String... args) throws Exception {
      Quote [] quotes = {
              new Quote(null,"6666","555","999"),
              new Quote(null,"77","555","227"),

      };
        for (Quote quote:
            quotes ) {
            em.persist(quote);
        }



        em.createQuery("FROM Quote").getResultList().stream().forEach(System.out::println);
    }
}
