package com.connect2java;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="Book")
public class Book {
    
    private int bookId;
    private String title;
    
    private Publisher publisher;
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column    (unique=true)
    public int getBookId() {
        return bookId;
    }
 
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    @Column
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID")
    public Publisher getPublisher() {
        return publisher;
    }
 
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}