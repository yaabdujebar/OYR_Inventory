package application.model.domain;

import java.time.LocalDate;

public class CheckOutRecordEntry {

    private BookCopy book;
    private LocalDate dateOfCheckOut;
    private LocalDate dueDate;

    public CheckOutRecordEntry(BookCopy book, LocalDate dateOfCheckOut, LocalDate dueDate) {
        this.book = book;
        this.dateOfCheckOut = LocalDate.now();
        this.dateOfCheckOut = dateOfCheckOut;
        this.dueDate = dueDate;
    }

    public BookCopy getCopy() {
        return book;
    }

    public LocalDate getDateOfCheckOut() {
        return dateOfCheckOut;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return book.getBook() + " " + dateOfCheckOut + " " + dueDate;
    }
}


