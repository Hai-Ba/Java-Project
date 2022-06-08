package hust.soict.globalict.aims.cart.Cart;
//This class is used to work with class DigitalVideoDisc.java
//This class contain list of DigitalVideoDisc objects and methods to modify them

import java.util.*;

import hust.soict.globalict.aims.Aims.Aims;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store.Store;
public class Cart {
	//Create a constant indicate maximum number of items a person can buy
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private static int qtyOrdered = 0;
	
	private static ArrayList<DigitalVideoDisc> itemsDVD = new ArrayList<DigitalVideoDisc>();
	private static ArrayList<Book> itemsBook = new ArrayList<Book>();
	private static ArrayList<CompactDisc> itemsCPD = new ArrayList<CompactDisc>();
	public static ArrayList<Media> itemsInCart =  new ArrayList<Media>();
	private static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	//addMedia
	public static void addMedia(Media media) {
		if(media instanceof Book) {
			itemsInCart.add(media);
			itemsBook.add((Book)media);
			System.out.println("Book: "+ media.getTitle() + "_" + media.getCost() +"$");
		}else if(media instanceof CompactDisc) {
			itemsInCart.add(media);
			itemsCPD.add((CompactDisc)media);
			System.out.println("CD: "+ media.getTitle() + "_" + media.getCost() +"$");
		}else if(media instanceof DigitalVideoDisc){
			itemsInCart.add(media);
			itemsDVD.add((DigitalVideoDisc)media);
			System.out.println("DVD: "+ media.getTitle() + "_" + media.getCost() +"$");
		}
		qtyOrdered += 1;
	}
}
