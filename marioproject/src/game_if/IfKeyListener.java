package game_if;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public final class IfKeyListener implements KeyListener {

	IfSprite obj, coinbox, mush;
	boolean isDoingAction, mushchk = false;
	int direction;
	JPanel Jpanel = new JPanel();
	Thread onGoing;

	public static final int DIR_RIGHT = 0;
	public static final int DIR_LEFT = 1;
	public static final int DIR_STOP = 2;

	public IfKeyListener(IfSprite obj, JPanel jpanel, IfSprite coinbox, IfSprite mush) {
		super();
		Jpanel = jpanel;
		this.coinbox = coinbox;
		this.mush = mush;
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
			{
				if (obj.getAnchorPoint().xPos >= 450 && obj.getAnchorPoint().xPos <= 470)
				{
					new Thread() {
						@Override
						public void run() {
							for (int j = 0; j < 60; j++) {
								obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos,
										obj.getAnchorPoint().yPos + 2));
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated
									// catch
									// block
									e.printStackTrace();
								}
							}
						}
					}.start();
				}
				break;
			}
			case KeyEvent.VK_SPACE:
				new Thread() {
					@Override
					public void run() {
						super.run();
						isDoingAction = true;
						if (direction == DIR_RIGHT) {
							for (int i = 0; i < 15; i++) {
								if (obj.getAnchorPoint().xPos >= 150 && obj.getAnchorPoint().xPos <= 210
										&& obj.getAnchorPoint().yPos <= 305) {
									Jpanel.remove(coinbox);
									System.out.println("�����");
									if (!mushchk) { // ������(����)�� ������ �޼ҵ�
										System.out.println("RIGHT SPACE : mushchk");
										new Thread() {
											@Override
											public void run() {
												mushchk = true;
												for (int j = 0; j < 30; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos,
															mush.getAnchorPoint().yPos - 1));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 15; j++)
												{
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 2,
															mush.getAnchorPoint().yPos));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 6; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 3,
															mush.getAnchorPoint().yPos+8));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 25; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 2,
															mush.getAnchorPoint().yPos + 6));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
											}
										}.start();
									}
								}
								if (obj.getAnchorPoint().xPos >= 408 && obj.getAnchorPoint().xPos <= 415
										&& obj.getAnchorPoint().yPos >= 350 && obj.getAnchorPoint().yPos <= 385) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos - 6));
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos + 2,
											obj.getAnchorPoint().yPos - 6));
									System.out.println("-6�� �ö�");
									System.out.println("JUMPING : Up , Right");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							for (int i = 0; i < 15; i++) {
								if (obj.getAnchorPoint().xPos >= 420 && obj.getAnchorPoint().xPos <= 440
										&& obj.getAnchorPoint().yPos >= 320 && obj.getAnchorPoint().yPos <= 350) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 1));
									System.out.println("+1��");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos + 2,
											obj.getAnchorPoint().yPos + 6));
									System.out.println("JUMPING : Down , Right");
									System.out.println("�������پ�");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if ((obj.getAnchorPoint().xPos <= 420 || obj.getAnchorPoint().xPos >= 520)
									&& obj.getAnchorPoint().yPos <= 385) {
								while (obj.getAnchorPoint().yPos != 385) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 5));
									System.out.println("+3��");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						} else if (direction == DIR_LEFT) {
							for (int i = 0; i < 15; i++) {
								if (obj.getAnchorPoint().xPos >= 150 && obj.getAnchorPoint().xPos <= 210
										&& obj.getAnchorPoint().yPos <= 305) {
									Jpanel.remove(coinbox);
									System.out.println("�����");
									if (!mushchk) {
										new Thread() {
											@Override
											public void run() {
												mushchk = true;
												for (int j = 0; j < 15; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos,
															mush.getAnchorPoint().yPos - 2));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 10; j++)
												{
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 3,
															mush.getAnchorPoint().yPos));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 6; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 3,
															mush.getAnchorPoint().yPos+8));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 25; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 2,
															mush.getAnchorPoint().yPos + 6));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
											}
										}.start();
									}
								}
								if (obj.getAnchorPoint().xPos <= 30) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos - 6));
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos - 2,
											obj.getAnchorPoint().yPos - 6));
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							for (int i = 0; i < 15; i++) {
								if (obj.getAnchorPoint().xPos <= 20) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 6));
									System.out.println("JUMPING : Left , Stop");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else if (obj.getAnchorPoint().xPos >= 450 && obj.getAnchorPoint().xPos <= 480
										&& obj.getAnchorPoint().yPos >= 320 && obj.getAnchorPoint().yPos <= 350) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 1));
									System.out.println("+JUMPING LEFT : +1��");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos - 2,
											obj.getAnchorPoint().yPos + 6));
									System.out.println("+JUMPING LEFT : +6��");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
							if ((obj.getAnchorPoint().xPos <= 420 || obj.getAnchorPoint().xPos >= 520)
									&& obj.getAnchorPoint().yPos <= 385) {
								while (obj.getAnchorPoint().yPos != 385) {
									obj.setAnchorPoint(
											new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 5));
									System.out.println("+3��");
									try {
										sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						} else {
							for (int i = 0; i < 15; i++) {
								if (obj.getAnchorPoint().xPos >= 150 && obj.getAnchorPoint().xPos <= 210
										&& obj.getAnchorPoint().yPos <= 305) {
									Jpanel.remove(coinbox);
									System.out.println("�����");
									if (!mushchk) {
										new Thread() {
											@Override
											public void run() {
												mushchk = true;
												for (int j = 0; j < 15; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos,
															mush.getAnchorPoint().yPos - 2));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 10; j++)
												{
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 3,
															mush.getAnchorPoint().yPos));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 6; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 3,
															mush.getAnchorPoint().yPos+8));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
												for (int j = 0; j < 25; j++) {
													mush.setAnchorPoint(new IfPosition(mush.getAnchorPoint().xPos + 2,
															mush.getAnchorPoint().yPos + 6));
													try {
														Thread.sleep(10);
													} catch (InterruptedException e) {
														// TODO Auto-generated
														// catch
														// block
														e.printStackTrace();
													}
												}
											}
										}.start();
									}
								}
								obj.setAnchorPoint(
										new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos - 6));
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							for (int i = 0; i < 15; i++) {
								obj.setAnchorPoint(
										new IfPosition(obj.getAnchorPoint().xPos, obj.getAnchorPoint().yPos + 6));
								System.out.println("���ڸ����� : +6");
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
									if (Math.abs(obj.getAnchorPoint().xPos - mush.getAnchorPoint().xPos) <= 40 && Math.abs(obj.getAnchorPoint().yPos - mush.getAnchorPoint().yPos) <= 40)
									{
										System.out.println("mush ����");
										Jpanel.remove(mush);
									}
									if (obj.getAnchorPoint().xPos >= 410 && obj.getAnchorPoint().xPos <= 430
											&& obj.getAnchorPoint().yPos >= 350 || obj.getAnchorPoint().xPos >= 550)
										break;
									if (obj.getAnchorPoint().xPos >= 520 && obj.getAnchorPoint().xPos <= 526) {
										while (obj.getAnchorPoint().yPos != 385) {
											obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos + 3,
													obj.getAnchorPoint().yPos + 5));
											System.out.println("Right : ���������� ��������");
											try {
												sleep(10);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
										}
									} else {
										obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos + 3,
												obj.getAnchorPoint().yPos));
										System.out.println("KeyPressed : Right");
									}
								}
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									stopped = true;
									// e.printStackTrace();
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
									if (obj.getAnchorPoint().xPos <= 0
											|| (obj.getAnchorPoint().xPos >= 515 && obj.getAnchorPoint().xPos <= 520))
										break;
									if (obj.getAnchorPoint().xPos >= 425 && obj.getAnchorPoint().xPos <= 428
											&& obj.getAnchorPoint().yPos <= 335) {
										while (obj.getAnchorPoint().yPos < 385) {
											obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos - 3,
													obj.getAnchorPoint().yPos + 5));
											System.out.println("Left : ���������� ��������");
											try {
												sleep(10);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
										}
										break;
									} else {
										obj.setAnchorPoint(new IfPosition(obj.getAnchorPoint().xPos - 3,
												obj.getAnchorPoint().yPos));
										System.out.println("KeyPressed : Left");
									}
								}
								try {
									sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									stopped = true;
									// e.printStackTrace();
								}

							}

						}

					};
					onGoing.start();
				}
				break;
			}
			obj.getFrame().repaint();
			// obj.getFrame().update(obj); ��� �˾ƺ���
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			System.out.println("KeyReleased : Right");
			onGoing.interrupt();
			onGoing = null;
			direction = DIR_STOP;
			// interrupt �� �� �ڿ������� �׼��� �Ͼ, �� �κ� �������� �극��ũ ��� �����ϸ� ���
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("KeyReleased : Left");
			onGoing.interrupt();
			onGoing = null;
			direction = DIR_STOP;
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
