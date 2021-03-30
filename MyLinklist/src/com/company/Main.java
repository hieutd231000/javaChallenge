package com.company;

public class Main {

    public static void main(String[] args) {
        String stringData = "5 3 8 2 1 9 0 7 4 6";
        String[] data = stringData.split(" ");
	    MyLinkList newList = new MyLinkList(null);
	    newList.listItem(newList.getRoot());
//	    for(int i=0; i<data.length; i++){
//	        newList.addItem(new Node(data[i]));
//        }
        for(String s: data){
            newList.addItem(new Node(s));
        }
        newList.removeItem(new Node("6"));
        newList.listItem(newList.getRoot());
    }
}
