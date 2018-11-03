package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuPage extends BorderPane{
	private Button refill;
	private Button storage;
	private Button feedingLog;
	
	
	public MenuPage(){
		Image image = new Image("dataBase/backgroundPicture/menuPage.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(620);
		imageView.setFitWidth(1150);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		// Calling the main Menu
		mainMenu();
	}
	
	public void mainMenu(){
		// Creating a HBox
		HBox hbox = new HBox();
		
		// Making a refill button
		refill = new Button("Refill");
		refill.setId("refill");
		
		// Making a storage button
		storage = new Button("Storage");
		storage.setId("storage");
		
		// Making a feeding log button
		feedingLog = new Button("FeedLog");
		feedingLog.setId("feedingLog");
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(refill,storage,feedingLog);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
	}
}
