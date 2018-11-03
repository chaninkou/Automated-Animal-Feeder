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
		Image image = new Image("dataBase/backgroundPicture/homePage.jpg");
		
		// Setting the image view
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(620);
		
		imageView.setFitWidth(1110);
		
		imageView.setPreserveRatio(false);
		
		imageView.setSmooth(true);
		
		imageView.setCache(true);
		
		Label title = new Label("Automated Animal Feeder");
		Label message = new Label("Welcome, press anywhere to start!");
		
		VBox pane = new VBox();
		// Make this center
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(title, message);
		

		getChildren().addAll(imageView,pane);
		
	
	}
}
