package com.example.demo.repositories;

import com.example.demo.entities.Playlist;;

public interface IPlaylistRepository {

    public void addPlayList(Playlist playlist);
    public Playlist getPlaylistById(int id);
    public Playlist getPlaylistByName(String name);
    public boolean deletePlaylist(int id);
    
}
