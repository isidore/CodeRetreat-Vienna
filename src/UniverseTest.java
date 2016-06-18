import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

	@Test
	public void universe4x4_CellAt1x1_1x1IsAlive() {
		Universe universe = new Universe(4, 4);

		Cell cell = new Cell();
		universe.placeCellAt(1, 1, cell);

		Assert.assertTrue(universe.cell(1, 1).alive());
	}

	@Test
	public void universe1x1_Empty_0x0IsDead() throws Exception {
		Universe universe = new Universe(1, 1);

		Assert.assertFalse(universe.cell(0, 0).alive());
	}
}
