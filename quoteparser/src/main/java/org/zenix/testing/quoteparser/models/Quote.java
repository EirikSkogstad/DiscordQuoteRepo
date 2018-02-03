package org.zenix.testing.quoteparser.models;

public class Quote {
    private Long id;
    private String author;
    private String text;
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
