package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;
import com.example.demo.entities.Song;

public class AddSongToPlaylistCommand implements ICommand {


    private final PlaylistService playlistService;
    public AddSongToPlaylistCommand(PlaylistService playlistService)
    {
         this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
      Playlist playlist =  playlistService.addSongToPlaylist(tokens.get(1), Integer.parseInt(tokens.get(2)));
      System.out.print("Playlist "+playlist.getName()+" is revised with [");
      List<Song> songs =  playlist.getSongsPlayList().getAllSongs();
      int i=0;
      for(;i<songs.size()-1;++i)
      {
        System.out.print("Song [id="+songs.get(i).getId()+"], ");
      }
      System.out.println("Song [id="+songs.get(i).getId()+"]]");
    }
    
}
