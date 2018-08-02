package application.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;

import application.model.domain.Address;
import application.model.domain.Author;
import application.model.domain.Book;
import application.model.domain.BookCopy;
import application.model.domain.CheckOutRecordEntry;
import application.model.domain.LibraryMember;
import application.model.domain.LibrarySystemException;
import application.model.domain.CheckOutRecord;

public class SystemController {
	List<Author> authors1 = new ArrayList<>();
	public boolean addMember(String memberId, String fname, String lname, String tel, String street, String city,
			String state, String zip) throws LibrarySystemException {

		if (memberId.isEmpty() || fname.isEmpty() || lname.isEmpty() || tel.isEmpty() || street.isEmpty()
				|| city.isEmpty() || state.isEmpty() || zip.isEmpty())
			throw new LibrarySystemException("Member not added");
		Address addressAdd = new Address(street, city, state, zip);
		LibraryMember	memberAdd = new LibraryMember(memberId, fname, lname, tel, addressAdd);
		DataAccess da = new DataAccessFacade();

		da.saveNewMember(memberAdd);
       return (this.searchMember(memberId)!=null);
	}
	
	
	
	public List<Author> addAuthor(String name ,String lName,String tel,String street, String city, String state, String zip,String bio) {
		
		Address addressAdd = new Address(street, city, state, zip);
		Author author = new Author(name,lName,tel,addressAdd,bio);
		authors1.add(author);
		return authors1;
	}
	 
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors) throws LibrarySystemException {
		if (isbn.isEmpty() || title.isEmpty() || maxCheckoutLength==0 || authors.isEmpty() )
			throw new LibrarySystemException("Member not added");
		Book newBook = new Book(isbn,title,maxCheckoutLength, authors);
		DataAccess da = new DataAccessFacade();

		da.saveNewBook(newBook);

		
	}
	
	public LibraryMember  searchMember(String memberID) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> mems = da.readMemberMap();
		LibraryMember memberFromStorage = mems.get(memberID);
		return memberFromStorage;
	}
	
	public List<LibraryMember>  listAllMembers() {
		List<LibraryMember> list = new ArrayList<>();
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> mems = da.readMemberMap();
		Set<String> s = mems.keySet();
		for(String  k: s) {
			list.add(mems.get(k));
		}
		
		return list;
	}
	public List<Book>  listAllBooks() {
		List<Book> list = new ArrayList<>();
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> mems = da.readBooksMap();
		Set<String> s = mems.keySet();
		for(String  k: s) {
			list.add(mems.get(k));
		}
		
		return list;
	}
	public Book addCopyBook(String isbn , String num) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> book = da.readBooksMap();
		Book b = book.get(isbn);
		if(b!=null) {
		int n =Integer.parseInt(num);
		b.addCopy(n);
		}
		return b;
	}
	
//	public List<CheckoutRecordEntry> checkOutBook(String memberId,String isbn){
//		DataAccess da = new DataAccessFacade();
//		HashMap<String, LibraryMember> member = da.readMemberMap();
//		HashMap<String, Book> book = da.readBooksMap();
//		LibraryMember libraryMember = member.get(memberId);
//		Book b = book.get(isbn);
//		
//		if(libraryMember==null) {
//			JOptionPane.showMessageDialog(null, "Member Noy Found");
//		}
//		if(b==null) {
//			JOptionPane.showMessageDialog(null, "Book Noy Found");
//		}
//		BookCopy b1 =b.getNextAvailableCopy();
//		if(b1.getCopyNum()>0) {
//			
//			int checkoutlength = b.getMaxCheckoutLength();
//			LocalDate d = LocalDate.now();
//			LocalDate dueDate = d.plusDays(checkoutlength);
//			libraryMember.checkOut(b1, d, dueDate);
//		    b1.setCopyNum();
//		    JOptionPane.showMessageDialog(null, "successfully checed out");
//		}
//		else {
//			JOptionPane.showMessageDialog(null, "The Copy is all out");
//		}
//		
//		
//		da.saveNewBook(b);
//		da.saveNewMember(libraryMember);
//		return libraryMember.getRecord().getEntries();
//	}
}
