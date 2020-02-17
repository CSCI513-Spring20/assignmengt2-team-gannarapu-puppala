package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
	 int scale =50;
	 int xcor =6;
	 int ycor =6;
	 boolean[][] myGrid = new boolean[10][10];
	 Pirates pirates;
	 
	 

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
			loadImage("\\island.jpg");
		}		
		loadImage("\\pirateShip.png");
		loadImage("\\pirateShip.png");
		loadImage("\\ship.png");
		loadImage("\\pirateIsland.png");
		loadImage("\\pirateIsland.png");
		
		
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			 @Override
			 public void handle(KeyEvent ke) {
			switch(ke.getCode()){
			case RIGHT:
				ship.goEast(oceanMap.getImageLocation().x*scale, oceanMap.getImageLocation().y*scale);
				ship.incre();
			break;  
			case LEFT:
				ship.goWest(oceanMap.getImageLocation().x*scale, oceanMap.getImageLocation().y*scale);
				ship.incre();
			break;
			case UP:
				ship.goNorth(oceanMap.getImageLocation().x*scale, oceanMap.getImageLocation().y*scale);
				ship.incre();
			break;
			case DOWN:
				ship.goSouth(oceanMap.getImageLocation().x*scale, oceanMap.getImageLocation().y*scale);
				ship.incre();
			break;
			default:
			break;
			}
			imageView.setX(ship.getShipLocation().x);
			imageView.setY(ship.getShipLocation().y);
			oceanMap.setFinal(ship.getShipLocation().x/50,ship.getShipLocation().y/50);
			}
			 });
			}

	private void loadImage (String url) {
		Image image = new Image(url,50,50,true,true);
		imageView = new ImageView(image);
		System.out.println(oceanMap.getImageLocation().x);
		System.out.println(oceanMap.getImageLocation().y);	
		imageView.setX(oceanMap.getImageLocation().x * scale);
		imageView.setY(oceanMap.getImageLocation().y * scale);
		
		anchorPane.getChildren().add(imageView);

	}

	
	
}
