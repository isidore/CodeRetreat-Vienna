package org.coderetreat.gameoflife;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class GameOfLife {

	private Set<Point> cells = new HashSet<>();

	public void place(int x, int y) {
		cells.add(new Point(x, y));
	}

	public void renderCellsTo(Consumer<Point> consumer) {
		cells.forEach(consumer);
	}

	public void advance() {
		Set<Point> newCells = new HashSet<>();
		for (int x = 0; x <= maxX(); x++) {
			for (int y = 0; y <= maxY(); y++) {
				calculateLife(x, y, newCells);
			}
		}
		this.cells = newCells;
	}

	private void calculateLife(int x, int y, Set<Point> newCells) {
		int neighbourCount = getNeighbourCount(x, y);
		if (neighbourCount == 2 && isAlive(x, y)) {
			newCells.add(new Point(x, y));
		}
	}

	private boolean isAlive(int x, int y) {
		return cells.contains(new Point(x, y));
	}

	private int getNeighbourCount(int x, int y) {
		return getNeighbours(x, y).stream().filter(p -> isAlive(p.x, p.y));
	}

	private Collection<Point> getNeighbours(int x, int y) {
		return Arrays.asList(
				new Point(x-1, y-1),
				new Point(x-1, y),
				new Point(x-1, y+1),
				new Point(x, y-1),
				new Point(x, y-1),
				new Point(x-1, y-1),
				new Point(x-1, y-1),
				new Point(x-1, y-1),
				new Point(x-1, y-1),
				);
	}

	private int maxX() {
		return cells.stream().mapToInt(p -> p.x).max().getAsInt() + 1;
	}

	private int maxY() {
		return cells.stream().mapToInt(p -> p.y).max().getAsInt() + 1;
	}

}
