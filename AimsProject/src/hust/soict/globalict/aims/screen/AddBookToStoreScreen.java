package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	Container cp = getContentPane();
	JTextField title = new JTextField(10);
	JTextField catergory = new JTextField(10);
	JTextField cost = new JTextField(10);
	public AddBookToStoreScreen() {
		setTitle("Book Input");
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2, 2, 2));//Set layout gom 3 hang va 2 cot
		center.add(new JLabel("Input title"));
		center.add(title);
		center.add(new JLabel("Input catergory"));
		center.add(catergory);
		center.add(new JLabel("Input cost"));
		center.add(cost);
		
		title.addActionListener(this);
		cost.addActionListener(this);
		
		return center;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		String titleInput = title.getText();;
		float costInput = Float.parseFloat(cost.getText());
		Book tmpBook = new Book(titleInput, costInput);
		Store.itemsInStore.add(tmpBook);
		Store.qtyStore += 1;
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
	    }
	}
	
}
