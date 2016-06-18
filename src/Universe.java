import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Universe {

	private Map<Point, Cell> map = new HashMap<>();

	public Universe(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void placeCellAt(int x, int y, Cell cell) {
		map.put(new Point(x, y), cell);
	}

	public Cell cell(int x, int y) {
		// TODO Auto-generated method stub
		Cell cell = map.get(new Point(x, y));
		return cell == null ? new Cell() : cell;
	}

}
