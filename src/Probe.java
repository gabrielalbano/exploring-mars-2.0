import java.util.Optional;

public class Probe {
	private Direction direction;
	private Position position;
	private final Field field;
	
	public Probe (Field field, Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
		this.field = field;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void turnLeft() {
		Direction direction = this.getDirection();
		this.direction = direction.turnLeft();
	}
	
	public void turnRight() {
		Direction direction = this.getDirection();
		this.direction = direction.turnRight();
	}
	
	public void moveForward() {
		Position newPosition = this.forwardPosition();
		Position currentPosition = this.position;
		this.field.departFrom(currentPosition);
		this.field.landOn(newPosition, this);
		this.position = newPosition;
	}
	
	public Position forwardPosition() {
	    int newX = this.position.getX();
	    int newY = this.position.getY();

	    switch (this.direction) {
	      	case NORTH:
	      		newY += 1;
	      		break;
	      	case EAST:
	      		newX += 1;
	      		break;
	      	case SOUTH:
	      		newY -= 1;
	      		break;
	      	case WEST:
	      		newX -= 1;
	      		break;
	      	default:
	      		throw new IllegalArgumentException();
	    }
	    
	    Position newPosition = new Position(newX, newY);
	    
	    if (!this.field.isPositionAvailable(newPosition)) {
	    	this.turnLeft();
	        newPosition = forwardPosition();
	    }
	    
	    return newPosition;
	}
	
	public void processInstructions(String instructionsList) {
	    for (int i = 0; i < instructionsList.length(); i++) {
	    	char instruction = instructionsList.charAt(i);
	    	doInstruction(instruction);
	    }
	}
	
	public void doInstruction(char instruction) {
		Optional<Movement> optMove = Movement.getMovement(instruction);
	    Movement movement = optMove.orElseThrow(IllegalArgumentException::new);
	    movement.move(this);
	}
	
	public String finalPositionToString() {
		return String.valueOf(this.position.getX()) + " " + String.valueOf(this.position.getY() + " " + this.direction.getDirectionCode());
	}

}
