package ChanComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

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
		panel.setLayout(null);
		
		Mario mario = new Mario(new ChanAnchorPoint(200,200), "mario.jpg",mainFrame);
		
		panel.add(new JButton("hi"));
		mario.setVisible(true);
		panel.add(mario);
		panel.setSize(600,600);
		panel.setLayout(null);
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		mainFrame.setContentPane(panel);
		//mainFrame.getContentPane().add(mario);
		
		mainFrame.setSize(1000,1000);
		mainFrame.setVisible(true);
		mainFrame.addKeyListener(new SPRITE_BASIC_KEYBOARD_LISTENER(mario));
		
		
	}

}
