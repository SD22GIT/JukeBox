package com.example.demo.commands;

import com.example.demo.services.PlaylistService;
import java.util.List;

public class LoadPlaylistCommand implements ICommand {

    private final PlaylistService playlistService;

    public LoadPlaylistCommand(PlaylistService playlistService)
    {
         this.playlistService = playlistService;
    
    }

    @Override
    public void invoke(List<String> tokens)
    {
        playlistService.loadPlaylist(tokens.get(1));
        System.out.println("Playlist "+tokens.get(1)+" is loaded!");
    }
}
