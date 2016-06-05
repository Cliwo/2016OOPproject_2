package game_if;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class IfSprite extends JComponent {
	
	private IfPosition anchorPoint;
	private Image image;
	private Color tintColor;

	private JFrame frame;
	

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		if(tintColor!=null)
			arg0.setColor(tintColor);
		//제대로 작동 되는지 나중에 확인
		arg0.drawImage(image, (int)anchorPoint.xPos, (int)anchorPoint.yPos, this);	
		System.out.println("Test");
	}
	

	public IfSprite(IfPosition anchorPoint, String imageDirectory, IfSize drawSize, JFrame context) {
		super();
		this.anchorPoint = anchorPoint;
		image=new ImageIcon(imageDirectory).getImage();
		if(image == null)
		{
			//오류 처리
		}
		this.frame=context;
		this.setSize((int)drawSize.width, (int)drawSize.height);
	}

	public IfPosition getAnchorPoint() {
		return anchorPoint;
	}

	public void setAnchorPoint(IfPosition anchorPoint) {
		this.anchorPoint = anchorPoint;
		frame.repaint();
	}
	
	public Color getTintColor() {
		return tintColor;
	}

	public void setTintColor(Color tintColor) {
		this.tintColor = tintColor;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	
	
}
