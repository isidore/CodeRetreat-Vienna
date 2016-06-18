package org.coderetreat.gameoflife;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.spun.util.Colors;

public class GameOfLifeGui extends JPanel {

	private static final int CELL_WIDTH = 64;
	private static final int WIDTH = CELL_WIDTH * 16;
	private static final int CELL_HEIGHT = 64;
	private static final int HEIGHT = CELL_HEIGHT * 9;

	private GameOfLife gameOfLife;

	public GameOfLifeGui(GameOfLife gameOfLife) {
		this.gameOfLife = gameOfLife;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Colors.Greens.DarkGreen);
		gameOfLife.renderCellsTo((x, y) -> {
			g.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
		});
	}
}
