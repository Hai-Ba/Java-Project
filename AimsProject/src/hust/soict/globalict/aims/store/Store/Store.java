package hust.soict.globalict.aims.store.Store;

//import hust.soict.globalict.aims.A;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.Cart.*;
import hust.soict.globalict.aims.Aims.*;
import java.util.*;


public class Store {
	public static ArrayList<DigitalVideoDisc> itemsDVDInStore = new ArrayList<DigitalVideoDisc>();
	public static ArrayList<Book> itemsBookInStore = new ArrayList<Book>();
	public static ArrayList<CompactDisc> itemsCPDInStore = new ArrayList<CompactDisc>();
	public static ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public static int qtyStore = 0;//store the number of item of DVD in store
	private static Scanner sc = new Scanner(System.in);
	
	
	public static ArrayList<Media> getItemsInStore() {//Get the array list
		return itemsInStore;
	}
	
	
}//end of class
