package application.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable {
    private LibraryMember member;
    // Consider using a HashMap<Member, CheckOutRecordEntry> :)
    private List<CheckOutRecordEntry> checkOutEntries = new ArrayList<>();

    public void addCheckOutEntry(CheckOutRecordEntry entry){
        //check if it's not null - or something
        checkOutEntries.add(entry);
    }

    public List<CheckOutRecordEntry> getCheckOutEntries() {
        return checkOutEntries;
    }

    public LibraryMember getMember() {
        return member;
    }

    @Override
    public String toString() {
        return checkOutEntries.toString();
    }
}
