package com.example.demo.services;

import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;
import java.util.List;

public class SongService {

    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    public Song addSong(String name,String artist,String album,String genre)
    {
        Song song = new Song(name, artist, album, genre);
        songRepository.addSong(song);
        return song;
    }

    public Song getSong(int id)
    {
        return songRepository.getSong(id);
    }

    public List<Song> listSongs()
    {
       return songRepository.getAllSongs();
    }
    
}
