package hust.soict.globalict.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private String director;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	private static CompactDisc CPD = new CompactDisc();
	
	public String getArtist() {
		return artist;
	}
	
	
	public CompactDisc(String title, String artist, String director, float cost, int id) {
		this.title = title;
		this.artist = artist;
		this.director = director;
		this.cost = cost;
		this.id = id;
	}
	
	public CompactDisc(String title, float cost) {
		this.title = title;
		this.cost = cost;
	}


	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTrack(Track track) {
		for(Track i : this.tracks) {//check if track is exist
			if(i.getTitle().equalsIgnoreCase(track.getTitle())) {
				System.out.println("Track '" + track.getTitle() + "' Already exist");
				return;
			}
		}
		this.tracks.add(track);
		System.out.println("Add track '" + track.getTitle() + "' Successfully");
	}
	
	public void removeTrack(String title) {
		if(this.tracks.size() <= 0) {
			System.out.println("There is no track in this CDs");
		} else {
			boolean isFound = false;
			for(Track i : this.tracks) {
				if(i.getTitle().equalsIgnoreCase(title)) {
					this.tracks.remove(i);
					isFound = true;
					System.out.println("Remove '"+ title + "' Successfully!");
				}
			}
			if(!isFound) {
				System.out.println("No match found!!!");
			}
		}
	}
	
	public int getLength() {
		int lengthTotal = 0;
		for(Track i : CPD.tracks) {
			lengthTotal += i.getLength();
		}
		this.length = lengthTotal;
		return lengthTotal;
	}
	
	public void play() {
		for(Track i : this.tracks) {
			i.play();
		}
	}
}
