package game_if;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class IfMain {
	/*JFrame mainFrame; 
	JPanel jPanel;	  */
	JFrame mainFrame;
	JPanel basicPanel;
	// Main에게 있어서 중요한 (?) 아이템들은 field에 놓는게 좋아 가독성이 좋아지니까 2016_06_04
	
	
	public static void main(String [] args) //main은 최대한 간결하게 2016_06_04
	{
		IfMain game_if = new IfMain();
		game_if.startMain();	
	}
	
	public IfMain() {
		mainFrame = new JFrame();
		basicPanel = new JPanel();	
		
		setJComponents(); //여기서 다른 모든 JCompoentes의 설정을 진행
						  //나중에 Pipe를 추가하거나, 뭐 다른 오류가 발생하면, 이 함수만 보면 되는거임 2016_06_04
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
		IfSprite pipe = new IfSprite(new IfPosition(450,407),"파이프.png",new IfSize(600,600),mainFrame);
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
