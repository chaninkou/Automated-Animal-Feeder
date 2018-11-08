package application;

import java.util.List;

import backend.PetFood;
import backend.SelectedPetFood;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RefillPage extends BorderPane{
	private Button toMenuPage;
	private List<PetFood> petFoodList = SelectedPetFood.petFoodList;
	
	
	public RefillPage(){
		Image image = new Image("dataBase/backgroundPicture/refillPage.jpg");
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
		
		// Trying to make this work
		setCenter(scrollPage(gridPanePetFood(petFoodList)));

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
	public ScrollPane scrollPage(GridPane gridpane) {
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setPrefSize(500, 300);
		
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setPadding(new Insets(0, 0, 0, 0));
		
		scrollPane.setMaxSize(710, 400);
		
		scrollPane.setContent(gridpane);
		
		return scrollPane;
	}
	
	public GridPane gridPanePetFood(List<PetFood> petFoodList){
		GridPane gridPane = new GridPane();
		
		// The gap between the pictures
		gridPane.setHgap(15);
		
		// The gap between the pictures
		gridPane.setVgap(15);
		
		// Setting center, but doesn't really need this
        gridPane.setAlignment(Pos.CENTER);
        
        // To make the spacing looks nice
        gridPane.setPadding(new Insets(10,10,10,10));
		
        // A counter to keep track of the which pictures to display
		int index = 0;
		
		// Making two for loops to display the pet food picture by 3 rows and 3 columns
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				Button buttonImage = new Button();
				buttonImage.setOnAction(event -> {
					
				});
				
				Image image = new Image(petFoodList.get(index).getImagePath());
				
		        ImageView imageView = new ImageView(image);
		        
				imageView.setFitHeight(200);
				
				imageView.setFitWidth(200);
				
				imageView.setPreserveRatio(false);
				
				imageView.setSmooth(true);
				
				imageView.setCache(true);
		
		        buttonImage.setGraphic(imageView);
		        
		        gridPane.add(buttonImage, column, row);
		        
		        index++;     
			}
		}
        
		return gridPane;
	}
	
	
	
	
	
	
	
	
	
	
	

	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}