package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {

    private static HashMap<Integer,Playlist> playListRepository = new HashMap<>();

    @Override
    public void addPlayList(Playlist playlist)
    {
        playListRepository.put(playlist.getId(), playlist);
    }

    @Override
    public Playlist getPlaylistById(int id)
    {
        return playListRepository.get(id);
    }

    @Override
    public Playlist getPlaylistByName(String name)
    {
        for(Map.Entry<Integer,Playlist> entry:playListRepository.entrySet())
        {
            if(entry.getValue().getName().equalsIgnoreCase(name))
            {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean deletePlaylist(int id)
    {
        if(!playListRepository.containsKey(id))
        {
            return false;
        }
        else
        {
            playListRepository.remove(id);
            return true;
        }
    }
    
}
