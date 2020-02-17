package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	 Stage stage = new Stage();
	 Pane anchorPane;
	 final int dimensions =10;
	 final int islandCount =10;
	 Scene scene;
	 Image image;
	 ImageView imageView; 
	 OceanMap oceanMap;
	 Ship ship;
	 int z;
	 int scale =50;
	 boolean[][] myGrid = new boolean[10][10];
	 Pirates pirates;
	 
	 java.awt.Point k;
	 int[] shipCor = new int[2];
	 int[] pirateShipCor1 = new int[2];
	 int[] pirateShipCor2 = new int[2];
	 
	 
	 

	public static void main(String[] args) {
		launch(args);
		
		
	}
	
	public void start(Stage oceanStage) throws Exception {
		anchorPane = new AnchorPane(); 
		oceanMap = new OceanMap();
		myGrid = oceanMap.getMap(anchorPane);
		scene = new Scene(anchorPane,500,500); 
		ship = new Ship();
		placingImages();
	    oceanStage.setTitle("Christopher Columbus");
	    oceanStage.setScene(scene);
	    oceanStage.show();	
	    pirates = new Pirates();
		ship.addObserver(pirates);
	    startSailing();
		
	}

	private void placingImages() {
		// TODO Auto-generated method stub
		for(int k=0;k<5;k++) {
			loadImage("\\island.jpg",0);
		}
		//loadImage("\\pirateIsland.png",0);
		//loadImage("\\pirateIsland.png",0);
		loadImage("\\pirateShip.png",2);
		//loadImage("\\pirateShip.png",3);
		loadImage("\\ship.png",1);
		System.out.println(Arrays.deepToString(myGrid));
		
		
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			 @Override
			 public void handle(KeyEvent ke) {
			switch(ke.getCode()){
			case RIGHT:
				 z = shipCor[0]+1;
				if(!(myGrid[z][shipCor[1]])) {
				ship.goEast(shipCor);}
			break;  
			case LEFT:
				z = shipCor[0]-1;
				if(!(myGrid[z][shipCor[1]])) {
				ship.goWest(shipCor);}
				//ship.incre();
			break;
			case UP:
				z = shipCor[1]-1;
				if(!(myGrid[shipCor[0]][z])) {
				ship.goNorth(shipCor);}
				ship.incre();
			break;
			case DOWN:
				z = shipCor[1]+1;
				if(!(myGrid[shipCor[0]][z])) {
				ship.goSouth(shipCor);}
				ship.incre();
			break;
			default:
			break;
			}
			imageView.setX(ship.getShipLocation().x);
			imageView.setY(ship.getShipLocation().y);
			//oceanMap.setFinal(ship.getShipLocation().x/50,ship.getShipLocation().y/50);
			}
			 });
			}

	private void loadImage (String url,int det) {
		Image image = new Image(url,48,48,true,true);
		imageView = new ImageView(image);
		k = oceanMap.getImageLocation();
		imageView.setX(k.x * scale);
		imageView.setY(k.y * scale);	
		anchorPane.getChildren().add(imageView);
		if(det == 1) {
			shipCor[0] = k.x;
			shipCor[1] = k.y;
		}
		else if(det == 2) {
			pirateShipCor1[0] = k.x;
			pirateShipCor1[1] = k.y;		
		}
		else if(det == 3) {
			pirateShipCor2[0] = k.x;
			pirateShipCor2[1] = k.y;		
		}
		

	}

	
	
}
