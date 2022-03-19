package com.infogalaxy;

import java.util.Scanner;

public class AddressBook {
    //UC-1-Display Address Book Data
    Scanner scanner = new Scanner(System.in);
    com.infogalaxy.contact contact = new contact();

    public void addContact() {
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
    }
    public void displayContact() {
        System.out.println(contact.toString());
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.displayContact();

    }
}


