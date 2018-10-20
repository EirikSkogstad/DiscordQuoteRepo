package org.zenix.testing.quoteapi.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String author;
    @NotBlank
    private String text;
    @NotBlank
    private String date;

    public Quote() {
    }

    public Quote(String author, String text, String date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
