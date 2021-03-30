package com.company;

public class Main {

    public static void main(String[] args) {
        bank bank = new bank("Hieudz");
        bank.addBranch("Ha Noi");
        bank.addBranch("Hcm");
        bank.addCustomer("Ha Noi","Hieu",100);
        bank.addCustomer("Ha Noi","Nam",200);
        bank.addCustomer("Ha Noi","Ha",100);
        bank.addTransaction("Ha Noi","Hieu",200);
        bank.addTransaction("Ha Noi","Hieu",300);
        bank.addTransaction("Ha Noi","Nam",200);
        bank.listCustomer("Ha Noi",false);
    }
}
