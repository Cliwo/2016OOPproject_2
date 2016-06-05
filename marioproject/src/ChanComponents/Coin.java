package ChanComponents;

import javax.swing.JFrame;

import public_components.ChanAnchorPoint;
import public_components.ChanSprite;

public class Coin extends ChanSprite{

	
	public Coin(ChanAnchorPoint anchorPoint, String imageName, JFrame frame) {
		super(anchorPoint, imageName, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collided(ChanSprite s) {
		// TODO Auto-generated method stub
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
