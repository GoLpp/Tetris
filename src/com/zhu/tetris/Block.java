package com.zhu.tetris;

import java.awt.Graphics;
/**
 * –°∑ΩøÈ¿‡
 * @author GG Bone
 *
 */
public class Block {
	private int row;
	private int col;
	private BlockType blockType;
	private static final int RECT_LENGTH=25;
	
	public Block() {
		super();
	}

	public Block(int row, int col, BlockType blockType) {
		this.row = row;
		this.col = col;
		this.blockType = blockType;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public BlockType getBlockType() {
		return blockType;
	}

	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}

	public void draw(Graphics g) {
		g.fillRect(col*RECT_LENGTH, row*RECT_LENGTH+20, RECT_LENGTH, RECT_LENGTH);
	
	}

	@Override
	public String toString() {
		return "Block [row=" + row + ", col=" + col + ", blockType=" + blockType + "]";
	}
}
