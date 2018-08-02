package application.model.dataaccess;

import java.util.HashMap;


import application.model.domain.Book;
import application.model.domain.LibraryMember;
import application.model.domain.User;

public interface DataAccess {
	
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member);
	public void saveNewBook(Book book);
	public LibraryMember removeMember(String memberId);
	 public Book readABook(String isbn) ;
	 public LibraryMember readAMember(String memberId);
	       
}
