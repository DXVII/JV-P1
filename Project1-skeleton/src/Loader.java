import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import java.io.BufferedReader;


/*
Loader class has:
	loadSprite:
		- *list* creates 1D array of Sprites assigning their:
			+ type
			+ pixel location
			-> list is passed to World floorArray
		- creates player sprite assigning its:
			+ type
			+ pixel location
			+ 2D array tile postion
			-> passed via setPlayer
		- creates 2D array of boolean blockedArray:
			+ map of if a player can move "here"
			-> passed via setBlockedArray
*/

public class Loader {
	//dimension indexing
	public static final int X_POS = 0;
	public static final int Y_POS = 1;

	//sprite indexing
	public static final int TILE_TYPE = 0;
	public static final int X_COORD = 1;
	public static final int Y_COORD = 2;
	// Map of where the world is blocked
	private static boolean[][] blockedArray;

	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 * @throws SlickException
	 * @throws FileNotFoundException
	 */

	public static Sprite[] loadSprites(String filename)
	throws SlickException, FileNotFoundException {

		//Building my array list to be returned to world
		ArrayList<Sprite> list = new ArrayList<Sprite>();

		//SAFETY
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

		//read first line to obtain level dimensions
		    String[] txtRow = (br.readLine()).split(",");

			//extract from file convert int
		    int xDim = Integer.parseInt((txtRow[X_POS]).trim());
		    int yDim = Integer.parseInt((txtRow[Y_POS]).trim());

			// 2D array of where a player cannot move
			blockedArray = new boolean[xDim][yDim];

		    //x & y Pix's shift sprite tiles to centred
		    xDim = (App.SCREEN_WIDTH-(App.TILE_SIZE*xDim))/2;
		    yDim = (App.SCREEN_HEIGHT-(App.TILE_SIZE*yDim))/2;


		// Looping through the rest of csv lines
			//indexing
			String tileType;
		    int xCoord;
		    int yCoord;
			// pixels of each sprite
		    float xPix;
		    float yPix;
		    String text;
		//Begin loop
		    while ((text = br.readLine()) != null) {

				txtRow = text.split(",");
				//done to reduce horizontal code length
				tileType = txtRow[TILE_TYPE];
		        xCoord = Integer.parseInt((txtRow[X_COORD]).trim());
		        yCoord = Integer.parseInt((txtRow[Y_COORD]).trim());

				//finding the pixel location with centering shift applied
		        xPix = (float) (App.TILE_SIZE*xCoord + xDim);
		        yPix = (float) (App.TILE_SIZE*yCoord + yDim);


				//separate map tiles from player and checking blocked
		        if(!tileType.equals("player")) {
		            //generating floor plan
					Sprite tmpSprite = new Sprite(tileType, xPix, yPix);
					list.add(tmpSprite);

		            //generating array of blocked walls
		            if(tileType.equals("wall")){
						blockedArray[xCoord][yCoord] = true;
		            } else {
		                blockedArray[xCoord][yCoord] = false;
		            }
				//player created and passed back
		        } else {
		            Player player = new Player(tileType, xPix, yPix, xCoord, yCoord);
					World.setPlayer(player);
		        }

		    }
			//blockedArray passed to world
			World.setBlockedArray(blockedArray);
		
		} catch (Exception e) {
		    e.printStackTrace();
		}

		return list.toArray(new Sprite[list.size()]);
	}
}
