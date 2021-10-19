
public class Position {
	private int x;
	private int y;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (this.x != position.getX()) return false;
        if (this.y != position.getY()) return false;

        return true;
    }
	
	public int hashCode() {
        int result = x;
        result = 37 * result + y;
        return result;
    }

}
