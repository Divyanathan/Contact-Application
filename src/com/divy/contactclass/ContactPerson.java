package com.divy.contactclass;

import com.divy.contactadderss.*;
import java.util.LinkedHashMap;

public class ContactPerson {

	private LinkedHashMap<String, String> name = new LinkedHashMap<String, String>();
	private LinkedHashMap<String, ContactAddress> address = new LinkedHashMap<String, ContactAddress>();
	private LinkedHashMap<String, String> mail = new LinkedHashMap<String, String>();
	private LinkedHashMap<String, String> mobilnumber = new LinkedHashMap<String, String>();
	
	
	
	
	private LinkedHashMap<Integer, String> mobilenumberGategory = new LinkedHashMap<Integer, String>();

	//***************************************Adding the value*****************************
	
	public void addName(String lable, String value) {
		name.put(lable, value);
	}

	public void addMobileNumber(String lable, String value) {
		mobilnumber.put(lable, value);
	}

	public void addAddress(String lable, ContactAddress value) {
		address.put(lable, value);
	}

	public void addMail(String lable, String value) {
		mail.put(lable, value);
	}
	
	//***************************************Retriving the value******************************
	
	public LinkedHashMap<String, String> getName() {
		LinkedHashMap<String, String> returnvalue = new LinkedHashMap<String, String>(name);

		return returnvalue;
	}

	public LinkedHashMap<String, String> getMobileNumber() {
		LinkedHashMap<String, String> returnvalue = new LinkedHashMap<String, String>(mobilnumber);

		return returnvalue;
	}

	public LinkedHashMap<String, ContactAddress> getAddress() {
		LinkedHashMap<String, ContactAddress> returnvalue = new LinkedHashMap<String, ContactAddress>(address);
		return returnvalue;
	}

	public LinkedHashMap<String, String> getMail() {
		LinkedHashMap<String, String> returnvalue = new LinkedHashMap<String, String>(mail);
		return returnvalue;
	}

	public int sizeOfTheList() {
		return name.size();
	}
//****************************************set the gategory to choose***************************
	public void setMobilenumberGategory()
	{
		mobilenumberGategory.put(1, "mobile");
		mobilenumberGategory.put(2, "work");
		mobilenumberGategory.put(3, "home");
		mobilenumberGategory.put(4, "office");
		mobilenumberGategory.put(5, "work fax");
		mobilenumberGategory.put(6, "home fax");
		mobilenumberGategory.put(7, "office fax");
		mobilenumberGategory.put(8, "pager");
		mobilenumberGategory.put(9, "other");
		mobilenumberGategory.put(10, "custom");
	}
	public void addMobilenumberGategory(int id,String value){
		mobilenumberGategory.put(id, value);
	}
//**************************************retriving the gategory*******************************
	public LinkedHashMap<Integer, String> getMobilenumberGategory(){
		LinkedHashMap<Integer, String> returnvalue = new LinkedHashMap<Integer, String>(mobilenumberGategory);
		return returnvalue;
	}
//*********************
	public ContactAddress getAddressRefrence()
	{
		return new ContactAddress();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContactPerson contactPerson = new ContactPerson();
		contactPerson.addName("name", "divy");
		contactPerson.addName("nick_name", "natahan");
		contactPerson.addName("phonetic_name", "jjjj");
		System.out.println("befor" + contactPerson.sizeOfTheList());
		LinkedHashMap<String, String> testThename = contactPerson.getName();
		testThename.clear();
		System.out.println("after" + contactPerson.sizeOfTheList());

	}

}
