package application;

import backend.FeedLogInformation;
import backend.SelectedPetFood;
import backend.DispenseSelection;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import backend.FeedLogInformation;
import javafx.scene.layout.GridPane;


public class FeedingLogPage extends BorderPane{
	private Button toMenuPage;
	
	
	public FeedingLogPage(){
		Image image = new Image("backgroundPicture/feedingLogPage.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(1000);
		imageView.setFitWidth(1800);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		VBox pane = new VBox();
		
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		//Calls the function that displays the back button for mainpage//
		topPart();
		
		//Calls function that displays out the scroll box for time outputs//
		centerPart();
		
		//Calls function that displays out the "save" and Clear buttons//
		bottomPart();
	}
	
	public void topPart(){
		HBox hbox = new HBox();
		toMenuPage = new Button("Back");
		toMenuPage.setId("back");
		toMenuPage.getStyleClass().add("backButtons");

		
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.TOP_LEFT);
		
		hbox.getChildren().addAll(toMenuPage);
		setTop(hbox);
	}
	
	public void centerPart() {
		VBox messageBox = new VBox();
		VBox content = new VBox();
		ScrollPane scroll = new ScrollPane();
		Label testing = new Label("");
		Label header_one = new Label("Brand");
		Label header_two = new Label("Time");
		HBox headers = new HBox();
		headers.getChildren().addAll(header_one,header_two);
		messageBox.getChildren().addAll(headers,scroll);
		headers.setAlignment(Pos.CENTER);
		headers.setSpacing(400);
		content.getChildren().add(testing);
		
		
		scroll.setMaxSize(500,300);
		scroll.setPrefSize(500,250);
		scroll.setContent(content);
		
		messageBox.setAlignment(Pos.CENTER);
		setCenter(messageBox);
		
	}
	
	public void updatedLog() {
		VBox messageBox = new VBox();
		VBox content = new VBox();
		VBox content_right = new VBox();
		HBox wrapper = new HBox();
		ScrollPane scroll = new ScrollPane();
		Label header_one = new Label("Brand");
		Label header_two = new Label("Time");
		HBox headers = new HBox();
		header_one.setFont(Font.font("Helvetica", 30));
		headers.getChildren().addAll(header_one,header_two);
		int size = FeedLogInformation.dispenseSelection.size();
		Label testing;
		DispenseSelection info;
		for(int x = 0; x < size; x++) {
		info = FeedLogInformation.dispenseSelection.get(x);
		testing = new Label(info.getPetFood().getName());
		content.getChildren().add(testing);
		testing = new Label(""+info.getDate());
		content_right.getChildren().add(testing);
		}
		content.setPadding(new Insets(0,70,0,0));
		wrapper.getChildren().addAll(content,content_right);
		messageBox.getChildren().addAll(headers,scroll);		
		//content.getChildren().add(testing);
		headers.setAlignment(Pos.CENTER);
		headers.setSpacing(400);
		scroll.setMaxSize(500,300);
		scroll.setPrefSize(500,250);
		scroll.setContent(wrapper);
		
		messageBox.setAlignment(Pos.CENTER);
		setCenter(messageBox);
		
	}
	
	public void bottomPart() {
		HBox bottomBox = new HBox();
		//save button//
		Button save = new Button("Save");
		//clear button//
		Button clear = new Button("Clear");
		
		bottomBox.setPadding(new Insets(0,30,30,0));
		bottomBox.setSpacing(50);
		bottomBox.setAlignment(Pos.BOTTOM_CENTER);
		bottomBox.getChildren().addAll(save,clear);
		setBottom(bottomBox);
	}
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}