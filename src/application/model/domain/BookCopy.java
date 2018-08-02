package application.model.domain;

import java.io.Serializable;

public class BookCopy implements Serializable {
    private Book book;
    //private int copyNumber;

    public BookCopy(Book book) {
        this.book = book;
       // this.copyNumber = copyNumber;

    }

//    public int getCopyNumber() {
//        return copyNumber;
//    }

    public Book getBook() {
        return book;
    }

//    @Override
//    public String toString() {
//        return book+" "+copyNumber;
//    }
}
