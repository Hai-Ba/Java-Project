package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.StringTokenizer;

public class Media {

	protected int id;
	protected String title;
	protected String catergory;
	protected float cost;
	protected LocalDate dateAdded = LocalDate.now();//init local date
	protected static int nbID = 0; //manage ID of MEdia object
	
	public int getId() {
		return id;
	}
	
	public static int updatenbID() {
		nbID = nbID + 1;
		return nbID;
	}
	public String getTitle() {
		return title;
	}
	
	public String getCatergory() {
		return catergory;
	}
	
	public float getCost() {
		return cost;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	
	public Media() {
		//Empty constructor to use super()
	}
	
	public Media(String title, String catergory, float cost, int id) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.catergory = catergory;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		this.id = id;
	}
	public Media(String title, float cost) {
		this.title = title;
		this.cost = cost;
	}

	public boolean isMatch(String title) {
		boolean isFound = false;
		if(title.equalsIgnoreCase(this.title)) {
			return true;
		}
		StringTokenizer st = new StringTokenizer(title," ");
		int countToken;
		countToken = st.countTokens();
		while(countToken > 0) {
			StringTokenizer st2 = new StringTokenizer(this.title," ");
			String tmp = st.nextToken();
			while(st2.hasMoreTokens()) {
				if(tmp.equalsIgnoreCase(st2.nextToken())) {
					isFound = true;
				}
			}
			countToken--;
		}
		return isFound;
	}
	
	
	
	public int compareTo(Media obj) {
		String str1 = this.getTitle();
		String str2 = obj.getTitle();
		if(str1.length() < str2.length()) {
			return -1;
		} else if(str1.length() > str2.length()) {
			return 1;
		} else {
			if(str1.equals(str2)) {
				str1 = this.getCatergory();
				str2 = obj.getCatergory();
				if(str1.length() < str2.length()) {
					return -1;
				} else if(str1.length() > str2.length()) {
					return 1;
				} else {
					if(str1.equals(str2)) {
						return 0;
					} else {
						for(int i = 0; i < str1.length(); i++) {
							if(str1.charAt(i) < str2.charAt(i)) {
								return -1;
							} else if(str1.charAt(i) > str2.charAt(i)) {
								return 1;
							}
						}
						return 0;
					}
				}
			} else {
				for(int i = 0; i < str1.length(); i++) {
					if(str1.charAt(i) < str2.charAt(i)) {
						return -1;
					} else if(str1.charAt(i) > str2.charAt(i)) {
						return 1;
					}
				}
				return 0;
			}
		}
	}
		
}
