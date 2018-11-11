package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HomeStartPage extends StackPane{
	private Text timeMessage;
	
	public HomeStartPage() {
		// Getting the path to the image
		Image image = new Image("dataBase/backgroundPicture/homePage.jpg");
		
		// Setting the image view
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(700);
		
		imageView.setFitWidth(1200);
		
		imageView.setPreserveRatio(false);
		
		imageView.setSmooth(true);
		
		imageView.setCache(true);
		
		Label title = new Label("Automated Animal Feeder");
		Label message = new Label("Welcome, press anywhere to start!");
		title.getStyleClass().add("title");
		message.getStyleClass().add("message");
		
		realTime();
		
		VBox pane = new VBox();
		// Make this center
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(title, message, timeMessage);
		

		getChildren().addAll(imageView,pane);
		
	}
	
	private void realTime() {
		// Text message
		timeMessage = new Text();
		timeMessage.getStyleClass().add("timeMessage");
		
		// Formating for the date
		DateFormat timeFormat = new SimpleDateFormat("EEE, hh:mm:ss aa");
		
		// Getting the real time
		Timeline gettingRealTime = new Timeline(
				// Start the time right away
				new KeyFrame(Duration.seconds(0),
						actionEvent -> {
							// Getting the current time
							Calendar currentTime = Calendar.getInstance();
							timeMessage.setText(timeFormat.format(currentTime.getTime()));
						}
						// Showing 1 second at a time
					), new KeyFrame(Duration.seconds(1))
				);
		
		gettingRealTime.setCycleCount(Animation.INDEFINITE);
		gettingRealTime.play();
	}
	
	
}
