package com.example.demo.entities;

public class Song {
    private int id;
    private String name;
    private String artist;
    private String album;
    private String genre;
    private static int autoIncrementId = 1;

    public Song(String name,String artist,String album,String genre)
    {
        this.id = autoIncrementId;
        ++autoIncrementId;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public String getAlbum()
    {
        return this.album;
    }

    public String getGenre()
    {
        return this.genre;
    }


    
}
