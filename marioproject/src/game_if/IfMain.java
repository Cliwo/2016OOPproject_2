package game_if;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class IfMain {
	/*JFrame mainFrame; 
	JPanel jPanel;	  */
	JFrame mainFrame;
	JPanel basicPanel;
	// Main���� �־ �߿��� (?) �����۵��� field�� ���°� ���� �������� �������ϱ� 2016_06_04
	
	
	public static void main(String [] args) //main�� �ִ��� �����ϰ� 2016_06_04
	{
		IfMain game_if = new IfMain();
		game_if.startMain();	
	}
	
	public IfMain() {
		mainFrame = new JFrame();
		basicPanel = new JPanel();	
		
		setJComponents(); //���⼭ �ٸ� ��� JCompoentes�� ������ ����
						  //���߿� Pipe�� �߰��ϰų�, �� �ٸ� ������ �߻��ϸ�, �� �Լ��� ���� �Ǵ°��� 2016_06_04
	}
	
	public void startMain()
	{
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(basicPanel);
		mainFrame.setSize(1000,1000);
		mainFrame.setVisible(true);
	}
	
	public void setJComponents()
	{
		IfSprite spr = new IfSprite(new IfPosition(100,385), "mario.jpg", new IfSize(600,500),mainFrame);
		IfSprite coinbox = new IfSprite(new IfPosition(190,265), "box2.png",new IfSize(600,500),mainFrame);
		IfSprite background = new IfSprite(new IfPosition(0, 0), "dummyback.jpg", new IfSize(600,600),mainFrame);
		IfSprite pipe = new IfSprite(new IfPosition(450,407),"������.png",new IfSize(600,600),mainFrame);
		IfSprite nocoinbox = new IfSprite(new IfPosition(190,265), "nobox.png",new IfSize(600,500),mainFrame);
		IfSprite mush = new IfSprite(new IfPosition(190,265), "coin.png",new IfSize(600,500),mainFrame);
		
		basicPanel.setLayout(null);
		
		basicPanel.add(spr);
		basicPanel.add(coinbox);
		basicPanel.add(background);
		basicPanel.add(pipe);
		basicPanel.add(nocoinbox);
		basicPanel.add(mush);
	
		
		mainFrame.addKeyListener(new IfKeyListener(spr,basicPanel,coinbox,mush));
	}
	
}
