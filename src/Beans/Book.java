package Beans;

import javax.swing.*;

public class Book{
    String ISBN;
    String title;
    String authors;
    String publisher;
    String publishDate;
    ImageIcon cover;

    public Book(String ISBN,String title,String authors,String publisher,String publishDate,ImageIcon cover){
        this.ISBN=ISBN;
        this.title=title;
        this.authors=authors;
        this.publisher=publisher;
        this.publishDate=publishDate;
        this.cover=cover;
    }

    public Book(String ISBN,String title,String authors,ImageIcon cover){
        this.ISBN=ISBN;
        this.title=title;
        this.authors=authors;
        this.cover=cover;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthors(){
        return authors;
    }

    public void setAuthors(String authors){
        this.authors=authors;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher=publisher;
    }

    public String getPublishDate(){
        return publishDate;
    }

    public void setPublishDate(String publishDate){
        this.publishDate=publishDate;
    }

    public ImageIcon getCover(){
        return cover;
    }

    public void setCover(ImageIcon cover){
        this.cover=cover;
    }
}
