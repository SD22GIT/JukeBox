package com.example.demo.commands;

import com.example.demo.services.SongService;
import com.example.demo.entities.Song;
import java.util.List;

public class ListSongsCommand implements ICommand{

        private final SongService songService;

        public ListSongsCommand(SongService songService)
        {
            this.songService = songService;
        }

        @Override
        public void invoke(List<String> tokens)
        {
          List<Song> songs = songService.listSongs();
          System.out.print("[");
 
          int i=0;
          for(;i<songs.size()-1;++i)
          {
            System.out.print("Song [id="+songs.get(i).getId()+"], ");
          }
          System.out.println("Song [id="+songs.get(i).getId()+"]]"); 
        }
    
}
