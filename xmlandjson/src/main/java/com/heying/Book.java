package com.heying;

public class Book {
    private String title;
    private String lang;
    private String author;
    private String year;
    private Double price;
    private String category;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", lang='" + lang + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book() {
    }

    public Book(String title, String lang, String author, String year, Double price, String category) {
        this.title = title;
        this.lang = lang;
        this.author = author;
        this.year = year;
        this.price = price;
        this.category = category;
    }
}
