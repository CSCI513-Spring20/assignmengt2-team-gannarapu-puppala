package application;
import java.awt.Point;
import java.util.*;


public class Pirates implements Observer {
	Point shipLocation;
	int xCell,yCell;
	boolean[][] myGrid1 = new boolean[10][10];
			
	public void storePirateLocation(int a, int b, boolean[][] myGrid) {
		xCell = a;
		yCell = b;	
		myGrid1 =myGrid;
	}

	@Override
	public void update(Observable ship, Object arg) {
		shipLocation= ((Ship)ship).getShipLocation();
		System.out.println(shipLocation.x+""+shipLocation.y);
		updatePirateLocation();
	}
	
	private void updatePirateLocation() {
		// TODO Auto-generated method stub
	 while(myGrid1[xCell][yCell]==true) {
		 if (xCell - (shipLocation.x) < 0)
			 xCell++;
		 else
			 xCell--;
		 
		 if (yCell - (shipLocation.y) < 0)
			 yCell++;
		 else
			 yCell--;
			 
		 }
		
	}

	public Point getPirateLocation() {
		return new Point(xCell,yCell);
	}

}
