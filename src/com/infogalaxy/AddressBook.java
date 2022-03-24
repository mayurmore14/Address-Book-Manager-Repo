package com.infogalaxy;

import java.util.ArrayList;

import java.util.Scanner;

public class AddressBook {
    //UC-1-Display Address Book Data
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactList = new ArrayList();

    public void addcontact() {
        Contact contact = new Contact();

        System.out.println("Enter the First Name : ");
        contact.setFirstName(scanner.next());
        System.out.println("Enter the Last Name : ");
        contact.setLastName(scanner.next());
        System.out.println("Enter the Address : ");
        contact.setAddress(scanner.next());
        System.out.println("Enter the City : ");
        contact.setCity(scanner.next());
        System.out.println("Enter the State : ");
        contact.setState(scanner.next());
        System.out.println("Enter the Mobile Number : ");
        contact.setMobno(scanner.next());
        System.out.println("Enter the Email ID : ");
        contact.setEmail(scanner.next());
        System.out.println("Enter the Zip Code : ");
        contact.setZip(scanner.next());

        contactList.add(contact);
    }
    public void displayContact() {
        for(int i = 0; i < contactList.size(); i ++) {
            Contact contact = contactList.get(i);
            System.out.println(contact.toString());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;
        do {
            System.out.println("*** CONTACT INVENTORY MANAGEMENT ***");
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3. EXIT ");
            System.out.println("Enter Your Choice : ");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    addressBook.addcontact();
                    break;
                case 2:
                    addressBook.displayContact();
                    break;
            }
        } while (choice != 3);
    }
}



