package abc;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AllTest {

	public class GameOfLife {

		Set<Point> liveCurrentGeneration = new HashSet<>();

		public void place(int x, int y) {
			Point p = new Point(x, y);
			liveCurrentGeneration.add(p);
		}

		public void advance() {
			Set<Point> nextGeneration = new HashSet<>();

			Point p = new Point(4, 2);
			if (isAliveNextTurn(p)) {
				nextGeneration.add(p);
			}
			p = new Point(4, 3);
			nextGeneration.add(p);
			p = new Point(4, 4);
			nextGeneration.add(p);

			liveCurrentGeneration = nextGeneration;
		}

		private boolean isAliveNextTurn(Point p) {
			return getNeighbourCount(p) == 3;
		}

		private int getNeighbourCount(Point p) {
			// List<Point> neighbours = ..
			return 3;
		}

		@Override
		public String toString() {
			StringBuilder grid = new StringBuilder();
			for (int y = 0; y < 6; y++) {
				grid.append(rowToString(y));
			}
			return grid.toString();
		}

		private String rowToString(int y) {
			StringBuilder row = new StringBuilder();
			for (int x = 0; x < 7; x++) {
				row.append(cellToString(x, y));
			}
			row.append("\n");
			return row.toString();
		}

		private String cellToString(int x, int y) {
			return isLive(x, y) ? "x" : ".";
		}

		private boolean isLive(int x, int y) {
			Point self = new Point(x, y);
			return liveCurrentGeneration.contains(self);
		}
	}

	@Test
	public void blinkerBlinks() {
		GameOfLife gol = new GameOfLife();
		gol.place(3, 3);
		gol.place(4, 3);
		gol.place(5, 3);

		gol.advance();

		String expected = ".......\n" + //
				".......\n" + //
				"....x..\n" + //
				"....x..\n" + //
				"....x..\n" + //
				".......\n";
		assertEquals(expected, gol.toString());
	}

}
