package com.zhu.tetris;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
/**
 * 
 * @author GG Bone
 *
 */
public class TFrame extends JFrame{
	
	private static BlockBoard blockBoard = new BlockBoard();
	private static TFrame tFrame = new TFrame();
	private BufferedImage image = new BufferedImage(450, 670, 1);
	private static Thread thread = null;
	
	private static MoveThread moveThread = null;
	
	public TFrame() {
		setTitle("¶íÂÞË¹·½¿é");
		setSize(450,670);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			public int count = 0;
			public int num = 0;
			public boolean a = true;
			public boolean b = true;
			@Override
			public void keyPressed(KeyEvent e) {
				if(a == true && b== true) {
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if(blockBoard.check_X() == false && blockBoard.check_x_block() == false) {
							blockBoard.x_move(true);
							moveThread.setSpeed(200);
							num = 1;
						}else{
							a=false;
							b=false;
							moveThread.setSpeed(200);
							num=1;
						}
					}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
						if(blockBoard.check_X() == false && blockBoard.check_x_block() == false) {
							blockBoard.x_move(false);
							moveThread.setSpeed(200);
							num=0;
						}else{
							a=false;
							b=false;
							moveThread.setSpeed(200);
							num=0;
						}
					}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						moveThread.setSpeed(100);
					}else if(e.getKeyCode() == KeyEvent.VK_UP) {
						moveThread.setSpeed(200);
						blockBoard.changeBlock(count);
						count++;
					}
				}else{
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
							moveThread.setSpeed(200);
							blockBoard.x_move(false);
							a=true;
							b=true;
					}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
							moveThread.setSpeed(200);
							blockBoard.x_move(true);
							a=true;
							b=true;
					}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						moveThread.setSpeed(100);
					}else if(e.getKeyCode() == KeyEvent.VK_UP) {
						moveThread.setSpeed(200);
						blockBoard.changeBlock(count);
						count++;
					}
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics g2 =image.getGraphics();
		super.paint(g2);
		blockBoard.draw(g2);
		blockBoard.drawState(g2);
		g.drawImage(image, 0, 0, null);
		
	}
	public static void main(String[] args) {
		tFrame.setVisible(true);
		moveThread = new MoveThread(blockBoard,tFrame);
		thread = new Thread(moveThread);
		thread.start();
	}
}
