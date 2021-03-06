package application;
import java.awt.Point;
import java.util.*;


public class Pirates implements Observer {
	// Initialization
	Point shipLocation;
	int xCell,yCell;
	boolean[][] myGrid1 = new boolean[10][10];
	
	// Used to store Pirate location		
	public void storePirateLocation(int a, int b, boolean[][] myGrid) {
		xCell = a;
		yCell = b;	
		myGrid1 =myGrid;
	}

	// Used to update Pirate location
	@Override
	public void update(Observable ship, Object arg) {
		shipLocation= ((Ship)ship).getShipLocation();
		updatePirateLocation();
	}
	
	//Updating pirate Location
	private void updatePirateLocation() {
		// TODO Auto-generated method stub
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
	//myGrid1[xCell][yCell]=true;
	}
	// Return pirate location
	public Point getPirateLocation() {
		return new Point(xCell,yCell);
	}

}
