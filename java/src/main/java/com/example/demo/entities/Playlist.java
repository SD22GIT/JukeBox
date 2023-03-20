package com.example.demo.entities;

import com.example.demo.utility.SongsLinkedList;

public class Playlist {
    private int id;
    private String name;
    SongsLinkedList songs;
    private static int autoIncrementId = 1;

    public Playlist(String name,SongsLinkedList songs)
    {
       this.id = autoIncrementId;
       ++autoIncrementId;
       this.songs = new SongsLinkedList();
        this.songs.addList(songs);
        this.name = name;
    }

    public void addSong(Song song)
    {
        this.songs.addSong(song);
    }

    public void deleteSong(Song song)
    {
      this.songs.removeSong(song);
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public SongsLinkedList getSongsPlayList()
    {
        return this.songs;
    }

    public Song getCurrentSong()
    {
        return this.songs.getCurrent();
    }

    public void setCurrentSong()
    {
      this.songs.setCurrent();
    }
}
