package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Player s1 = new Player("hieu",10,100);
        System.out.println(s1.toString());
        saveObject(s1);
        s1.setHitPoint(8);
        s1.setWeapon("Gun");
        System.out.println(s1.toString());
        saveObject(s1);
        loadObject(s1);
        System.out.println(s1.toString());
    }
    private static void saveObject(ISaveFun objectToSave){
        for(int i=0; i<objectToSave.write().size(); i++){
            System.out.println("Save " + objectToSave.write().get(i) + " to the storage");
        }
    }

    private static List<String> readValue(){
        List<String> values = new ArrayList<String>();
        boolean quit = false;
        System.out.println("Chose\n" +
                "1: Create Account\n" +
                "0: Quit\n");
        while(!quit){
            System.out.println("Chose option:");
            int chose = scanner.nextInt();
            scanner.nextLine();
            switch (chose){
                case 0:
                    quit = true;
                    break;
                case 1:
                    int index = 0;
                    System.out.println("Enter inf: ");
                    String newValue = scanner.nextLine();
                    values.add(index,newValue);
                    index++;
            }
        }
        return values;
    }
    private static void loadObject(ISaveFun objectToload){
        List<String> values = readValue();
        objectToload.read(values);
    }
}
