package application;
import java.awt.Point;
import java.util.*;

public class Ship extends Observable{
	// Declaring Variables
	int xCell,yCell;
	boolean[][] myGrid1 = new boolean[10][10];
	// Used to store ship coordinates
	public void storeShipLocation(int a, int b,boolean[][] myGrid) {
		xCell = a;
		yCell = b;	
		myGrid1=myGrid;
	}
	
	
	//update ship coordinates when ship moves East
	public void goEast() {
		if(xCell<9) {
			if(myGrid1[xCell+1][yCell]==false) {
			xCell++;
		}	}	
		updateObserver();
	}
	//update ship coordinates when ship moves West
	public void goWest() {
		if(xCell>0) {
			if(myGrid1[xCell-1][yCell]==false) {
			xCell--;}}
		updateObserver();
	}
	//update ship coordinates when ship moves North
	public void goNorth() {
		if(yCell>0) {
			if(myGrid1[xCell][yCell-1]==false) {
			yCell--;
		}}
		updateObserver();
		
	}
	//update ship coordinates when ship moves South
	public void goSouth() {
		if(yCell<9) 
			{if(myGrid1[xCell][yCell+1]==false) {
			yCell++;
		}}
		updateObserver();
		
	}

	// Returns ship Locations
	public Point getShipLocation() {
		
		return new Point(xCell,yCell);
	}
	 void updateObserver()  
	    {
		 setChanged(); 
	     notifyObservers();
		 
	    } 


}
