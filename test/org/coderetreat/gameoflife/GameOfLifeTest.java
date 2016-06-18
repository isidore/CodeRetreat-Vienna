package org.coderetreat.gameoflife;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.ImageReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter({ ImageReporter.class, ClipboardReporter.class })
public class GameOfLifeTest {

	@Test
	public void aSquareIsStatic() throws Exception {
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.place(2, 5);
		gameOfLife.place(3, 5);
		gameOfLife.place(2, 6);
		gameOfLife.place(3, 6);
		Approvals.verify(new GameOfLifeGui(gameOfLife));
	}

	@Test
	public void blinkersBlink() throws Exception {
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.place(1, 2);
		gameOfLife.place(1, 3);
		gameOfLife.place(1, 4);
		gameOfLife.advance();
		Approvals.verify(new GameOfLifeGui(gameOfLife));
	}

}
