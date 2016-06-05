package public_components;

public class Point {
	
	int xPos;
	int yPos;
	
	public Point(Point p1)
	{
		this.xPos = p1.xPos;
		this.yPos = p1.yPos;
	}
	public Point(int xPos, int yPos)
	{
		this.xPos =xPos;
		this.yPos =yPos;
	}
	public Point(ChanAnchorPoint p1)
	{
		this.xPos =p1.xPos;
		this.yPos = p1.yPos;
	}
	
}
