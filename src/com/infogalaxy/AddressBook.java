package com.infogalaxy;

import java.util.ArrayList;

import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactList = new ArrayList<>();


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
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            System.out.println(contact.toString());
        }
    }

    public void editname() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Name : ");
        String f_name = sc.next();
        int temp = 0;

        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (f_name.equals(contact.getFirstName())) {
                System.out.println("Contact is Found...");
                temp = 1;

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

                break;
            }
        }
        if (temp == 0) {
            System.out.println("Contact is Not Found...");
        }
    }

    public void SearchState() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the State Name for Search : ");
        String s_name = scanner.next();
        int t = 0;

        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);

            if (s_name.equals(contact.getState())) {
                System.out.println(contact.getFirstName());
                System.out.println(contact.getMobno());
                t = t + 1;
            }
        }
        System.out.println("Total Contact Having Same State is : " + t);
    }

    public void DeleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Contact Name : ");
        String c_name = scanner.next();

        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);

            if (c_name.equals(contact.getFirstName())) {
                contactList.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;
        do {
            System.out.println("*** CONTACT INVENTORY MANAGEMENT ***");
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3. EDIT CONTACT \n4. SEARCH STATE \n5. DELETE CONTACT \n6. EXIT ");
            System.out.println("Enter Your Choice : ");
            choice = scanner1.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addcontact();
                    break;
                case 2:
                    addressBook.displayContact();
                    break;
                case 3:
                    addressBook.editname();
                    break;
                case 4:
                    addressBook.SearchState();
                    break;

                case 5:
                    addressBook.DeleteContact();
                    break;
            }
        }
        while (choice != 6);
        {

        }
    }
}


