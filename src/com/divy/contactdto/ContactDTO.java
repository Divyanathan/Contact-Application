package com.divy.contactdto;
import java.util.HashMap;
import java.util.TreeSet;

import com.divy.contactclass.ContactPerson;
public class ContactDTO {

 
	private HashMap<Integer,ContactPerson> contactdetails=new HashMap<Integer,ContactPerson>();
	private static TreeSet<Integer> deletedContactId=new TreeSet<Integer>();
//	private LinkedHashMap<Integer,String> phoneNumberGategory=new LinkedHashMap<Integer,String>();
	public ContactPerson getContactRefrence()
	{
		return new ContactPerson();
	}

	public void setContactRefrence(int id,ContactPerson contactRefrence) {
	
		contactdetails.put(id,contactRefrence );
	}
	public ContactPerson  retriveContactOfSinglePerson(int id){
		ContactPerson contactRefrence=contactdetails.get(id);
		return contactRefrence;
	}
	public void deleteContact(int id){
		deletedContactId.add(id);
		contactdetails.remove(id);
	}
	public static String isDeleted(int id)
	{
		int check=0;
		for(int i:deletedContactId){
			if(i==id){
				check=1;
				//return "true";
			}
		}
		if(check==1){
			return "true";
		}
		else
			return "false";
	}

//	public void setPhoneGategory(){
//		phoneNumberGategory.put(1, )
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deletedContactId.add(1);
		deletedContactId.add(2);
		deletedContactId.add(3);
		System.out.println(isDeleted(4));

	}
	
}
