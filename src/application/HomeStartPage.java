package application;

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
		Image image = new Image("dataBase/backgroundPicture/bobbyHome.jpg");
		
		// Setting the image view
		ImageView imageView = new ImageView(image);
		
		Label label = new Label();
		label.setGraphic(imageView);
		label.setMinHeight(700);
		label.setMinWidth(800);
		
		
		message.setId("");
		
		VBox vbox = new VBox();
		vbox.getChildren().add(message);

		getChildren().addAll(imageView,vbox);
	
	}
}
