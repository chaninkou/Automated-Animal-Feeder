package application;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsPage extends BorderPane {
	private Button toMenuPage;
	private Button timer;
	private Button dispenseDuration;
	
	public SettingsPage(){
		Image image = new Image("backgroundPicture/alarmclock.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(700);
		imageView.setFitWidth(1200);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		topPart();
		bottomPart();
	}
	
	public void topPart(){
		HBox hbox = new HBox();
		toMenuPage = new Button("Back");
		toMenuPage.setId("back");
	
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.TOP_LEFT);
		
		hbox.getChildren().addAll(toMenuPage);
		setTop(hbox);
		
	}
	
	public void bottomPart(){
		// Creating a HBox
		HBox hbox = new HBox();
		
		
		// Making a refill button
		timer = new Button("Set time to dispense.");
		timer.setId("timer");
		
		dispenseDuration = new Button("Set time for the duration of the AAF dispensement.");
		dispenseDuration.setId("dispenseDuration");
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(timer,dispenseDuration);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
	}
	
	
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}
