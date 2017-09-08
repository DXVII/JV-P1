import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import java.util.Arrays;
import java.io.BufferedReader;


/*
Loader class has:
isBlocked: 		static 2D boolean  array to track if a position in a map is not traversible

loadSprite: 	- points to Player player and assigns its pixel location
				  and 2D array tile postion
 				- creates 1D array of Sprites passing in pixel location into them
				- returns above array(1D) to floorArray in World
*/

public class Loader {
	//Used for CSV: no magic numbers
	//sprite indexing
	public static final int TILE_TYPE = 0;
	public static final int X_COORD = 1;
	public static final int Y_COORD = 2;
	//dimension indexing
	public static final int X_POS = 0;
	public static final int Y_POS = 1;

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

		//Building my array list
		ArrayList<Sprite> list = new ArrayList<Sprite>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			//read first line to obtain level dimensions
		    String[] txtRow = (br.readLine()).split(",");
			//extract from file -> int
		    int xDim = Integer.parseInt((txtRow[X_POS]).trim());
		    int yDim = Integer.parseInt((txtRow[Y_POS]).trim());

			// 2D array of where a player cannot move
			blockedArray = new boolean[xDim][yDim];

		    //xyDim converted to xyPix to centre shift sprite tiles
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
				//System.out.println(Arrays.toString(txtRow));

				tileType = txtRow[TILE_TYPE];
		        xCoord = Integer.parseInt((txtRow[X_COORD]).trim());
		        yCoord = Integer.parseInt((txtRow[Y_COORD]).trim());
		        //finding the pixel location with centering shift applied
		        xPix = (float) (App.TILE_SIZE*xCoord + xDim);
		        yPix = (float) (App.TILE_SIZE*yCoord + yDim);



				//separate map tiles from player and checking blocked
		        if(!tileType.equals("player")) {
		            //generating floor plan
					System.out.println("floor tile");
					Sprite tmpSprite = new Sprite(tileType, xPix, yPix);
					list.add(tmpSprite);
		            //generating array of blocked walls
		            if(tileType.equals("wall")){
						System.out.println("\t- I am also a wall");
		                blockedArray[xCoord][yCoord] = true;
		            } else {
		                blockedArray[xCoord][yCoord] = false;
		            }

		        } else {
		            System.out.println("player detected");
		            Player player = new Player(tileType, xPix, yPix, xCoord, yCoord);
					System.out.println("player made");
					World.setPlayer(player);
		        }

		    }
			World.setBlockedArray(blockedArray);

		} catch (Exception e) {
		    e.printStackTrace();
		}

		return list.toArray(new Sprite[list.size()]);
	}
}
