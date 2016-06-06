package ChanComponents;

import java.awt.Graphics;

import javax.swing.JFrame;

import public_components.ChanAnchorPoint;
import public_components.ChanSprite;

public class Mario extends ChanSprite{

	public static final int STATE_GROUND = 0;
	public static final int STATE_INAIR = 1;
	public static final int STATE_WALL = 2;
	
	private int CURRENT_STATE;
	
	public Mario(ChanAnchorPoint anchorPoint, String imageName, JFrame frame) {
		super(anchorPoint, imageName, frame);
		// TODO Auto-generated constructor stub
		CURRENT_STATE = STATE_GROUND;
	}	
	
	public int getState()
	{
		return CURRENT_STATE;
	}
	
	public void setState(int state)
	{
		CURRENT_STATE=state;
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);;
	}


	public void collided(ChanSprite s) {
		if(s instanceof Mario)
		{
			
		}
		else if(s instanceof Pipe)
		{
			
		}
		else if (s instanceof Coin)
		{
			
		}
	}
	

	
}
