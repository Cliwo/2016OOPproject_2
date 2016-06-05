package ChanComponents;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import public_components.ChanAnchorPoint;
import public_components.ChanSprite;

public final class SPRITE_BASIC_KEYBOARD_LISTENER implements KeyListener {

	ChanSprite obj;
	boolean isDoingAction;
	int direction;

	Thread onGoing;

	public static final int DIR_RIGHT = 0;
	public static final int DIR_LEFT = 1;

	public SPRITE_BASIC_KEYBOARD_LISTENER(ChanSprite obj) {
		super();
		this.obj = obj;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (!isDoingAction) {
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
						if (direction == DIR_RIGHT) {
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos + 2, obj
										.getAnchorPoint().yPos - 6));
								//System.out.println("JUMPING : Up , Right");
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos + 2, obj
										.getAnchorPoint().yPos + 6));
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
										.getAnchorPoint().xPos - 2, obj
										.getAnchorPoint().yPos - 6));
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(new ChanAnchorPoint(obj
										.getAnchorPoint().xPos - 2, obj
										.getAnchorPoint().yPos + 6));
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
							stopped = false;
							direction = DIR_RIGHT;
							while (true) {
								if (!isDoingAction && !stopped) {
									obj.setAnchorPoint(new ChanAnchorPoint(obj
											.getAnchorPoint().xPos + 3, obj
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
							stopped = false;
							direction = DIR_LEFT;
							while (true) {
								if (!isDoingAction && !stopped) {
									obj.setAnchorPoint(new ChanAnchorPoint(obj
											.getAnchorPoint().xPos - 3, obj
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
			System.out.println("KeyReleased : Right");
			onGoing.interrupt();
			onGoing = null;
			
			//interrupt 시 부 자연스러운 액션이 일어남, 이 부분 마리오가 브레이크 밟게 설정하면 어떨까
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("KeyReleased : Left");
			onGoing.interrupt();
			onGoing = null;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
