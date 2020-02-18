package application;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.awt.Point;
import java.util.Random;

public class OceanMap {
	//Initialization
	private int  dimensions=10;
	final int scale = 50;
	boolean[][] myGrid =new boolean[10][10];
	Random rand = new Random();
	int x,y;
	//Used to create Rectangles and add on the Grid
	public boolean[][] getMap(Pane root){
		for(int x = 0; x < dimensions; x++){
			 for(int y = 0; y < dimensions; y++){
				 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); // We want the black outline
			rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
			root.getChildren().add(rect); // Add to the node tree in the pane
			myGrid[x][y] = false;
			}
			}
		return myGrid;
		 }
	// Generate Random coordinates for images
	public Point getImageLocation() {	
		
		x =rand.nextInt(10);
		y =rand.nextInt(10);	
		while(myGrid[x][y] == true) { 
			x =rand.nextInt(10);
			y =rand.nextInt(10);
		}	
		myGrid[x][y] = true;
		return new Point(x,y);
	}


}
