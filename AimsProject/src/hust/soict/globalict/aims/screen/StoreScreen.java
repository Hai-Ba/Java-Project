package hust.soict.globalict.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.store.Store.*;
import hust.soict.globalict.aims.media.*;

public class StoreScreen extends JFrame implements ActionListener{
	private Store store;
	JMenuItem addBook = new JMenuItem("Add Book");
	JMenuItem addCD = new JMenuItem("Add CD");
	JMenuItem addDVD = new JMenuItem("Add DVD");
	JMenuItem viewStore = new JMenuItem("View Store");
	JMenuItem viewCart = new JMenuItem("View Cart");
	Container cp = getContentPane();
	
	public StoreScreen() {
		cp.setLayout(new BorderLayout());
		
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	@Override
	public void actionPerformed(ActionEvent event){
	    if(event.getSource() == addBook) {
	    	AddBookToStoreScreen tmp = new AddBookToStoreScreen();
	    	setVisible(false);
	    }else if(event.getSource() == addCD) {
	    	AddCompactDiscToStoreScreen tmp = new AddCompactDiscToStoreScreen();
	    	setVisible(false);
	    }else if(event.getSource() == addDVD) {
	    	AddDigitalVideoDiscToStoreScreen tmp = new AddDigitalVideoDiscToStoreScreen();
	    	setVisible(false);
	    }else if(event.getSource() == viewStore) {
	    	StoreScreen tmp = new StoreScreen();
	    	setVisible(false);
	    }else if(event.getSource() == viewCart) {
	    	System.out.println("add ViewCart click");
	    	System.exit(0);
	    }else {
	    	System.exit(0);
	    }
	  }
	
	//Create menu bar and header in the NORTH position
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {//Create a menu bar consist of a menu 
		JMenu menu = new JMenu("Options");
		JMenu menuUpdateStore = new JMenu("Update Store");
		menuUpdateStore.add(addBook);
		menuUpdateStore.add(addCD);
		menuUpdateStore.add(addDVD);
		
		//addActionListener
		addBook.addActionListener(this);
		addCD.addActionListener(this);
		addDVD.addActionListener(this);
		
		menu.add(menuUpdateStore);
		menu.add(viewStore);
		menu.add(viewCart);
		
		viewStore.addActionListener(this);
		viewCart.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		return header;
		
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<hust.soict.globalict.aims.media.Media> mediaInStore = Store.getItemsInStore();
		for(int i = 0; i < Store.qtyStore; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	//Navigate to add item
	//DVD
	
}
