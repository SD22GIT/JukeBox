package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import com.example.demo.entities.Song;
import java.util.List;

public class SongRepository implements ISongRepository {

    private static HashMap<Integer,Song> songRepository = new HashMap<>();


    @Override
    public void addSong(Song song)
    {
         songRepository.put(song.getId(), song);
    }

    @Override
    public Song getSong(int id)
    {
        return songRepository.get(id);
    }

    @Override
    public List<Song> getAllSongs()
    {
      List<Song> songs = new LinkedList<>();

      for(Map.Entry<Integer,Song> entry:songRepository.entrySet())
      {
       songs.add(entry.getValue());
      }
      return songs;
    }
    
}
