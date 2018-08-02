package application.model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Stack;

public class Book implements Serializable {
    private Stack<BookCopy> copies;
    private String title;
    private String ISBN;
    private int checkoutLength;
    private List<Author> authors;


    public Book(String ISBN,  String title, int checkoutLength,List<Author> authors) {
        this.checkoutLength = checkoutLength;
        this.title = title;
        this.ISBN = ISBN;
        this.authors = authors;
        copies = new Stack<>();
    }

    public BookCopy getCopy() {
        if (!copies.isEmpty()){
            return copies.pop();
        }

        return null;
    }
    public int getnumCopies() {
        return copies.size();
    }
    public Stack<BookCopy> getCopies() {
        return copies;
    }

    public void addCopy(int copyNumber) {
    	for(int i=0;i<copyNumber;i++) {
        copies.push(new BookCopy(this));
    	}
    }
public List<Author> getAuthor(){
	return authors;
}
    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getCheckoutLength() {
        return checkoutLength;
    }

	@Override
	public String toString() {
		return  "title=" + title + ", ISBN=" + ISBN ;
	}

	

   
}
