import java.util.Scanner;

public class Loader {
	public final static int TILE_TYPE = 0;
	public final static int X_COORD = 1;
	public final static int Y_COORD = 2;
	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	
	
	
	public static boolean isBlocked(float x, float y) {
		// Default to blocked
		return true;
	}

	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 */
	public static Sprite[][] loadSprites(String filename) {
		try (Scanner scanner = new Scanner(new FileReader(filename))) {
			String[] txtRow = (scanner.nextLine()).split(",");
			//setWorldDimensions
			int xDim = Integer.parseInt(txtRow[World.X_POS]);
			int yDim = Integer.parseInt(txtRow[World.Y_POS]);
			World.dim[World.X_POS] = xDim
			World.dim[World.Y_POS] = yDim;

			Sprite[][] floorArray = new Sprite[xDim][yDim];
			//construct then get and set block array in world
			boolean[][] blockArray = new boolean[xDim][yDim];
			
			String tileType;
			String xCoord;
			String yCoord;
			while (scanner.hasNextLine()) {
    			txtRow = (scanner.nextLine()).split(",");
				tileType = txtRow[TILE_TYPE];
				xCoord = txtRow[X_COORD];
				yCoord = txtRow[Y_COORD];
				if(!tileType.equals("player")) {
					floorArray[xCoord][yCoord] = new Sprite(tileType, xCoord, yCoord);
					if(tileType.equals("wall")){
						blockArray[xCoord][yCoord] = True;
					} else {
						blockArray[xCoord][yCoord] = False;
					}
				} else {
					//setPlayer
					world.player = new Sprite(tileType, xCoord, yCoord);
				}


    		}
		}
		return floorArray;
	}
}
