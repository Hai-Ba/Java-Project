package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	private ArrayList<String> contentTokens = new ArrayList<String>();
	private HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();

	public Book(String title, String catergory, float cost, int id) {//Construct
		super(title,catergory,cost,id);
	}
	
	public Book(String title, float cost) {
		super(title, cost);
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int processContent() {
		StringTokenizer st = new StringTokenizer(content," ");
		int countToken = st.countTokens();
		while(st.hasMoreTokens()) {
			contentTokens.add(st.nextToken());
		}
		Collections.sort(contentTokens);
		//init Map
		for(String i : contentTokens) {
			wordFreq.put(i, 0);
		}
		for(String i : contentTokens) {
			for(String j : wordFreq.keySet()) {
				if(i.equals(j)) {
					Integer tmp = wordFreq.get(j) + 1;
					wordFreq.replace(j, wordFreq.get(j), tmp);
				}
			}
		}
		return countToken;
	}
	
	public String myToString() {
		return "Book: " + title + "_" + catergory + "_" + cost + "\nCOntent length: " + processContent() + "\nTokenList: "
				+ contentTokens.toString() + "\nWordFrequency: " + wordFreq.toString();
	}

	public void addAuthor(String authorName) {
		boolean isFound = false;
		for(String i : authors) {
			if(i.equalsIgnoreCase(authorName)) {
				isFound = true;
				break;
			}
		}
		if(!isFound) {
			authors.add(authorName);
			System.out.println("Add author successfully!!!");
			return;
		}
		System.out.println("The author name has exist! Cannot add!!!");
	}
	
	
	public void removeAuthor(String authorName) {
		if(authors.size() == 0) {
			System.out.println("No element!!!");
			return;
		}
		for(int i = 0; i < authors.size(); i++) {
			if(authors.get(i).equalsIgnoreCase(authorName)) {
				authors.remove(i);
				System.out.println("Remove author successfully!!!");
				break;
			}
		}
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
	
	
}
