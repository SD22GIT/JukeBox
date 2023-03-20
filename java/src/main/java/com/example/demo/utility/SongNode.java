package com.example.demo.utility;

import com.example.demo.entities.Song;

public class SongNode {

    private Song song;
	private SongNode next;
	private SongNode previous;

	public SongNode(Song song) {
		this.song = song;
		this.next = null;
		this.previous = null;
	}

	public SongNode getNext() {
		return this.next;
	}

	public void setNext(SongNode songNode) {
		this.next = songNode;
	}

	public void setPrevious(SongNode songNode) {
		this.previous = songNode;
	}
	
	public SongNode getPrevious()
	{
		return this.previous;
	}
	
	public Song getSong()
	{
		return this.song;
	}
    
}
