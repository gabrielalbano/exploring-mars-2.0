import java.util.Optional;

public class Probe {
	private Direction direction;
	private Position position;
	private final Field field;
	
	public Probe (Field field, Position position, Direction direction) {
		if (field.isPositionAvailable(position)) {
			this.position = position;
			this.direction = direction;
			this.field = field;
		}
		else {
			throw new IllegalArgumentException(">>> Erro: espaço já ocupado ou fora dos limites do campo.");
		}
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
		for (String instruction : instructionsList.split("")) {
			doInstruction(instruction.toUpperCase().charAt(0));
		}
	}
	
	public void doInstruction(char instruction) {
		Optional<Movement> optMovement = Movement.getMovement(instruction);
	    Movement movement = optMovement.orElseThrow(() -> new IllegalArgumentException(">>> Erro: instrução inválida."));
	    movement.move(this);
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.position.getX()) + " " + String.valueOf(this.position.getY() + " " + this.direction.getDirectionCode());
	}

}
