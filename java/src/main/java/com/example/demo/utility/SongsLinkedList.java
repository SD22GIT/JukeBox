package com.example.demo.utility;

import com.example.demo.entities.Song;
import java.util.LinkedList;
import java.util.List;

public class SongsLinkedList
{
    private SongNode head;
	private SongNode tail;
	private SongNode currentNode;

	public SongsLinkedList() {
		this.head = null;
		this.tail = null;
		this.currentNode = null;
	}

	public void addSong(Song song) {

		SongNode songNode = new SongNode(song);
		if (this.head == null) {
			head = songNode;
			tail = songNode;
		} else {
			tail.setNext(songNode);
			songNode.setPrevious(tail);
			tail = songNode;
		}
	}

	public SongNode getFirst() {
		return this.head;
	}

	public SongNode getLast() {
		return this.tail;
	}

	public Song getCurrent() {
        if(this.currentNode!=null)
        {
		return this.currentNode.getSong();
        }
        return null;
	}

    public void setCurrent()
    {
        this.currentNode = this.head;
    }

    public void removeCurrent()
    {
        this.currentNode = null;
    }

    public Song getNext()
    {
        if(this.currentNode.getNext()!=null)
        {
            this.currentNode=  this.currentNode.getNext();
        }
        else
        {
            this.currentNode = this.head;
        }

        return this.currentNode.getSong();
    }

    public Song getPrevious()
    {
       if(this.currentNode.getPrevious()!=null)
       {
        this.currentNode =  this.currentNode.getPrevious();
       }
       else
       {
        this.currentNode = this.tail;
       }
       return this.currentNode.getSong();
    }

    public void addList(SongsLinkedList songs)
    {
        if(this.head==null)
        {
            this.head = songs.getFirst();
            this.tail = songs.getLast();
        }
        else
        {
        this.tail.setNext(songs.getFirst());
        songs.getFirst().setPrevious(this.tail);
        tail = songs.getLast();
        }
    }

    public void removeSong(Song song)
    {
        SongNode tempHead = this.head;
        while(tempHead!=null)
        {
            if(tempHead.getSong().getId()==song.getId())
            {
               if(tempHead==head)
               {
                head = head.getNext();
                tempHead = null;
               }
               else if(tempHead==tail)
               {
                tempHead =null;
               }
               else
               {
                tempHead.getPrevious().setNext(tempHead.getNext());
                tempHead.getNext().setPrevious(tempHead.getPrevious());
                tempHead=null;
               }
               break;
            }
            tempHead = tempHead.getNext();
        }
    }

    public List<Song> getAllSongs()
    { 
        List<Song> songs = new LinkedList<>();

        SongNode tempHead = this.head;
        while(tempHead!=null)
        {
            songs.add(tempHead.getSong());
            tempHead = tempHead.getNext();
        }

        return songs;
    }
}