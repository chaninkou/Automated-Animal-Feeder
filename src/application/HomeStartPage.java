package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomeStartPage extends StackPane{
	private Text message;
	
	public HomeStartPage() {
		// Getting the path to the image
		Image image = new Image("dataBase/backgroundPicture/bobbyHome.jpg", 1000, 1000, true, true);
		
		// Setting the image view
		ImageView imageView = new ImageView(image);
		imageView.setRotate(imageView.getRotate() + 90); 
		
		
		Label message = new Label("Welcome, press anywhere to start!");
		
		VBox pane = new VBox();
		// Make this center
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(message);
		

		getChildren().addAll(imageView,pane);
		
	
	}
}
