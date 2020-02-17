package application;
import java.util.*;

public class Pirates implements Observer {


	@Override
	public void update(Observable obj, Object arg) {
		
		System.out.println("Observer1 is added");
		
	}

}
