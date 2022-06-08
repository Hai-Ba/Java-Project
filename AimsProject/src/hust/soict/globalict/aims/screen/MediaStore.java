package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.Cart.*;

public class MediaStore extends JPanel implements ActionListener{
	private Media media;
	JButton playButton = new JButton("Play");
	JButton addToCart = new JButton("Add to cart");
	boolean isDVD = true;
	public MediaStore(Media media) {
		String book = "Book: ";
		String CD = "CD: ";
		String DVD = "DVD: ";
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel();
		if(media instanceof Book) {
			title = new JLabel(book + media.getTitle());
		} else if(media instanceof CompactDisc) {
			title = new JLabel(CD + media.getTitle());
		} else if(media instanceof DigitalVideoDisc) {
			title = new JLabel(DVD + media.getTitle());
		}
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(media.getCost()+"$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(addToCart);
		if(media instanceof hust.soict.globalict.aims.media.Playable) {
			container.add(playButton);
			if(media  instanceof CompactDisc) {
				isDVD = false;
			}
		}
		addToCart.addActionListener(this);
		playButton.addActionListener(this);
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == playButton) {
			JDialog dialog = new JDialog(); 
			dialog.setTitle("Playing"); 
			JLabel isRunning;
			if(isDVD) {
				isRunning = new JLabel("DVD is Playing...");
			} else {
				isRunning = new JLabel("CD is Playing...");
			}
			dialog.add(isRunning);
			dialog.setVisible(true); 
			dialog.setSize(300,300);
			dialog.setLocation(200, 200);
		}else if(event.getSource() == addToCart) {
			JDialog dialog = new JDialog();
			String str = "";
			if(media instanceof Book) {
				str = " book ";
				Cart.addMedia(media);
			} else if(media instanceof CompactDisc) {
				str = " CD ";
				Cart.addMedia(media);
			} else if(media instanceof DigitalVideoDisc) {
				str = " DVD ";
				Cart.addMedia(media);
			}
			dialog.setTitle("Status"); 
			JLabel isRunning = new JLabel("Add" + str + "to cart successfully!");
			dialog.add(isRunning);
			dialog.setVisible(true); 
			dialog.setSize(300,300);
			dialog.setLocation(200, 200);
		}
	} 
}

