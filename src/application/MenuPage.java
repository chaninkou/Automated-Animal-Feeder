package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuPage extends BorderPane{
	private Button refill;
	private Button storage;
	private Button feedingLog;
	private Button setting;
	private Button toHomePage;
	
	
	
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
		
		// Calling the top Menu
		topPart();
		
		// Calling the bottom Menu
		bottomPart();
	}
	
	public void topPart(){
		HBox hbox = new HBox();
		toHomePage = new Button("Back");
		toHomePage.setId("back");
	
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.TOP_LEFT);
		
		hbox.getChildren().addAll(toHomePage);
		setTop(hbox);
	}
	
	public void bottomPart(){
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
		
		// Making a feeding log button
		setting = new Button("Setting");
		setting.setId("setting");
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(refill,storage,feedingLog, setting);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
	}
	
	
	// Returning the value of toHomePage
    public Button getToHomePage(){
        return toHomePage;
    }
	
}
