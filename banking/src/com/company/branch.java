package com.company;

import java.util.ArrayList;

public class branch {
    private String name;
    private ArrayList<customers> customers;
    public branch(String name){
        this.name = name;
        this.customers = new ArrayList<customers>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<customers> getCustomers(){
        return customers;
    }
    public boolean addNewCustomer(String name, double initialTransaction){
        if(findCustomers(name) == null){
            this.customers.add(new customers(name,initialTransaction));
            return true;
        }
        return false;
    }
    public boolean addTransactions(String name, double amount){
        customers currentCustomer = findCustomers(name);
        if(currentCustomer != null){
            currentCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }
    private customers findCustomers(String name){
        for(customers checkedCustomer: this.customers){
            if(checkedCustomer.getName().equals(name)){
                return checkedCustomer;
            }
        }
        return null;
        int
    }
}
