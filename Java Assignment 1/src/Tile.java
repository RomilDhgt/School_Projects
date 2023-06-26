
/**
 * @author Romil Dhagat 
 *
 * Class name : Tile
 * 
 * The class of Tile represents a scrabble board tile piece identified by a character and value, 
 * and it allows you to return a string that describes the tile and check if the tiles are equal to each other
 *
 */
public class Tile {
	
	int value;
	char letter;
	
	Tile(){
		this.letter = 'A';
		this.value = 1;
	}
	
	Tile(char c, int i){
		this.letter = c;
		this.value = i;
	}
	
	public String toString() {
		return this.letter + "[" + this.value + "]";
	}
	
	public boolean equals(Tile Other) {
		return ((this.letter == Other.letter) && (this.value == Other.value));
	}
	
	
	public static void main(String[] args) {
		
		Tile tile0 = new Tile();
		Tile tile1 = new Tile();
		Tile tile2 = new Tile('Z', 10);
		
		System.out.println("Tile 0 " + tile0.toString());
		System.out.println("Tile 1 " + tile1.toString());
		System.out.println("Tile 2 " + tile2.toString());
		
		System.out.println("Tile 0 is equal to Tile 1 is " + tile0.equals(tile1));
		System.out.println("Tile 0 is equal to Tile 2 is " + tile0.equals(tile2));
		
	}

}
