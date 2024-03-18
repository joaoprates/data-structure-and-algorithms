package dsa.vector.labs;

import dsa.vector.List;
import dsa.vector.teste.Contact;

import java.util.Scanner;

public class Exer01 {

    public static void main(String[] args) {

        // Creating variables
        Scanner scan = new Scanner(System.in);

        // Create vector with a capacity of 20
        List<Contact> list = new List<Contact>(20);

        // Create and add X Contacts dynamically
        createContactsDynamically(5, list);

        // Create a menu for the user to choose the option
        int option = 1;

        while (option != 0){

            option = getOptionMenu(scan);

            switch (option) {
                case 1:
                    addContactAtEnd(scan, list);
                    break;
                case 2:
                    addContactAtPosition(scan, list);
                    break;
                case 3:
                    getContactAtPosition(scan, list);
                    break;
                case 4:
                    getContact(scan, list);
                    break;
                case 5:
                    searchLastIndex(scan, list);
                    break;
                case 6:
                    searchContactIfExists(scan, list);
                    break;
                case 7:
                    removeByPosition(scan, list);
                    break;
                case 8:
                    removeContact(scan, list);
                    break;
                case 9:
                    printVectorLength(list);
                    break;
                case 10:
                    clearVector(list);
                    break;
                case 11:
                    printVector(list);
                    break;
                default:
                    break;
            }
        }

        System.out.println("User typed 0, system has finished");
    }

    private static void printVector(List<Contact> list){

        System.out.println(list);
    }

    private static void clearVector(List<Contact> list){

        list.clear();

        System.out.println("All contacts were purged");
    }

    private static void printVectorLength(List<Contact> list){

        System.out.println("Vector length is: " + list.length());
    }

    private static void removeByPosition(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be removed", scan);

        try {

            list.remove(pos);

            System.out.println("Contact removed");

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void removeContact(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be removed", scan);

        try {

            Contact contact = list.search(pos);

            list.remove(contact);

            System.out.println("Contact removed");

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void searchContactIfExists(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be searched", scan);

        try {

            Contact contact = list.search(pos);

            boolean exist = list.contains(contact);

            if (exist){
                System.out.println("Contact exists, follow the data:");
                System.out.println(contact);
            } else {
                System.out.println("Contact not found");
            }

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void searchLastIndex(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be searched", scan);

        try {

            Contact contact = list.search(pos);

            System.out.println("Contact exists, follow the data:");
            System.out.println(contact);

            System.out.println("Searching for the last index of the Contact found:");
            pos = list.lastIndex(contact);

            System.out.println("Contact found at position " + pos);

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void getContact(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be searched", scan);

        try {

            Contact contact = list.search(pos);

            System.out.println("Contact exists, follow the data:");
            System.out.println(contact);

            System.out.println("Searching for the Contact found:");
            pos = list.search(contact);

            System.out.println("Contact found at position " + pos);

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void getContactAtPosition(Scanner scan, List<Contact> list){

        int pos = readInformationInt("Please, type the position to be searched", scan);

        try {

            Contact contact = list.search(pos);

            System.out.println("Contact exists, follow the data:");
            System.out.println(contact);

        } catch (Exception e) {
            System.out.println("Invalid position!");
        }
    }

    private static void addContactAtEnd(Scanner scan, List<Contact> list){

        System.out.println("Creating a Contact, enter the information:");
        String name = readInformation("Enter the name", scan);
        String phone = readInformation("Enter the phone number", scan);
        String email = readInformation("Enter the email", scan);

        Contact contact = new Contact(name, phone, email);

        list.add(contact);

        System.out.println("Contact added successfully!");
        System.out.println(contact);
    }

    private static void addContactAtPosition(Scanner scan, List<Contact> list) {
        System.out.println("Creating a Contact, enter the information:");
        String name = readInformation("Enter the name", scan);
        String phone = readInformation("Enter the phone number", scan);
        String email = readInformation("Enter the email", scan);

        Contact contact = new Contact(name, phone, email);

        int pos = readInformationInt("Enter the position to add the Contact", scan);

        try {
            if (pos < 0 || pos > list.length()) {
                System.out.println("Invalid position. Position should be between 0 and " + list.length());
                return;
            }

            list.add(pos, contact);
            System.out.println("Contact added successfully!");
            System.out.println(contact.toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid position, Contact not added");
        }
    }


    protected static String readInformation(String msg, Scanner scan){

        System.out.println(msg);

        return scan.nextLine();
    }

    protected static int readInformationInt(String msg, Scanner scan){

        boolean entryOk = false;
        int num = 0;

        while (!entryOk){

            try {

                System.out.println(msg);
                String entry = scan.nextLine();

                num = Integer.parseInt(entry);

                entryOk = true;

            } catch (Exception e){
                System.out.println("Invalid, try again");
            }
        }

        return num;
    }

    protected static int getOptionMenu(Scanner scan){

        boolean entryOk = false;
        int option = 0;
        String entry;

        while (!entryOk){

            System.out.println("Enter the desired option:");
            System.out.println("1: Add Contact to the end of the vector");
            System.out.println("2: Add Contact at a specific position");
            System.out.println("3: Get Contact from a specific position");
            System.out.println("4: Search Contact");
            System.out.println("5: Get the last index of the Contact");
            System.out.println("6: Check if Contact exists");
            System.out.println("7: Delete by position");
            System.out.println("8: Delete Contact");
            System.out.println("9: Check vector size");
            System.out.println("10: Delete all Contacts from the vector");
            System.out.println("11: Print vector");
            System.out.println("0: Exit");

            try {

                entry = scan.nextLine();
                option = Integer.parseInt(entry);

                if (option >= 0 && option <= 11){
                    entryOk = true;
                } else {
                    throw new Exception();
                }

            } catch (Exception e){

                System.out.println("Invalid, try again\n\n");
            }
        }

        return option;
    }

    protected static void createContactsDynamically(int quantity, List<Contact> list){

        for (int i = 1; i <= quantity; i++) {
            String name = "Contact " + i;
            String phone = "1111111" + i;
            String email = "Contact" + i + "@email.com";
            Contact Contact = new Contact(name, phone, email);
            list.add(Contact);
        }
    }
}
