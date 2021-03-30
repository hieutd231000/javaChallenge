package com.company;

import java.util.ArrayList;

public class bank {
    private String name;
    private ArrayList<branch> branches;
    public bank(String name){
        this.name = name;
        this.branches = new ArrayList<branch>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<branch> getBranches(){
        return branches;
    }
    public boolean addBranch(String nameBranch){
        if(findBranch(nameBranch) == null){
            this.branches.add(new branch(nameBranch));
        //    System.out.println("Add branch success");
            return true;
        }
        return false;
    }
    public boolean addCustomer(String nameBranch, String nameCustomer, double initialTransaction){
        branch currentBranch = findBranch(nameBranch);
        if(currentBranch != null){
            currentBranch.addNewCustomer(nameCustomer,initialTransaction);
        //    System.out.println("Add customer success");
            return true;
        }
        return false;
    }
    public boolean addTransaction(String nameBranch, String nameCustomer, double transaction){
        branch currentBranch = findBranch(nameBranch);
        if(currentBranch != null){
            currentBranch.addTransactions(nameCustomer,transaction);
        //    System.out.println("Add transaction success");
            return true;
        }
        return false;
    }
    public branch findBranch(String nameBranch){
        for(int i=0 ; i<branches.size(); i++){
            if(this.branches.get(i).getName().equals(nameBranch)){
                return branches.get(i);
            }
        }
        return null;
    }
    public boolean listCustomer(String nameBranch, boolean tTransaction){
        branch currentBranch = findBranch(nameBranch);
        System.out.println("Customer detail in " +nameBranch);
        if(!tTransaction){
            ArrayList<customers> branchCustomer = currentBranch.getCustomers();
            for(int i=0; i<branchCustomer.size(); i++){
                System.out.println("Customer: " +branchCustomer.get(i).getName());
            }
            return true;
        }
        for(int i=0; i<currentBranch.getCustomers().size(); i++){
            System.out.println("Customer: " +currentBranch.getCustomers().get(i).getName() +"\nTransaction:");
            for(int j=0; j<currentBranch.getCustomers().get(i).getTransactions().size(); j++){
                System.out.println(j+1+":   "+currentBranch.getCustomers().get(i).getTransactions().get(j));
            }
        }
        return true;
    }
}
