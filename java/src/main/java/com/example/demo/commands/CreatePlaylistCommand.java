package com.example.demo.commands;

import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;
import java.util.LinkedList;
import java.util.List;

public class CreatePlaylistCommand implements ICommand {

    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        List<Integer> songIds = new LinkedList<>();
        for(int i=2;i<tokens.size();++i)
        {
            songIds.add(Integer.parseInt(tokens.get(i)));
        }

        Playlist playlist = playlistService.createPlayList(tokens.get(1), songIds);
        System.out.println("Playlist [id="+playlist.getId()+"]");

    }
    
}
