package com.zhu.tetris;

/**
 * 移动方块的线程类
 * @author GG Bone
 *
 */
public class MoveThread implements Runnable{
	
	private BlockBoard blockBoard = null;
	private TFrame tFrame = null;
	public int speed = 300;
	public MoveThread(BlockBoard blockBoard, TFrame tFrame) {
		this.blockBoard = blockBoard;
		this.tFrame = tFrame;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		while(blockBoard.move()) {
			blockBoard.deleteLine();
			tFrame.repaint();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
