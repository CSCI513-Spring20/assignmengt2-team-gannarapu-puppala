package application;
import java.awt.Point;
import java.util.*;

public class Ship extends Observable{
	int scale = 50;
	int xCell,yCell;
	boolean[][] myGrid1 = new boolean[10][10];
	public void storeShipLocation(int a, int b,boolean[][] myGrid) {
		xCell = a;
		yCell = b;	
		myGrid1=myGrid;
	}
	
	
	
	public void goEast() {
		if(xCell<9) {
			if(myGrid1[xCell+1][yCell]==false) {
			xCell++;
		}	}	
		updateObserver();
	}
	public void goWest() {
		if(xCell>0) {
			if(myGrid1[xCell-1][yCell]==false) {
			xCell--;}}
		updateObserver();
	}
	public void goNorth() {
		if(yCell>0) {
			if(myGrid1[xCell][yCell-1]==false) {
			yCell--;
		}}
		updateObserver();
		
	}
	public void goSouth() {
		if(yCell<9) 
			{if(myGrid1[xCell][yCell+1]==false) {
			yCell++;
		}}
		updateObserver();
		
	}

	public Point getShipLocation() {
		
		return new Point(xCell,yCell);
	}
	 void updateObserver()  
	    {
		 setChanged(); 
	     notifyObservers();
		 
	    } 


}
