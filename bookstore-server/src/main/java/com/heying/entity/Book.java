package com.heying.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String isbn;

    private String title;

    private Date pubdate;

    private Integer pubid;

    private Double cost;

    private Double retail;

    private String category;

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pubdate=" + pubdate +
                ", pubid=" + pubid +
                ", cost=" + cost +
                ", retail=" + retail +
                ", category='" + category + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getPubid() {
        return pubid;
    }

    public void setPubid(Integer pubid) {
        this.pubid = pubid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getRetail() {
        return retail;
    }

    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book() {
    }

    public Book(String isbn, String title, Date pubdate, Integer pubid, Double cost, Double retail, String category) {
        this.isbn = isbn;
        this.title = title;
        this.pubdate = pubdate;
        this.pubid = pubid;
        this.cost = cost;
        this.retail = retail;
        this.category = category;
    }
}
