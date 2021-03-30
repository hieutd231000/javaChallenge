package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    Album album = new Album("hieuSong","hieu");
	    album.addSong("a",1.1);
	    album.addSong("b",1.2);
        album.addSong("c",1.3);
        album.addSong("d",1.4);
        album.addSong("e",1.5);
        albums.add(album);
        album = new Album("namSong","nam");
        album.addSong("aa",1.1);
        album.addSong("bb",1.2);
        album.addSong("cc",1.3);
        album.addSong("dd",1.4);
        album.addSong("ee",1.5);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("a",playList);
        albums.get(0).addToPlayList("f",playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(5,playList);
        play(playList);

    }
    private static void printMenu(){
        System.out.println("Press");
        System.out.println("0 - To quit\n" +
                "1 - To play next song\n" +
                "2 - To play previous song\n" +
                "3 - To replay current song\n" +
                "4 - To list song\n" +
                "5 - To menu\n" +
                "6 - Delete current song from playlist\n");
    }
    private static void play(LinkedList<Song> playList){
        ListIterator<Song> songListIterator = playList.listIterator();
        printMenu();
        if(playList.isEmpty()){
            System.out.println("Playlist is empty");
            return;
        }else{
            System.out.println("Now playing: "+songListIterator.next());
        }
        boolean quit = false;
        boolean goForward = true;
        while(!quit){
            int chose = scanner.nextInt();
            scanner.nextLine();
            switch (chose){
                case 0:
                    System.out.println("Log out");
                    quit = true;
                    break;
                case 1:
                    if(!goForward){
                        if(songListIterator.hasNext()){
                            songListIterator.next();
                        }
                        goForward = true;
                    }
                    if(songListIterator.hasNext()){
                        System.out.println("Now playing: " +songListIterator.next());
                    }else{
                        System.out.println("We are at the end of playlist");
                        goForward = false;
                    }
                    break;
                case 2:
                    if(goForward){
                        if(songListIterator.hasPrevious()){
                            songListIterator.previous();
                        }
                        goForward = false;
                    }
                    if(songListIterator.hasPrevious()){
                        System.out.println("Now playing: " +songListIterator.previous());
                    }else{
                        System.out.println("We are at the begin of playlist");
                        goForward = true;
                    }
                    break;
                case 3:
                    if(!songListIterator.hasNext()){
                        System.out.println("We are at the end of playlist");
                    }
                    else if(!songListIterator.hasPrevious()){
                        System.out.println("We are at the begin of playlist");
                    }else{
                        if(goForward){
                            System.out.println("Replay" + songListIterator.previous());
                            songListIterator.next();
                        }else{
                            System.out.println("Replay" + songListIterator.next());
                            songListIterator.previous();
                        }
                    }
                    break;
                case 4:
                    System.out.println("List song: ");
                    Iterator<Song> i = playList.iterator();
                    while(i.hasNext()){
                        System.out.println(i.next());
                    }
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(!playList.isEmpty()){
                        songListIterator.remove();
                        if(songListIterator.hasNext()){
                            System.out.println("Now playing: "+songListIterator.next());
                        }else if(songListIterator.hasPrevious()){
                            System.out.println("Now playing: "+songListIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

}
