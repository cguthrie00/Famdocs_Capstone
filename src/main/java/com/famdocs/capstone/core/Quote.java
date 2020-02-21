package com.famdocs.capstone.core;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
    @Entity
    @Table(name="QUOTE")
    @XmlRootElement(name="quote")
    public class Quote implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="ID")

        private int id;
        @Column(name="QUOTE")

        private String quote;
        @Column(name="Genre")
        private String  genre;
        @Column(name="Source")
        private String source;
        @Column(name="Date")
        private String date;


        public Quote() {
            super();
        }
        public Quote(int id, String quote, String genre, String source, String date) {
            super();
            this.id = id;
            this.quote = quote;
            this.genre = genre;
            this.source = source;
            this.date = date;
        }
        public String getQuote(){return quote;}
        public int getId() {
            return id;
        }
        public void setId(int id) { }
        public String getGenre() {
            return genre;
        }
        public void setGenre(String genre) {
            this.genre = genre;
        }
        public String getSource() {
            return source;
        }
        public void setSource(String source) {
            this.source = source;
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Quote [ID= " + id + " Quote=" + quote + ", genre=" + genre + ", source=" + source
                    + ", date=" + date + "]";
        }

    }



