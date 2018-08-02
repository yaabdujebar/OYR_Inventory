package application.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<CheckOutRecordEntry> record = new ArrayList<>();
  private CheckOutRecord record1 =new CheckOutRecord();
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
	}


	public String getMemberId() {
		return memberId;
	}

	public void addEntryToRecord(CheckOutRecordEntry entry) {
		
        record.add(entry);
    }

    public List<CheckOutRecordEntry> getRecords() {
        return record;
    }

//	public CheckOutRecord getRecord() {
//	return record;
//}


//public void setRecord(CheckOutRecord record) {
//	this.record = record;
//}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public void setMemberId(String memberId) {
	this.memberId = memberId;
}


	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
