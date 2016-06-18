package org.coderetreat.gameoflife;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

public class GameOfLife {

	private final Set<Point> cells = new HashSet<>();

	public void place(int x, int y) {
		cells.add(new Point(x, y));
	}

	public void renderCellsTo(BiConsumer<Integer, Integer> consumer) {
		cells.forEach(point -> consumer.accept(point.x, point.y));
	}

}
