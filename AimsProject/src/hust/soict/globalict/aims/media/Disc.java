package hust.soict.globalict.aims.media;

import java.util.StringTokenizer;

public class Disc extends Media{
	protected int length;
	protected String title;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}

	public Disc(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	//isMatch
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
	
	public boolean equals(Object o) {
		Media tmp = (Media)o; //explicit
		if(this.getId() == tmp.getId()) {
			return true;
		}
		return false;
	}

}
