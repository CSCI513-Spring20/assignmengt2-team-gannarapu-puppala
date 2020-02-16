package application;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.awt.Point;
import java.util.Random;

public class OceanMap {
	int xCell =6;
	int yCell =6;
	private int  dimensions=10;
	final int scale = 50;
	boolean[][] myGrid =new boolean[10][10];
	Random rand = new Random();
	int x,y;
	static int firstTime=0;
	


	
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
	public Point getImageLocation() {	
		if(firstTime==0) {
			x =rand.nextInt(10);
			y =rand.nextInt(10);
			firstTime++;
			myGrid[x][y] = true;
			return new Point(x,y);
		}
		
		while(myGrid[x][y]== true) {
			x =rand.nextInt(10);
			y =rand.nextInt(10);
		}
		myGrid[x][y] = true;
		return new Point(x,y);
	}
	
	public void setFinal(int a, int b) {
		xCell =a;
		yCell =b;
	}


}
