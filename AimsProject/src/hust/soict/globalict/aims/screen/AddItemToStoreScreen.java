package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AddItemToStoreScreen extends JFrame implements ActionListener{
	protected Container cp = getContentPane();
	protected JMenuItem addBook = new JMenuItem("Add Book");
	protected JMenuItem addCD = new JMenuItem("Add CD");
	protected JMenuItem addDVD = new JMenuItem("Add DVD");
	protected JMenuItem viewStore = new JMenuItem("View Store");
	protected JMenuItem viewCart = new JMenuItem("View Cart");
	public AddItemToStoreScreen() {
		
		setVisible(true);
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
	
}
