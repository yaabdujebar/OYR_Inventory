package application.model.domain;

import java.util.*;

import application.model.dataaccess.DataAccess;
import application.model.dataaccess.DataAccessFacade;


public class Main {

	public static void main(String[] args) {
		
		System.out.println(allWhoseZipContains3());
		System.out.println(allusers());
		//System.out.println(allHavingOverdueBook());
		//System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		List<String> me = new ArrayList<>();
		for(LibraryMember l: mems) {
			if(l.getAddress().getZip().length()==5) {
				me.add(l.getMemberId());
			}
			
		}
		//implement
		return me;
		
	}
	//Returns a list of all ids of  LibraryMembers that have an overdue book
	public static List<String> allHavingOverdueBook() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		List<String> me = new ArrayList<>();
		for(LibraryMember l: mems) {
			//if(l.getAddress().getZip().length()==5) {
				me.add(l.getMemberId());
			//}
			
		}
		return me;
		
	}
	
	public static List<User> allusers() {
		DataAccess da = new DataAccessFacade();
		Collection<User> members = da.readUserMap().values();
		List<User> mems = new ArrayList<>();
		mems.addAll(members);
		//List<String> me = new ArrayList<>();
		//for(LibraryMember l: mems) {
			//if(l.getAddress().getZip().length()==5) {
			//	me.add(l.getMemberId());
			//}
			return mems;
		}
	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//implement
		return null;
		
		}

}
