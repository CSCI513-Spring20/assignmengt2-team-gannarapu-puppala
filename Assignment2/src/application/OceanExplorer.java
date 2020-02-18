package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	 Stage stage = new Stage();
	 Pane anchorPane;
	 final int dimensions =10;
	 final int islandCount =10;
	 Scene scene;
	 Scene sceneFinal;
	 Text text;
	 Text text2;
	 Image image;
	 Stage oceanStage;
	 ImageView imageView,imageView1,imageView2 ;
	 OceanMap oceanMap;
	 Ship ship;
	 Group root;
	 int z;
	 int scale =50;
	 boolean[][] myGrid = new boolean[10][10];
	 Pirates pirates = new Pirates();
	 Pirates2 pirates2= new Pirates2();
	 
	 java.awt.Point k;
	 int[] shipCor = new int[2];
	 int[] pirateShipCor1 = new int[2];
	 int[] pirateShipCor2 = new int[2];
	
	 public static void main(String[] args) {
		launch(args);	
	}
	
	public void start(Stage oceanStage){
		anchorPane = new AnchorPane(); 
		oceanMap = new OceanMap();
		myGrid = oceanMap.getMap(anchorPane);
		scene = new Scene(anchorPane,500,500); 
		ship = new Ship();
		placingImages();
	    oceanStage.setTitle("Christopher Columbus");
	    oceanStage.setScene(scene);
	    oceanStage.show();	
	    
	    text = new Text();
	    text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
	    text.setX(100); 
	    text.setY(250);
	    text.setFill(Color.BROWN); 
	    text.setStrokeWidth(2); 
	    text.setStroke(Color.BLUE);         
	    text.setText("Game Over"); 
	    
  
		ship.addObserver(pirates);
		ship.addObserver(pirates2);
	    startSailing();
		
	}

	private void placingImages() {
		// TODO Auto-generated method stub
		for(int k=0;k<5;k++) {
			loadImage("\\island.jpg",0);
		}
		loadImage("\\pirateShip.png",2);
		loadImage("\\pirateShip.png",3);
		loadImage("\\ship.png",1);
		
		
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			 @Override
			 public void handle(KeyEvent ke) {
			switch(ke.getCode()){
			case RIGHT:
				ship.goEast();			
			break;  
			case LEFT:
				ship.goWest();
			break;
			case UP:
				ship.goNorth();
			break;
			case DOWN:
				ship.goSouth();
			break;
			default:
			break;
			}
			imageView.setX(ship.getShipLocation().x*scale);
			imageView.setY(ship.getShipLocation().y*scale);
			ship.storeShipLocation(ship.getShipLocation().x,ship.getShipLocation().y,myGrid);
			imageView1.setX(pirates.getPirateLocation().x*scale);
			imageView1.setY(pirates.getPirateLocation().y*scale);
			pirates.storePirateLocation(pirates.getPirateLocation().x,pirates.getPirateLocation().y, myGrid);
			imageView2.setX(pirates2.getPirateLocation().x*scale);
			imageView2.setY(pirates2.getPirateLocation().y*scale);
			pirates2.storePirateLocation(pirates2.getPirateLocation().x,pirates2.getPirateLocation().y, myGrid);
			if(ship.getShipLocation().equals(pirates.getPirateLocation()) || ship.getShipLocation().equals(pirates2.getPirateLocation())) {
				anchorPane.getChildren().add(text);
			}
			}
			 });
			}

	private void loadImage (String url,int det) {
		Image image = new Image(url,48,48,true,true);	
		k = oceanMap.getImageLocation();
		if(det ==0 || det ==1) {
			imageView = new ImageView(image);
			imageView.setX(k.x * scale);
			imageView.setY(k.y * scale);	
			anchorPane.getChildren().add(imageView);	
		}
		if(det == 1) {
			myGrid[k.x][k.y] =false;
			shipCor[0] = k.x;
			shipCor[1] = k.y;
			ship.storeShipLocation(k.x,k.y,myGrid);
		}
		else if(det == 2) {
			myGrid[k.x][k.y] =false;
			imageView1 = new ImageView(image);
			imageView1.setX(k.x * scale);
			imageView1.setY(k.y * scale);	
			anchorPane.getChildren().add(imageView1);
			pirates.storePirateLocation(k.x,k.y, myGrid);
			pirateShipCor1[0] = k.x;
			pirateShipCor1[1] = k.y;		
		}
		else if(det == 3) {
			myGrid[k.x][k.y] =false;
			imageView2 = new ImageView(image);
			imageView2.setX(k.x * scale);
			imageView2.setY(k.y * scale);	
			anchorPane.getChildren().add(imageView2);
			pirates2.storePirateLocation(k.x,k.y, myGrid);
			pirateShipCor2[0] = k.x;
			pirateShipCor2[1] = k.y;		
		}
	}	
}
