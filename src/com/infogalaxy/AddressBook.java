package com.infogalaxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void BackupToFile() {
        String c_Data = null;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            c_Data = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," + contact.getCity()
                    + "," + contact.getState() + "," + contact.getMobno() + "," + contact.getEmail() + "," + contact.getZip() + "\n" + c_Data;
            try {
                Path file = Paths.get("MyData.txt");
                byte[] fileData = c_Data.getBytes();
                Files.write(file, fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void restoreFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("MyData.txt"));
            String data;
            while ((data = bufferedReader.readLine()) != null && !data.equalsIgnoreCase("null")) {
                String[] separateData = data.split(",");
                Contact contact = new Contact();
                contact.setFirstName(separateData[0]);
                contact.setLastName(separateData[1]);
                contact.setAddress(separateData[2]);
                contact.setCity(separateData[3]);
                contact.setState(separateData[4]);
                contact.setMobno(separateData[5]);
                contact.setEmail(separateData[6]);
                contact.setZip(separateData[7]);
                contactList.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;
        do {
            System.out.println("*** CONTACT INVENTORY MANAGEMENT ***");
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3. EDIT CONTACT \n4. SEARCH STATE \n5. DELETE CONTACT" +
                    "\n6.BACK UP TO FILE \n7. RESTORE FROM FILE \n8. EXIT ");

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

                case 6:
                    addressBook.BackupToFile();
                    break;
                case 7:
                    addressBook.restoreFromFile();
                    break;
            }
        }
        while (choice != 8);

    }
}


