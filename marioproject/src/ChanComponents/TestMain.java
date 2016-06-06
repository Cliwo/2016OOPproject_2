package ChanComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import public_components.ChanAnchorPoint;
import public_components.ChanSprite;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mainFrame = new JFrame();

		JPanel panel = new JPanel();
		
		Mario mario = new Mario(new ChanAnchorPoint(10,550), "mario.jpg",mainFrame);
		Pipe pipe = new Pipe(new ChanAnchorPoint(400,490), "ÆÄÀÌÇÁ.png", mainFrame);
		Coin coin = new Coin(new ChanAnchorPoint(250, 470), "coin.png",mainFrame);
 		Indicator indicator = new Indicator(new ChanAnchorPoint(300, 300), "Indicator.jpg", mainFrame);
		
		panel.setLayout(null);
		panel.add(pipe);
		panel.add(mario);
		panel.add(coin);
		panel.add(indicator);
		panel.setVisible(true);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		mainFrame.getContentPane().add(panel);
		
		mainFrame.setSize(800,800);
		mainFrame.setVisible(true);
		mainFrame.addKeyListener(new SPRITE_BASIC_KEYBOARD_LISTENER(mario));
		
		mario.getListenerFromFrame();
	}

}
