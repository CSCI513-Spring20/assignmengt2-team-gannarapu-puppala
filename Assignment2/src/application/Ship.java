package application;
import java.awt.Point;
import java.util.*;

public class Ship extends Observable{
	int scale = 50;
	int xCell,yCell;
	
	
	
	
	public void goEast(int[] shipCor) {
		if(shipCor[0]!=9) {
			xCell  = (shipCor[0] + 1) * scale;
			shipCor[0] = shipCor[0]+1;
		}
		else {
			xCell  = shipCor[0]*scale;
		}
		
		yCell = shipCor[1] * scale;
		
	}
	public void goWest(int[] shipCor) {
		if(shipCor[0]!=0) {
			xCell  = (shipCor[0] - 1) * scale;
			shipCor[0] = shipCor[0]-1;
		}
		else {
			xCell  = shipCor[0]*scale;
		}
		
		yCell = shipCor[1] * scale;				
	}
	public void goNorth(int[] shipCor) {
		if(shipCor[1]!=0) {
			yCell  = (shipCor[1] - 1) * scale;
			shipCor[1] = shipCor[1]-1;
		}
		else {
			yCell  = shipCor[1]*scale;
		}
		
		xCell = shipCor[0] * scale;
		
	}
	public void goSouth(int[] shipCor) {
		if(shipCor[1]!=9) {
			yCell  = (shipCor[1] + 1) * scale;
			shipCor[1] = shipCor[1]+1;
		}
		else {
			yCell  = shipCor[1]*scale;
		}
		
		xCell = shipCor[0] * scale;
		
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
