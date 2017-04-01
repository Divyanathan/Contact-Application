/***
 * Divyanathan
 * Contact Application
 */
package com.divy.contactview;

import com.divy.contactdto.*;
import com.divy.contactclass.*;
import com.divy.contactadderss.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ViewController {
	
//**************************************DECLARATION PART*******************************
	Scanner sc=new Scanner(System.in);
	int useroption = 1;
	int id=0;
	String isContactAdded="false";
	String choose;
	
	
	String nametype = "Name";
	String mobilenumber;
	String mobilenumbertype="Mobile";
	String address;
	String addresstype="Adress";
	String mail;
	String mailtype="Mail";
	
//creating object for the classes 
	
	ContactDTO contactDTO=new ContactDTO();
	ContactPerson contactPersonRefrence;
	ContactAddress contacatAddress;
//*************************************ADDING CONTACT INFO*****************************
	//adding name
	public  void addName() {
		System.out.println("do u want to enter a name? y/n");
		String choose;
		// String addname;
		choose = sc.next();
		while (choose.equalsIgnoreCase("y")) {
			isContactAdded = "true";
			String firstname, midname, lastname;
			String fullname;
			System.out.println(" Enter firstname");
			firstname = sc.next();
			System.out.println(" Enter midname");
			midname = sc.next();
			System.out.println(" Enter lastname");
			lastname = sc.next();
			fullname = firstname + " " + midname + " " + lastname;
			contactPersonRefrence.addName(nametype, fullname);
			System.out.println("do u want to add another name? y/n");
			choose = sc.next();
			if (choose.equalsIgnoreCase("y")) {
				System.out.println("enter the type of the name");
				nametype = sc.next();
			}
		}
		//contactname.addAllTheName(id);
		nametype = "Name";
	}
	
	// adding mobile
		public  void addMobileNomber() {
			contactPersonRefrence.setMobilenumberGategory();
			System.out.println("do u want to enter mobile number? y/n");
			String choose;
			int chooseType;
			// String addname;\=
			choose = sc.next();
			while (choose.equalsIgnoreCase("y")) {
				isContactAdded = "true";
				
				Map<Integer, String> map = contactPersonRefrence.getMobilenumberGategory();
				for (Map.Entry enrymap : map.entrySet()) {
					System.out.println(enrymap.getKey() +"."+ enrymap.getValue());
				}
				System.out.println("Entr 1 to "+map.size());
				chooseType=sc.nextInt();
				if (map.get(chooseType).equals("custom")) {
					System.out.println("enter the type of the number");
					mobilenumbertype = sc.next();
					contactPersonRefrence.addMobilenumberGategory(map.size() + 1, mobilenumbertype);
				} else {
					mobilenumbertype=map.get(chooseType);
				}
				System.out.println("enter " + mobilenumbertype + " number");
				mobilenumber = sc.next();

				contactPersonRefrence.addMobileNumber(mobilenumbertype, mobilenumber);
				System.out.println("do u want to add another number? y/n");
				choose = sc.next();
			}
			
			mobilenumbertype = "Mobile";
		}

		// adding Address
		public  void addAdress() {
			System.out.println("do u want to enter a address? y/n");
			String choose;
			//address variable
			String street;
			String city;
			String state;
			String country;
			String zipcode;
			int addtype;
			choose = sc.next();
			while (choose.equalsIgnoreCase("y")) {
				isContactAdded = "true";
				contacatAddress=contactPersonRefrence.getAddressRefrence();
				System.out.println("1.home\n2.work\n3.other");
				addtype=sc.nextInt();
				if(addtype==1){
					addresstype="home";
				}else if(addtype==2){
					addresstype="work";
				}
				else{
					addresstype="other";
				}
				System.out.println(" Enter street");
				street = sc.next();
				contacatAddress.setStreet(street);
				System.out.println(" Enter city");
				city = sc.next();
				contacatAddress.setCity(city);
				System.out.println(" Enter state");
				state = sc.next();
				contacatAddress.setState(state);
				System.out.println(" Enter country");
				country = sc.next();
				contacatAddress.setCoutry(country);
				System.out.println(" Enter zip code");
				zipcode = sc.next();
				contacatAddress.setZipcode(zipcode);
				contactPersonRefrence.addAddress(addresstype, contacatAddress);
				System.out.println("do u want to add another address? y/n");
				choose = sc.next();
//				if (choose.equalsIgnoreCase("y")) {
//					System.out.println("enter the type of the address");
//					addresstype = sc.next();
//				}
			}
		}

		// adding mail
		public  void addMail() {
			System.out.println("do u want to enter a mail? y/n");
			String choose;
			// String addname;
			choose = sc.next();
			while (choose.equalsIgnoreCase("y")) {
				isContactAdded = "true";
				System.out.println(" Enter the " + mailtype);
				mail = sc.next();
				contactPersonRefrence.addMail(mailtype, mail);
				System.out.println("do u want to add another mail? y/n");
				choose = sc.next();
				if (choose.equalsIgnoreCase("y")) {
					System.out.println("enter the type of the mail");
					mailtype = sc.next();
				}
			}
		
			mailtype = "Mail";
		}

//***********************************DISPLAYING CONTACT INFO*****************************
		
	public void displayContact(int contactid)
	{
		System.out.println("**********id=" + contactid + " ******************");
		contactPersonRefrence= contactDTO.retriveContactOfSinglePerson(contactid);
		System.out.println("----------Name----------------");
		displayName();
		System.out.println("-------Mobile number----------");
		displayMobileNumber();
		System.out.println("----------Address-------------");
		displayAddress();
		System.out.println("------------Mail-------------");
		displayMail();
	}
	public  void displayName() {
		Map<String, String> map = contactPersonRefrence.getName();
		for (Map.Entry enrymap : map.entrySet()) {
			System.out.println(enrymap.getKey() + " " + enrymap.getValue());
		}
	}
	
	public  void displayMobileNumber() {
		Map<String, String> map = contactPersonRefrence.getMobileNumber();
		for (Map.Entry entrymap : map.entrySet()) {
			System.out.println(entrymap.getKey() + " " + entrymap.getValue());
		}
	}
	public  void displayAddress() {
		Map<String, ContactAddress> map = contactPersonRefrence.getAddress();
		for (Map.Entry entrymap : map.entrySet()) {
			System.out.println("-------"+entrymap.getKey() + " Address------" );
			displayEachAddressForSingaleContact(map,entrymap);
		}
	}
	
	private void displayEachAddressForSingaleContact(Map<String, ContactAddress> map,Map.Entry entrymap){
		contacatAddress=map.get(entrymap.getKey());
		System.out.println("street:"+contacatAddress.getStreet());
		System.out.println("city:"+contacatAddress.getCity());
		System.out.println("state:"+contacatAddress.getState());
		System.out.println("country:"+contacatAddress.getCoutry());
		System.out.println("street:"+contacatAddress.getZipcode());
		System.out.println("------------------------------------------");
	}
	
	public  void displayMail() {
		Map<String, String> map = contactPersonRefrence.getMail();
		for (Map.Entry entrymap : map.entrySet()) {
			System.out.println(entrymap.getKey() + " " + entrymap.getValue());
		}
	}
//*****************************************EDIT CONTACT*********************************
	public void editName(){
		String firstname, midname, lastname;
		String fullname;
		Map<String, String> map = contactPersonRefrence.getName();
		int i=1;
		int opt;
		for (Map.Entry enrymap : map.entrySet()) {
			System.out.println(i+"."+enrymap.getKey()+"------>"+enrymap.getValue());	
			i++;
		}
		System.out.println("Enter 1 to "+map.size());
		opt=sc.nextInt();
		if (opt < i) {
			i=1;
			for (Map.Entry enrymap : map.entrySet()) {
				if (opt == i) {
					nametype = (String) enrymap.getKey();
					break;
				}
				i++;
			}

			System.out.println(" Enter firstname");
			firstname = sc.next();
			System.out.println(" Enter midname");
			midname = sc.next();
			System.out.println(" Enter lastname");
			lastname = sc.next();
			fullname = firstname + " " + midname + " " + lastname;
			contactPersonRefrence.addName(nametype, fullname);
		}
		else{
			System.out.println("wrong option");
		}
		
	}
	
	public void editMobileNumber(){
		Map<String, String> map = contactPersonRefrence.getMobileNumber();
		int i=1;
		int opt;
		for (Map.Entry enrymap : map.entrySet()) {
			System.out.println(i+"."+enrymap.getKey()+"------>"+enrymap.getValue());	
			i++;
		}
		System.out.println("Enter 1 to "+map.size());
		opt=sc.nextInt();
		if (opt < i) {
			i=1;
			for (Map.Entry enrymap : map.entrySet()) {
				if (opt == i) {
					mobilenumbertype = (String) enrymap.getKey();
					break;
				}
				i++;
			}

			System.out.println("enter " + mobilenumbertype + " number");
			mobilenumber = sc.next();

			contactPersonRefrence.addMobileNumber(mobilenumbertype, mobilenumber);
		}
		else{
			System.out.println("wrong option");
		}
		
	}
	
	public  void editAddress() {
		Map<String, ContactAddress> map = contactPersonRefrence.getAddress();
		int i=1;
		int opt;
		String street;
		String city;
		String state;
		String country;
		String zipcode;
		for (Map.Entry entrymap : map.entrySet()) {
			System.out.println(i+"."+entrymap.getKey() + " address" );
			displayEachAddressForSingaleContact(map,entrymap);

			i++;
		}
		System.out.println("Enter 1 to "+map.size());
		opt=sc.nextInt();
		if(opt<i){
			i=1;
			for (Map.Entry entrymap : map.entrySet()) {
				if(opt==i){
					addresstype = (String) entrymap.getKey();
					break;
				}
				i++;
			}
			
			System.out.println(" Enter street");
			street = sc.next();
			contacatAddress.setStreet(street);
			System.out.println(" Enter city");
			city = sc.next();
			contacatAddress.setCity(city);
			System.out.println(" Enter state");
			state = sc.next();
			contacatAddress.setState(state);
			System.out.println(" Enter country");
			country = sc.next();
			contacatAddress.setCoutry(country);
			System.out.println(" Enter zip code");
			zipcode = sc.next();
			contacatAddress.setZipcode(zipcode);
			contactPersonRefrence.addAddress(addresstype, contacatAddress);
		}else{
			System.out.println("wrong option");
		}
	}
	
	public void editMail(){
		Map<String, String> map = contactPersonRefrence.getMail();
		int i=1;
		int opt;
		for (Map.Entry enrymap : map.entrySet()) {
			System.out.println(i+"."+enrymap.getKey()+"------>"+enrymap.getValue());	
			i++;
		}
		System.out.println("Enter 1 to "+map.size());
		opt=sc.nextInt();
		if (opt < i) {
			i=1;
			for (Map.Entry enrymap : map.entrySet()) {
				if (opt == i) {
					mailtype = (String) enrymap.getKey();
					break;
				}
				i++;
			}

			System.out.println(" Enter the " + mailtype);
			mail = sc.next();
			contactPersonRefrence.addMail(mailtype, mail);
		}
		else{
			System.out.println("wrong option");
		}
		
	}
	
//******************************************SEARCH CONTACT*****************************
	public  void searchName(int contactid,String naemSearch) {
		Map<String, String> map = contactPersonRefrence.getName();
		for (Map.Entry<String, String> enrymap : map.entrySet()) {
			//System.out.println(enrymap.getKey() + " " + enrymap.getValue());
			String nam=enrymap.getValue();
			if(nam.contains(naemSearch)){
				displayContact(contactid);
				break;
			}
		}
	}
	
	public  void searchMobileNumber(int contactid,String naemSearch) {
		Map<String, String> map = contactPersonRefrence.getMobileNumber();
		for (Map.Entry entrymap : map.entrySet()) {
			//System.out.println(entrymap.getKey() + " " + entrymap.getValue());
			String no=(String)entrymap.getValue();
			if(no.contains(naemSearch)){
				displayContact(contactid);
			}
		}
	}
	
// ******************************************USER OPTION********************************	
	
	public void userOption() {
		
		while (useroption != 6) {
			System.out.println("*************************User Option*******************");
			System.out.println(
							"1.Add Contact\n" +
							"2.Display Contact\n"+ 
							"3.Search Contact\n" 	+ 
							"4.Edit Contact\n" 	+ 		
							"5.Delete Contact\n" +
							"6.Exit");
			
			System.out.println("********************************************************");
			System.out.println("Enter Ur option 1-5");
			useroption = sc.nextInt();
			switch (useroption) {
			case 1:
				contactPersonRefrence = contactDTO.getContactRefrence();
				addName();
				addMobileNomber();
				addAdress();
				addMail();
				if (isContactAdded.equals("true")) {
					contactDTO.setContactRefrence(id, contactPersonRefrence);
					System.out.println("Contact Saved Successfully");
					isContactAdded = "false";
					id++;
				}
				break;

			case 2:

				if (id == 0)
					System.out.println("There is no Contacts to Show");
				else {
					System.out.println("***********************************");
					for (int i = 0; i < id; i++) {
						if (contactDTO.isDeleted(i).equals("false")) {
							displayContact(i);
						}
					}
					System.out.println("***********************************");
				}

				break;
			case 3:
				String search;
				// System.out.println("Search");
				System.out.println("enter the name or number");
				search = sc.next();
				if (id == 0)
					System.out.println("There is no Contacts to Search Add some contact first");
				else {
					System.out.println("***********************************");
					for (int i = 0; i < id; i++) {
						// displayContact(i);
						if (contactDTO.isDeleted(i).equals("false")) {
							contactPersonRefrence = contactDTO.retriveContactOfSinglePerson(i);
							searchName(i, search);
							searchMobileNumber(i, search);
						}
					}
					System.out.println("***********************************");
				}
				break;
			case 4:
				// System.out.println("eidt");
				if (id == 0)
					System.out.println("There is no Contacts to Edit");
				else {
					System.out.println("***********************************");
					for (int i = 0; i < id; i++) {
						if (contactDTO.isDeleted(i).equals("false")) {
							displayContact(i);
						}
					}
					System.out.println("***********************************");
					System.out.println("Enter the contact id Eidit");
					int editId;
					editId = sc.nextInt();

					if (editId < id && contactDTO.isDeleted(editId).equals("false")) {
						contactPersonRefrence = contactDTO.retriveContactOfSinglePerson(editId);
						displayContact(editId);
						int choose = 1;
						int option;
						while (choose != 5) {
							System.out.println("1.Name\n2.Mobile number\n3.Address\n4.Email\n5.Update Contact");
							option = sc.nextInt();
							choose = option;
							switch (option) {
							case 1:
								editName();
								break;
							case 2:
								editMobileNumber();
								break;
							case 3:
								editAddress();
								break;
							case 4:
								editMail();
								break;
							case 5:
								System.out.println("Contact updated Successfully");
								break;
							default:
								System.out.println("wrong option");

							}
						}
					} else {
						System.out.println("id dose not exsit");
					}
				}
				break;
			case 5:
				if (id == 0)
					System.out.println("There is no Contacts to Delete");
				else {
					System.out.println("***********************************");
					for (int i = 0; i < id; i++) {
						if (contactDTO.isDeleted(i).equals("false")) {
							displayContact(i);
						}
					}
					System.out.println("***********************************");
					System.out.println("Enter the contact id to delete");
					int deleteId;
					deleteId = sc.nextInt();
					if (deleteId < id && contactDTO.isDeleted(deleteId).equals("false")) {
						contactDTO.deleteContact(deleteId);
						System.out.println("deleted successfully");
					} else {
						System.out.println("id dose not exsit");
					}
				}

				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("wrong input Enter the correct option from 1 to 5");

			}

			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ViewController viewController=new ViewController();
		viewController.userOption();
	}
	
}
