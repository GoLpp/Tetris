package com.zhu.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * ��Ϸ����
 * @author GG Bone
 *
 */
public class BlockBoard {
	private BlockState[][] states = new BlockState[26][18];
	private List<Block> blocks = BlockUtil.getBlockList();
	private static final int RECT_LENGTH=25;
	
	public BlockBoard() {
		initState();
	}
	
	public BlockState[][] getStates() {
		return states;
	}
	
	public void setStates(BlockState[][] states) {
		this.states = states;
	}
	
	public List<Block> getBlocks() {
		return blocks;
	}

	/**
	 * �����Զ������ƶ�
	 * @return 
	 */
	public boolean move() {
		for(Block block:blocks) {
			block.setRow(block.getRow()+1);
		}
		return true;
	}
	
	/**
	 * �������Ʒ�����ˮƽ�����ƶ�
	 */
	public void x_move(boolean direction) {
			try{
				if(direction) {
					for(Block block:blocks) {
						block.setCol(block.getCol()+1);
					}
				}else if( !direction) {
					for(Block block:blocks) {
						block.setCol(block.getCol()-1);
					}
				}
			}catch (ArrayIndexOutOfBoundsException e) {
				if(direction) {
					for(Block block:blocks) {
						block.setCol(block.getCol()-1);
					}
				}else{
					for(Block block:blocks) {
						block.setCol(block.getCol()+1);
					}
				}
			}
	}
	
	/**
	 * �����ײ�ײ�
	 * @return ��ײ����true���򷵻�false
	 */
	public boolean checkCrash() {
		for(Block block:blocks) {
				if(((block.getRow() == 25) || states[block.getRow()+1][block.getCol()] == BlockState.HAVE)) {
					for(Block block1:blocks) {
						states[block1.getRow()][block1.getCol()] = BlockState.HAVE;
					}
					blocks = null;
					return true;
				}
		}
		return false;
	}
	
	/**
	 * ���x�����Ƿ���ײǽ��
	 */
	public boolean check_X() {
		for(Block block:blocks) {
			if(block.getCol()-1 < 0 || block.getCol()+1 > 17) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ���x�����Ƿ��з���
	 */
	public boolean check_x_block() {
		int num = 0;
		for(Block block:blocks) {
			int col = block.getCol();
			if(col == 0 || col==17 || states[block.getRow()][block.getCol() - 1] == BlockState.EMPTY &&
					states[block.getRow()][block.getCol()+1] == BlockState.EMPTY){
				num++;
			}
		}
		
		if(num == 4) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * ���һ������ɾ��һ��
	 */
	public void deleteLine() {
		for(int i = 0; i < states.length; i++) {
			boolean allBlock =true;
			for(int j = 0; j < states[i].length; j++) {
				if(states[i][j] == BlockState.EMPTY) {
					allBlock =false;
					continue;
				}
			}
			if(allBlock == true) {
				for(int z = 0; z < states[i].length; z++) {
					states[i][z] = BlockState.EMPTY;
				}
				for(int m = i; m>0; m--) {
					for(int x = 0; x < 18 ; x++) {
						if(states[m-1][x] == BlockState.HAVE) {
							states[m-1][x] = BlockState.EMPTY;
							states[m][x] = BlockState.HAVE;
						}
					}
				}
			}
		}
	}
	
	/**
	 * �ı䷽��ĵ�ǰ״̬
	 * @param blocks ��ǰ���鼯��
	 * @param count ��������
	 */
	public void changeBlock(int count) {
		if(blocks.get(0).getBlockType() == BlockType.LI) {
			switch (count%4) {
				case 0:
					blocks = BlockUtil.cgLiBlock1(blocks);
					break;
				case 1:
					blocks = BlockUtil.cgLiBlock2(blocks);
					break;
				case 2:
					blocks = BlockUtil.cgLiBlock3(blocks);
					break;
				case 3:
					blocks = BlockUtil.cgLiBlock4(blocks);
					break;
			}
		}
		
		if(blocks.get(0).getBlockType() == BlockType.LL) {
			
			if(blocks.get(3).getRow() != 25 || 
					states[blocks.get(3).getRow()][blocks.get(3).getCol()] == BlockState.EMPTY) {
				switch(count%2) {
					case 0:
						blocks = BlockUtil.lBlock1(blocks);
						break;
					case 1:
						blocks = BlockUtil.lBlock2(blocks);
						break;
				}
			}
		}
		
		if(blocks.get(0).getBlockType() == BlockType.Z) {
			switch (count%2) {
				case 0:
					blocks = BlockUtil.zBlock1(blocks);
					break;
				case 1:
					blocks = BlockUtil.zBlock2(blocks);
					break;
			}
		}
		
	}
	
	/**
	 * ���ƶ��ķ��� �ͽ������
	 * @param g ����
	 */
	public void draw(Graphics g) {
		if(!checkCrash()) {
			for(Block block:blocks) {
				g.setColor(Color.PINK);
				block.draw(g);
			}
		}else{
			blocks = BlockUtil.getBlockList();
		}
		drawLine(g);
	}
	
	/**
	 * ���ݼ�¼�ķ���״̬���ƽ���
	 * @param g ����
	 */
	public void drawState(Graphics g) {
		g.setColor(Color.pink);
		for(int i=0; i<states.length; i++) {
			for(int j=0; j<states[i].length; j++) {
				if(states[i][j] == BlockState.HAVE) {
					g.fillRect(j*RECT_LENGTH, i*RECT_LENGTH+20, RECT_LENGTH, RECT_LENGTH);
				}
			}
		}
		drawLine(g);
	}
	
	/**
	 * ����
	 * @param g ����
	 */
	public void drawLine(Graphics g) {
		g.setColor(Color.black);
		for(int i=0; i<26; i++) {
			g.drawLine(0, i*RECT_LENGTH+20, 540, i*RECT_LENGTH+20);
		}
		for(int j=0; j<18; j++) {
			g.drawLine(j*RECT_LENGTH, 20, j*RECT_LENGTH, 800);
		}
	}
	
	private void initState() {
		for(int i = 0; i < states.length;i++) {
			for(int j = 0; j < states[i].length; j++) {
				states[i][j] = BlockState.EMPTY;
			}
		}
	}	
}
