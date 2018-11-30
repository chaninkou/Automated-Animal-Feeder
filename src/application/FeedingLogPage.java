package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;

public class FeedingLogPage extends BorderPane{
	private Button toMenuPage;
	
	
	public FeedingLogPage(){
		Image image = new Image("backgroundPicture/feedingLogPage.jpg");
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
		centerPart();
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
	
	public void centerPart() {
		VBox messageBox = new VBox();
		VBox content = new VBox();
		ScrollPane scroll = new ScrollPane();
		Label testing = new Label("Testing");
		
		messageBox.getChildren().add(scroll);
	
		content.getChildren().add(testing);
		
		for(int i = 2; i<45; i++) {
			content.getChildren().add(new Label(i+"testing"));
			
		}
		scroll.setMaxSize(500,300);
		scroll.setPrefSize(500,250);
		scroll.setContent(content);
		
		messageBox.setAlignment(Pos.CENTER);
		setCenter(messageBox);
		
	}
	
	
	
	public void bottomPart() {
		HBox bottomBox = new HBox();
		Button save = new Button("Save");
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