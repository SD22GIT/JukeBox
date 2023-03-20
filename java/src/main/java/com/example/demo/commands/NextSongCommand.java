package com.example.demo.commands;

import com.example.demo.services.PlaylistService;
import java.util.List;
import com.example.demo.entities.Song;

public class NextSongCommand implements ICommand {

    private final PlaylistService playlistService;

    public NextSongCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        Song song =playlistService.nextSong();
        System.out.println("Song [id="+song.getId()+"] is playing!");
    }
    
}
