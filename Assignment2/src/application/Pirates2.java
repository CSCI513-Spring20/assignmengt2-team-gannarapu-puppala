package application;
import java.awt.Point;
import java.util.*;


public class Pirates2 implements Observer {
	//Declaring Variables
	Point shipLocation;
	int xCell,yCell;
	boolean[][] myGrid1 = new boolean[10][10];
	
	
	// Used to store Pirate2 location		
	public void storePirateLocation(int a, int b, boolean[][] myGrid) {
		xCell = a;
		yCell = b;	
		myGrid1 =myGrid;
	}

	// Used to update Pirate2 location
	@Override
	public void update(Observable ship, Object arg) {
		shipLocation= ((Ship)ship).getShipLocation();
		updatePirateLocation();
	}
	
	//Updating pirate2 Location
	private void updatePirateLocation() {
		
		 if (xCell - (shipLocation.x) < 0)
			 xCell++;
		 else
			 xCell--;
		 
		 if (yCell - (shipLocation.y) < 0)
			 yCell++;
		 else
			 yCell--;
		 if(myGrid1[xCell][yCell] == true) {
			 if (((shipLocation.x) - xCell> 0) && myGrid1[xCell-1][yCell]== false) {
				 xCell--; }
			 else if(((shipLocation.x) - xCell< 0) && myGrid1[xCell+1][yCell]== false) {
				 xCell++;
			 } 
			 else if(((shipLocation.y) - yCell< 0) && myGrid1[xCell][yCell-1]== false) {
				 yCell--;
			 }
			 else if(((shipLocation.y) - yCell> 0) && myGrid1[xCell][yCell+1]== false) {
				 yCell++;
			 }			 
		 }		 
		
	}

	// Return pirate location
	public Point getPirateLocation() {
		return new Point(xCell,yCell);
	}

}
