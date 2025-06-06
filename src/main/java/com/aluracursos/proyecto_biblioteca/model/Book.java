package com.aluracursos.proyecto_biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private List<String> languagesList;
    private Double downloadCount;
    @ManyToOne
    private Author author;

    public Book(){}

    public Book(BooksData bookData) {
        this.title = bookData.title();
        this.languagesList = bookData.languagesList();
        this.downloadCount = bookData.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(List<String> languagesList) {
        this.languagesList = languagesList;
    }

    public Double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Double downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", languagesList=" + languagesList +
                ", downloadCount=" + downloadCount +
                ", author=" + (author != null ? author.getCompleteName() : "N/A") +
                '}';
    }
}
