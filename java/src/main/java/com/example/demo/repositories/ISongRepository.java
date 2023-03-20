package com.example.demo.repositories;

import com.example.demo.entities.Song;
import java.util.List;

public interface ISongRepository {

    public void addSong(Song song);
    public Song getSong(int id);
    public List<Song> getAllSongs();
    
}
