package com.zhu.tetris;

import java.util.ArrayList;
import java.util.List;
/**
 * ������ƣ������ɹ�����
 * @author GG Bone
 *
 */

public class BlockUtil {
	
	public static List<Block> blocks = null;
	private BlockUtil() {
		
	}
	
	/**
	 * �����η���
	 * @return ���鼯��
	 */
	private static List<Block> tianBlock() {
		/*Block block1 = new Block(0, 4);
		Block block2 = new Block(0, 5);
		Block block3 = new Block(1, 4);
		Block block4 = new Block(1, 5);*/
		int[][] arr = {{0,4},{0,5},{1,4},{1,5}};
		return add1(arr,BlockType.TIAN);
		//return add(block1,block2,block3,block4);
	}
	/**
	 * L�η���
	 * @return ���鼯��
	 */
	private static List<Block> liBlock() {
		int[][] arr = {{1,4},{1,5},{1,6},{0,4}};
		return add1(arr,BlockType.LI);
	}
	
	public static List<Block> cgLiBlock1(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row - 1;
		int b0_col = b1_col;
		
		int b2_row = b1_row + 1;
		int b2_col = b1_col;
		
		int b3_row = b1_row - 1;
		int b3_col = b1_col + 1;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LI);
	}
	
	public static List<Block> cgLiBlock2(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row ;
		int b0_col = b1_col + 1;
		
		int b2_row = b1_row;
		int b2_col = b1_col-1;
		
		int b3_row = b1_row + 1;
		int b3_col = b1_col + 1;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LI);
	}	
	
	public static List<Block> cgLiBlock3(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row + 1;
		int b0_col = b1_col;
		
		int b2_row = b1_row - 1;
		int b2_col = b1_col;
		
		int b3_row = b1_row + 1;
		int b3_col = b1_col - 1;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LI);
	}
	
	public static List<Block> cgLiBlock4(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row ;
		int b0_col = b1_col - 1;
		
		int b2_row = b1_row;
		int b2_col = b1_col + 1;
		
		int b3_row = b1_row - 1;
		int b3_col = b1_col - 1;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LI);
	}
	
	/**
	 * �����η���
	 * @return ���鼯��
	 */
	private static List<Block> lBlock() {
		int[][] arr = {{3,4},{2,4},{1,4},{0,4}};
		return add1(arr, BlockType.LL);
	}
	
	public static List<Block> lBlock1(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row ;
		int b0_col = b1_col - 1;
		
		int b2_row = b1_row;
		int b2_col = b1_col + 1;
		
		int b3_row = b1_row;
		int b3_col = b1_col + 2;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LL);
	}
	
	
	public static List<Block> lBlock2(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row - 1 ;
		int b0_col = b1_col;
		
		int b2_row = b1_row + 1;
		int b2_col = b1_col;
		
		int b3_row = b1_row + 2;
		int b3_col = b1_col;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.LL);
	}
	
	/**
	 * z�η���
	 * @return ���鼯��
	 */
	private static List<Block> zBlock() {
		int[][] arr ={{2,5},{1,4},{1,5},{0,4}};
		return add1(arr, BlockType.Z);
	}
	
	public static List<Block> zBlock1(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row + 1 ;
		int b0_col = b1_col - 1;
		
		int b2_row = b1_row + 1;
		int b2_col = b1_col;
		
		int b3_row = b1_row;
		int b3_col = b1_col + 1;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.Z);
	}
	
	public static List<Block> zBlock2(List<Block> blocks) {
		int b1_row = blocks.get(1).getRow();
		int b1_col = blocks.get(1).getCol();
		
		int b0_row = b1_row - 1 ;
		int b0_col = b1_col - 1;
		
		int b2_row = b1_row;
		int b2_col = b1_col-1;
		
		int b3_row = b1_row + 1;
		int b3_col = b1_col;
		
		int[][] arr = {{b0_row,b0_col},{b1_row,b1_col},{b2_row,b2_col},{b3_row,b3_col}};
		return add1(arr, BlockType.Z);

	}

	
	/**
	 * �ⲿ��÷���ӿ�
	 * @return ���鼯��
	 */
	public static List<Block> getBlockList() {
		int num = (int)(Math.random()*4 + 1);
		switch(num) {
			case 1:
				return tianBlock();
			case 2:
				return lBlock();
			case 3:
				return liBlock();
			default:
				return zBlock();
		}
	}
	
	/**
	 * ����������
	 * @param arr ������ʽ��������
	 * @return ���ض��Ƶķ���
	 */
	private static List<Block> add1(int[][] arr, BlockType blockType) {
		List<Block> blocks = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			Block block = new Block(arr[i][0],arr[i][1],blockType);
			blocks.add(block);
		}
		return blocks;
	}	
}
