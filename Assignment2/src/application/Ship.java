package application;
import java.awt.Point;
import java.util.*;

public class Ship extends Observable{
	int scale = 50;
	int xCell =300;
	int yCell=300;
	
	
	
	
	public Point goEast(int x,int y) {
		if(x!=450) {
			xCell = x+50; }
		return new Point(xCell,y);
		
	}
	public Point goWest(int x,int y) {
		if(x!=0) {
			xCell = x-50; }
		return new Point(xCell,y);
		
		
	}
	public Point goNorth(int x,int y) {
		if(y!=0) {
			yCell = y-50; }
		return new Point(x,yCell);
		
	}
	public Point goSouth(int x,int y) {
		if(y!=450) {
			yCell = y+50; }
		return new Point(x,yCell);
		
	}

	public Point getShipLocation() {
		
		return new Point(xCell,yCell);
	}
	 void incre()  
	    {
		 setChanged(); 
	     notifyObservers();
		 
	    } 


}
