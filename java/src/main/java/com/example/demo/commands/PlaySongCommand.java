package com.example.demo.commands;

import com.example.demo.services.PlaylistService;
import java.util.List;

public class PlaySongCommand implements ICommand{

    private final PlaylistService playlistService;

    public PlaySongCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
          String arr[] = playlistService.playSong();
          System.out.println("Song [id="+arr[0]+"] is "+arr[1]+"!");
    }
    
}
