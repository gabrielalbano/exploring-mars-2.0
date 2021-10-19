import java.util.Map;
import java.util.HashMap;

public class Field {
	private int length;
	private int width;
	private Map<Position, Probe> probes;
	
	public Field (int length, int width) {
		if (length <= 0 || width <= 0) {
			throw new IllegalArgumentException(">>> Os valores das dimensões precisam ser maiores que zero.");
		}
		this.length = length;
		this.width = width;
		this.probes = new HashMap<>();
	}
	
	public void landOn(Position newPosition, Probe probe) {
		probes.put(newPosition, probe);
	}
	
	public void departFrom(Position currentPosition) {
		probes.remove(currentPosition);
	}
	
	public boolean isPositionOccupied(Position position) {
		if (probes.containsKey(position)) {
			return true;
		}
		return false;
	}
	
	public boolean isPositionOutOfBoundaries(Position position) {
		boolean isXOutOfBoundaries = position.getX() < 0 || position.getX() > this.length;
		boolean isYOutOfBoundaries = position.getY() < 0 || position.getY() > this.width;
		return (isXOutOfBoundaries || isYOutOfBoundaries);
	}
	
	public boolean isPositionAvailable(Position position) {
		return !isPositionOccupied(position) && !isPositionOutOfBoundaries(position);
	}

}
