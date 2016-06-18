package org.coderetreat.gameoflife;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class GameOfLife {

	private final Set<Point> cells = new HashSet<>();

	public void place(int x, int y) {
		cells.add(new Point(x, y));
	}

	public void renderCellsTo(Consumer<Point> consumer) {
		cells.forEach(consumer);
	}

}
