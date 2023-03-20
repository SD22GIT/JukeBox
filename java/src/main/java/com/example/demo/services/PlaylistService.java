package com.example.demo.services;

import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.utility.SongsLinkedList;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import java.lang.RuntimeException;

public class PlaylistService {

    private final IPlaylistRepository playlistRepository;
    private SongService songService;
    private Playlist currentPlaylist;

    public PlaylistService(IPlaylistRepository playlistRepository,SongService songService)
    {
        this.playlistRepository =  playlistRepository;
        this.songService = songService;
    }

    public Playlist createPlayList(String playlistName,List<Integer> songIds)
    {
        SongsLinkedList songs=new SongsLinkedList();
        for(Integer songId:songIds)
        {
            songs.addSong(songService.getSong(songId));
        }

        Playlist playlist = new Playlist(playlistName, songs);
        playlistRepository.addPlayList(playlist);
        return playlist;
    }

    public Playlist addSongToPlaylist(String playlistName,int songId)
    {
        Playlist playlist =  playlistRepository.getPlaylistByName(playlistName);
        Song song = songService.getSong(songId);
        playlist.addSong(song);
        return playlist;
    }

    public Playlist deleteSongFromPlaylist(String playlistName,int songId)
    {
        Playlist playlist =  playlistRepository.getPlaylistByName(playlistName);
        Song song = songService.getSong(songId);
        playlist.deleteSong(song);
        return playlist;
    }

    public void deletePlaylist(String playlistName)
    {
        Playlist playlist = playlistRepository.getPlaylistByName(playlistName);
        playlistRepository.deletePlaylist(playlist.getId());
    }

    public String loadPlaylist(String playlistName)
    {
        Playlist playlist = playlistRepository.getPlaylistByName(playlistName);
        if(playlist==null)
        {
            throw new RuntimeException("No Playlist by this name exists");
        }

        currentPlaylist = playlist;
        return currentPlaylist.getName();
    }

    public String[] playSong()
    {
       Song song = currentPlaylist.getCurrentSong();
       String arr[] = new String[2];
       if(song==null)
       {
        currentPlaylist.setCurrentSong();
        Integer id = currentPlaylist.getCurrentSong().getId();
        arr[0]=id.toString();
        arr[1]="playing";
       }
       else
       {
        Integer id = currentPlaylist.getCurrentSong().getId();
        arr[0]=id.toString();
        arr[1]="paused";
       }
       return arr;
    }

    public Song nextSong()
    {
        SongsLinkedList songs = currentPlaylist.getSongsPlayList();
        
        return songs.getNext();
        
    }

    public Song previousSong()
    {
        SongsLinkedList songs = currentPlaylist.getSongsPlayList();
      
        return songs.getPrevious();
    }


    public Song stopSong()
    {
       Song song = currentPlaylist.getCurrentSong();
       currentPlaylist.getSongsPlayList().removeCurrent();
       return song; 
    }

}
