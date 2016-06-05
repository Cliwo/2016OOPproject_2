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
	private ChanSize size;
	private Image image; //image=new ImageIcon(��Ʈ����).getImage();
	private Color tintColor;

	private JFrame frame;
	
	public ChanSprite(ChanAnchorPoint anchorPoint, String imageName, JFrame frame)
	{	
		size = new ChanSize();
		final ImageIcon imageIcon = new ImageIcon(imageName);
		
		this.myId = spriteList.size(); //���� ���Ե� index
		this.anchorPoint = anchorPoint;
		this.image = imageIcon.getImage();
		if(image == null)
			System.out.println("Image Error");
		this.size.width = image.getWidth(imageIcon.getImageObserver()); //�������� null�� ��ü
		this.size.height = image.getHeight(imageIcon.getImageObserver());
		this.frame=frame;
			
		System.out.println("Size : "+size.width +" "+size.height);
		spriteList.add(this);
	}
	
	
	
	void checkColide()
	{
		for(ChanSprite s:spriteList)
		{
			if(isOverLaped(s)) // ���� �ش� s �� ��ġ�� ��?
			{
				collided(s); //�׷��ٸ� ������ collided�Լ��� �θ���.
				s.collided(this); 
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
		//����� �۵� �Ǵ��� ���߿� Ȯ��
		arg0.drawImage(image, anchorPoint.xPos, anchorPoint.yPos, this);	
		System.out.printf("New Sprite paint : %d %d %d %d\n", anchorPoint.xPos,  anchorPoint.yPos, size.width, size.height);
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
		return isOverLaped(getSize_(), getAnchorPoint(), compare.getSize_(), compare.getAnchorPoint() );
	}
	
	public boolean isOverLaped(ChanSize s1 , ChanAnchorPoint a1, ChanSize s2 , ChanAnchorPoint a2)
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

	public ChanSize getSize_() {
		return size;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public ChanAnchorPoint getAnchorPoint() {
		return anchorPoint;
	}


	public void setAnchorPoint(ChanAnchorPoint anchorPoint) {
		this.anchorPoint = anchorPoint;
		frame.repaint();
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
