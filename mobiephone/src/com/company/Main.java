package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobiePhone mobiePhone = new MobiePhone("0981037368");
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        menu();
        while(!quit){
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Shut Down");
                    quit = true;
                    break;
                case 1:
                    mobiePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 6:
                    menu();
                    break;
                case 5:
                    clearContact();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }
    private static void addNewContact(){
        System.out.println("Type the name: ");
        String name = scanner.nextLine();
        System.out.println("Type the phone: ");
        String phone = scanner.nextLine();
        Contact contact = Contact.creatContact(name,phone);
        mobiePhone.addNewContact(contact);
    }
    private static void updateContact(){
        System.out.println("Type the old name:");
        String oldName = scanner.nextLine();
        Contact oldContact = mobiePhone.checkContact(oldName);
        if(oldContact==null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Type the new name: ");
        String newName = scanner.nextLine();
        System.out.println("Type the new phone: ");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.creatContact(newName,newPhone);
        mobiePhone.updateContact(oldContact,newContact);
    }
    private static void removeContact(){
        System.out.println("Type the contact you want delete");
        String oldName = scanner.nextLine();
        Contact oldContact = mobiePhone.checkContact(oldName);
        if(oldContact==null){
            System.out.println("Contact not found");
            return;
        }
        mobiePhone.removeContact(oldContact);
    }
    private static void clearContact(){
        mobiePhone.clearContact();
    }
    private static void startPhone(){
        System.out.println("Starting Phone.....");
    }
    private static void menu(){
        System.out.println("Menu");
        System.out.println("0: Shut down\n" +
                "1: List contact\n" +
                "2: Add new contact\n" +
                "3: Update contact\n" +
                "4: Remove contact\n" +
                "5: Clear contact\n" +
                "6: Menu\n" +
                "7: Quit");
    }
}
