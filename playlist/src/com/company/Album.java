package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songList;
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }
    public boolean addSong(String title, double duration){
        return this.songList.add_song(new Song(title,duration));
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song find_song = this.songList.findSong(title);
        if(find_song!=null){
            playList.add(find_song);
            return true;
        }
        return false;
    }
    public boolean addToPlayList(int position, LinkedList<Song> playList){
        if(songList.findSong(position-1)!=null){
            playList.add(songList.findSong(position));
            return true;
        }
        //System.out.println("This song does not exist");
        return false;
    }

    private class SongList{
        ArrayList<Song> songs;
        public SongList(){
            this.songs = new ArrayList<>();
        }
        public boolean add_song(Song song){
            if(this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }
        public Song findSong(String title){
            for(Song checkedSong: this.songs){
                if(checkedSong.getTitle().equals(title))
                    return checkedSong;
            }
            return null;
        }
        public Song findSong(int position){
            if(position-1>=0 && position-1<this.songs.size()){
                return this.songs.get(position-1);
            }
            return null;
        }
    }

}
