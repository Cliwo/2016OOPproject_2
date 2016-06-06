package ChanComponents;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import public_components.ChanAnchorPoint;
import public_components.ChanSprite;

public final class SPRITE_BASIC_KEYBOARD_LISTENER implements KeyListener {

	ChanSprite obj;
	boolean isDoingAction;
	int direction;

	public Thread onGoing;
	

	public static final int DIR_RIGHT = 0;
	public static final int DIR_LEFT = 1;

	public static final int UP_AND_DOWN_SPEED = 6;
	public static final int JUMP_HORIZONTAL = 2;
	public static final int RIGHT_LEFT_GROUND = 3;
	
	public static final int BOUNCE_UP_AND_DOWN = 2;
	public static final int BOUNCE_HORIZONTAL = 1;
	public SPRITE_BASIC_KEYBOARD_LISTENER(ChanSprite obj) {
		super();
		this.obj = obj;
	}

	public void bounce()
	{
		if(onGoing!=null)
			onGoing.interrupt();
		onGoing = null;
		onGoing = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				isDoingAction = true;
				if (direction == DIR_LEFT) { /* Go Up */
					for (int i = 0; i < 5 ; i++) {
						obj.setAnchorPoint(new ChanAnchorPoint(obj
								.getAnchorPoint().xPos + BOUNCE_HORIZONTAL, obj
								.getAnchorPoint().yPos - BOUNCE_UP_AND_DOWN));
						obj.checkCollide();
						//System.out.println("JUMPING : Up , Right");
						try {
							sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 5 ; i++) { /* Go Down */
						obj.setAnchorPoint(new ChanAnchorPoint(obj
								.getAnchorPoint().xPos + BOUNCE_HORIZONTAL, obj
								.getAnchorPoint().yPos + BOUNCE_UP_AND_DOWN));
						obj.checkCollide();
						//System.out.println("JUMPING : Down , Right");
						try {
							sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					for (int i = 0; i < 5; i++) {
						obj.setAnchorPoint(new ChanAnchorPoint(obj
								.getAnchorPoint().xPos - BOUNCE_HORIZONTAL, obj
								.getAnchorPoint().yPos - BOUNCE_UP_AND_DOWN));
						obj.checkCollide();
						try {
							sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 5; i++) {
						obj.setAnchorPoint(new ChanAnchorPoint(obj
								.getAnchorPoint().xPos - BOUNCE_HORIZONTAL, obj
								.getAnchorPoint().yPos + BOUNCE_UP_AND_DOWN));
						obj.checkCollide();
						
						try {
							sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				isDoingAction = false;
			}
			
		};
		onGoing.start();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (!isDoingAction) {
			obj.checkCollide();
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:

				break;

			case KeyEvent.VK_DOWN:

				break;

			case KeyEvent.VK_SPACE:
				new Thread() {
					@Override
					public void run() {
						super.run();
						isDoingAction = true;
						if (direction == DIR_RIGHT) { /* Go Up */
							for (int i = 0; i < 15 ; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos + JUMP_HORIZONTAL, obj
										.getAnchorPoint().yPos - UP_AND_DOWN_SPEED));
								obj.checkCollide();
								//System.out.println("JUMPING : Up , Right");
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							for (int i = 0; i < 15 ; i++) { /* Go Down */
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos + JUMP_HORIZONTAL, obj
										.getAnchorPoint().yPos + UP_AND_DOWN_SPEED));
								obj.checkCollide();
								//System.out.println("JUMPING : Down , Right");
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} else {
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos - JUMP_HORIZONTAL, obj
										.getAnchorPoint().yPos - UP_AND_DOWN_SPEED));
								obj.checkCollide();
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos - JUMP_HORIZONTAL, obj
										.getAnchorPoint().yPos + UP_AND_DOWN_SPEED));
								obj.checkCollide();
								
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						isDoingAction = false;
					}

				}.start();

				break;

			case KeyEvent.VK_RIGHT:
				if (onGoing == null) {
					onGoing = new Thread() {
						boolean stopped;
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							super.run();
							obj.setImage(new ImageIcon("right.png").getImage());
							stopped = false;
							direction = DIR_RIGHT;
							while (true) {
								if (!isDoingAction && !stopped) {
									obj.setAnchorPoint(new ChanAnchorPoint(obj
											.getAnchorPoint().xPos + RIGHT_LEFT_GROUND, obj
											.getAnchorPoint().yPos));
									//System.out.println("KeyPressed : Right");
								}
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									stopped = true;
									//e.printStackTrace();
								}
							}
						}

					};
					onGoing.start();
				}
				break;

			case KeyEvent.VK_LEFT:
				if (onGoing == null) {
					onGoing = new Thread() {
						boolean stopped;

						@Override
						public void run() {
							// TODO Auto-generated method stub
							super.run();
							obj.setImage(new ImageIcon("left.png").getImage());
							stopped = false;
							direction = DIR_LEFT;
							while (true) {
								if (!isDoingAction && !stopped) {
									obj.setAnchorPoint(new ChanAnchorPoint(obj
											.getAnchorPoint().xPos - RIGHT_LEFT_GROUND, obj
											.getAnchorPoint().yPos));
									//System.out.println("KeyPressed : Left");
								}
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									stopped = true;
									//e.printStackTrace();
								}
							}

						}
					};
					onGoing.start();
				}
				break;
			}

			obj.getFrame().repaint();
			// obj.getFrame().update(obj); 방식 알아보기
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			//System.out.println("KeyReleased : Right");
			if(onGoing!=null)
				onGoing.interrupt();
			onGoing = null;
			
			//interrupt 시 부 자연스러운 액션이 일어남, 이 부분 마리오가 브레이크 밟게 설정하면 어떨까
			break;

		case KeyEvent.VK_LEFT:
			//System.out.println("KeyReleased : Left");
			if(onGoing!=null)
				onGoing.interrupt();
			onGoing = null;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public boolean isDoingAction() {
		return isDoingAction;
	}

	public void setDoingAction(boolean isDoingAction) {
		this.isDoingAction = isDoingAction;
	}
	
	

}
