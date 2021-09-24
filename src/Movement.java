import java.util.Optional;

public enum Movement {
	FORWARD('M') {
		@Override
		public void move(Probe probe) {
			probe.moveForward();
		}
	},
	LEFT('L') {
		@Override
		public void move(Probe probe) {
			probe.turnLeft();
		}
	},
	RIGHT('R') {
		@Override
		public void move(Probe probe) {
			probe.turnRight();
		}
	};
	
	private final char code;
	
	private Movement(char code) {
		this.code = code;
	}
	
	public static Optional<Movement> getMovement(char code) {
	    for (Movement movement : Movement.values()) {
	    	if (movement.code == code)
	    		return Optional.of(movement);
	    	}
	    return Optional.empty();
	}
	
	public abstract void move(Probe probe);
}
