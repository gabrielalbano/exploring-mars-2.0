import java.util.Scanner;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		int length;
		int width;
		Field field;
		String input;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Digite as dimensões do campo a ser explorado:");
		
		input = reader.nextLine();
	    length = Integer.parseInt(input.split(" ")[0]);
        width = Integer.parseInt(input.split(" ")[1]);
        
        try {
        	field = new Field(length, width);
        	do {
        		// leitura de informações da sonda
		        System.out.println("Insira a coordenada e direção da sonda ou insira 'exit' para sair: ");
		        input = reader.nextLine();
	
		        // atribuição de variáveis
		        int coordX = Integer.parseInt(input.split(" ")[0]);
		        int coordY = Integer.parseInt(input.split(" ")[1]);
		        char dir = input.split(" ")[2].charAt(0);
	
		        // criação de instância da sonda e da sequência de instruções
		        Optional<Direction> optDir = Direction.getDirection(dir);
		        Direction direction = optDir.orElseThrow(IllegalArgumentException::new);
		        Position position = new Position(coordX, coordY);

	        // insere sonda no campo se o espaço não estiver ocupado ou estiver fora dos
	        // limites
		        if (field.isPositionAvailable(position)) {
		        	System.out.println("Digite a sequência de instruções:");
		        	Probe probe = new Probe(field, position, direction);
		        	String instructions = reader.nextLine();
	
		        	// realização das instruções
		        	probe.processInstructions(instructions);
	
		        	// Imprime a posição e direção finais da sonda no terminal
		        	System.out.println(probe.finalPositionToString());
		        } else {
		        	System.out.println("Erro: espaço já ocupado ou fora dos limites do campo.");
		        }        		
        	} while(!input.equals("exit"));
        } catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		
	    reader.close();
	}

}
