package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RefillPage extends BorderPane{
	private Button toMenuPage;
	
	
	public RefillPage(){
		Image image = new Image("dataBase/backgroundPicture/refillPage.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(570);
		imageView.setFitWidth(1100);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		topPart();
		
		// Trying to make this work
		setCenter(scrollPage());

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
	
	// Making a scroll page for the selection of pet food
	public ScrollPane scrollPage() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPrefSize(500, 300);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollPane.setPadding(new Insets(0, 0, 500, 0));
		scrollPane.setMaxSize(500, 300);
		return scrollPane;
	}
	

	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}