package com.example.demo.commands;

import com.example.demo.services.PlaylistService;
import com.example.demo.entities.Song;
import java.util.List;

public class PreviousSongCommand implements ICommand{

    private final PlaylistService playlistService;

    public PreviousSongCommand(PlaylistService playlistService)
    {
      this.playlistService = playlistService;
    }


   @Override
   public void invoke(List<String> tokens)
    {
        Song song = playlistService.previousSong();
        System.out.println("Song [id="+song.getId()+"] is playing!");
    }
    
}
