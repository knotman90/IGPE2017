package reflection;

enum Direction{
	UP(0),LEFT(1),DOWN(2),RIGHT(3), STOP(4);

	private int value;
	private Direction(int val) {
		value = val;
	}
	public int getValue() {
		return value;
	}

	public static Direction fromInt(int i) {
		for (Direction b : Direction .values()) {
			if (b.getValue() == i) { return b; }
		}
		return null;
	}
}

public interface IMazeSolver {

	Direction advance(int px, int py, boolean[] neighborhood); 

}
