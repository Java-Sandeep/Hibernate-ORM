package com.connect2java;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="Publisher")
public class Publisher {
 
    private int publisherId;
    private String publisherName;
    private Set<Book> books = new HashSet<Book>();
        
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column    (name="PUBLISHER_ID",unique=true)
    public int getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    @Column
    public String getPublisherName() {
        return publisherName;
    }    
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    @OneToMany(mappedBy = "publisher")
    public Set<Book> getBooks() {
        return books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}