package com.company;

import java.util.ArrayList;

public class MobiePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;
    public MobiePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }
    public void printContact(){
        for(int i=0 ; i<myContact.size(); i++){
            System.out.println((i+1) +
                    ".  " + myContact.get(i).getName() +
                    "->" + myContact.get(i).getPhoneNumber());
        }
    }
    public boolean addNewContact(Contact newContact){
        if(findContact(newContact.getName())>=0){
            System.out.println("Name is on file! You cant add new name");
            return false;
        }
        myContact.add(newContact);
        System.out.println("Add successed\n");
        return true;
    }
    public Contact checkContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContact.get(position);
        }
        return null;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position<0){
            System.out.println("You cant update contact");
            return false;
        }else if(findContact(newContact.getName())>=0){
            System.out.println("Name " + newContact.getName() + " is avaiable");
            return false;
        }
        this.myContact.set(position,newContact);
        System.out.println("Update success\n");
        return true;
    }
    public boolean removeContact(Contact contact){
        if(findContact(contact)<0){
            System.out.println("You cant remove");
            return false;
        }
        this.myContact.remove(contact);
        System.out.println("Remove success\n");
        return true;
    }
    public void clearContact(){
        if(this.myContact.size()==0){
            System.out.println("Empty");
            return;
        }
        this.myContact.clear();
        System.out.println("Delete all contact");
    }
    private int findContact(Contact contact){
        return this.myContact.indexOf(contact);
    }
    private int findContact(String name){
        for(int i=0 ; i<myContact.size(); i++){
            if(this.myContact.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
}
