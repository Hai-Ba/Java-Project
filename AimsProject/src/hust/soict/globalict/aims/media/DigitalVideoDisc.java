package hust.soict.globalict.aims.media;
//class stores the title, category, cost, director and length
import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<DigitalVideoDisc>{
	private String director;
	private int length;
	private LocalDate dateAdded = LocalDate.now();//init local date
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	//Getter and Setter methos to access the private attributes.
	//Source/Generate Getter and Setter
	
	//Create Constructor by all attributes is used to add DVD
	public DigitalVideoDisc(String title, String catergory, String directory, int length, float cost, int id) {
		super();//Thua ke thuoc tinh cua class cha.
		this.title = title;
		this.catergory = catergory;
		this.director = directory;
		this.length = length;
		this.cost = cost;
		this.id = id;
	}
	
	public DigitalVideoDisc(String title, float cost) {
		this.title = title;
		this.cost = cost;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public int compareTo(DigitalVideoDisc dvd) {
		return 1;
	}
}
