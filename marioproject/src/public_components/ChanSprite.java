package public_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;





import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public abstract class ChanSprite extends JComponent{
	
	public static ArrayList<ChanSprite> spriteList= new ArrayList<ChanSprite>();
	
	private int myId;
	private ChanAnchorPoint anchorPoint;
	private Image image; //image=new ImageIcon(스트링값).getImage();
	private Color tintColor;
	private Dimension hitBox;
	private JFrame frame;
	
	public ChanSprite(ChanAnchorPoint anchorPoint, String imageName, JFrame frame)
	{	

		final ImageIcon imageIcon = new ImageIcon(imageName);
		
		this.myId = spriteList.size(); //내가 갖게될 index
		this.anchorPoint = anchorPoint;
		this.image = imageIcon.getImage();
		if(image == null)
			System.out.println("Image Error");
		this.hitBox = new Dimension(image.getWidth(imageIcon.getImageObserver()), image.getHeight(imageIcon.getImageObserver()));
		this.frame=frame;		
		setBounds(0, 0, 800, 800);
		
		System.out.println(getClass().toString() + " Size : "+hitBox.width+" "+hitBox.height + ", Point : "+anchorPoint.xPos + " " + anchorPoint.yPos);
		//System.out.println("Preffered Size : "+getPreferredSize().width+ " "+ getPreferredSize().height);
		spriteList.add(this);
	}
	
	
	
	public Dimension getHitBox() {
		return hitBox;
	}


	public void checkCollide()
	{
		for(ChanSprite s:spriteList)
		{
			if(isOverLaped(s)&& s!=this) // 나와 해당 s 가 겹치는 가?
			{
				collided(s); //그렇다면 양쪽의 collided함수를 부른다.
				s.collided(this); 
				//System.out.println("Colide called : "+ getClass().toString() +" "+s.getClass().toString());;
			}
		}
	}
	
	public abstract void collided(ChanSprite s);
	

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		if(tintColor!=null)
			arg0.setColor(tintColor);
		//제대로 작동 되는지 나중에 확인
		arg0.drawImage(image, anchorPoint.xPos, anchorPoint.yPos, this);
		//frame.getContentPane().setBounds(0,0,200,200);
		//System.out.printf("New Sprite paint : %d %d %d %d\n", anchorPoint.xPos,  anchorPoint.yPos, getSize().width, getSize().height);
	}
	
	
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return super.getPreferredSize();
	}




	public boolean valueInRange(int value, int min, int max)
	{ 
		return (value >= min) && (value <= max); 
	}
	
	public static boolean isOverLaped(ChanSprite sp1, ChanSprite sp2)
	{
		return sp1.isOverLaped(sp2);
	}
	
	public boolean isOverLaped(ChanSprite compare)
	{
		return isOverLaped(getHitBox(), getAnchorPoint(), compare.getHitBox(), compare.getAnchorPoint() );
	}
	
	public boolean isOverLaped(Dimension s1 , ChanAnchorPoint a1, Dimension s2 , ChanAnchorPoint a2)
	{
		/*Point o1LeftUp = new Point(a1);
		Point o1LeftDown = new Point(a1.xPos, a1.yPos+s1.height);
		Point o1RightUp = new Point(a1.xPos + s1.width , a1.yPos);
		Point o1RightDown = new Point(a1.xPos+s1.width, a1.yPos+s1.height);
		
		Point o2LeftUp = new Point(a2);
		Point o2LeftDown = new Point(a2.xPos, a2.yPos+s2.height);
		Point o2RightUp = new Point(a2.xPos + s2.width , a2.yPos);
		Point o2RightDown = new Point(a2.xPos+s2.width, a2.yPos+s2.height);*/
		
		boolean xOverlap = valueInRange(a1.xPos, a2.xPos, a2.xPos + s2.width) ||
                valueInRange(a2.xPos, a1.xPos, a1.xPos + s1.width);

		boolean yOverlap = valueInRange(a1.yPos, a2.yPos, a2.yPos + s2.height) ||
                valueInRange(a2.yPos, a1.yPos, a1.yPos + s1.height);
		return xOverlap && yOverlap;
	}

	public int getMyId() {
		return myId;
	}

	
	public JFrame getFrame() {
		return frame;
	}
	
	public ChanAnchorPoint getAnchorPoint() {
		return anchorPoint;
	}


	public void setAnchorPoint(ChanAnchorPoint anchorPoint) {
		this.anchorPoint = anchorPoint;
		//setBounds(anchorPoint.xPos, anchorPoint.yPos, getSize().width, getSize().height);
		frame.repaint();
		//frame.getContentPane().repaint();
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public Color getTintColor() {
		return tintColor;
	}


	public void setTintColor(Color tintColor) {
		this.tintColor = tintColor;
	}







	
}
