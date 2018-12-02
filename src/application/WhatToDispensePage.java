package application;

import backend.SelectedPetFood;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WhatToDispensePage extends BorderPane{
	private Button toMenuPage;
	private Label title;
	private Button[] foodFromRefillingPage = new Button[3];
	
	
	public WhatToDispensePage(){
		Image image = new Image("backgroundPicture/menuPage.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(1000);
		imageView.setFitWidth(1800);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		// Calling the top Menu
		topPart();
		
		// Calling the middle 3 boxes
		displayPetFood();

	}
	
	// All this is just a back button on top that goes back to home page.
	public void topPart(){
		HBox hbox = new HBox();
		
		// Back to home page button
		toMenuPage = new Button("Back");
		toMenuPage.setId("back");
	
		title = new Label("Select one of the following to dispense");
		
		// Setting for HBox
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.TOP_LEFT);
		
		hbox.getChildren().addAll(toMenuPage, title);
		setTop(hbox);
	}
	
	// Displaying the center 3 boxes of food that are selected from refilling page.
	public void displayPetFood(){
		HBox hbox = new HBox();
		
		// 3 since petFoodArray.length from SelectedPetFood is 3
		for(int k = 0; k < foodFromRefillingPage.length; k++){
			// Making a button
			Button selectedBoxInMenu = new Button();
			
			selectedBoxInMenu.getStyleClass().add("selectedBoxInDispensePage");
			selectedBoxInMenu.setId("selectedBoxInDispensePage" + k);
			
			if(k == 0){
				selectedBoxInMenu.setText("Refill the 1st Pet Food");
			}else if(k == 1){
				selectedBoxInMenu.setText("Refill the 2nd Pet Food");
			}else{
				selectedBoxInMenu.setText("Refill the 3rd Pet Food");
			}
		
			this.foodFromRefillingPage[k] = selectedBoxInMenu;
			hbox.getChildren().add(selectedBoxInMenu);
		}
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.CENTER);
		
		setCenter(hbox);
	}
	
	// Only call this method after user select a pet food from refilling page
	public void changeDefaultDisplayPetFood(){
		// length = 3 since petFoodArray.length from SelectedPetFood is 3
		for(int k = 0; k < foodFromRefillingPage.length; k++){
			if(SelectedPetFood.petFoodArray[k] != null){
				// Getting the image
				Image image = new Image(SelectedPetFood.petFoodArray[k].getImagePath());
				
				// Put the image to view
				ImageView imageView = new ImageView(image);
				
				imageView.setFitHeight(600);
				imageView.setFitWidth(400);
				imageView.setPreserveRatio(false);
				imageView.setSmooth(true);
				imageView.setCache(true);
				
				// Make sure to set the default text to nothing
				foodFromRefillingPage[k].setText(null);
				
				foodFromRefillingPage[k].setGraphic(imageView);
			} else {
				// Set the image to null and still display the rest of the image
				if(k == 0){
					foodFromRefillingPage[k].setText("Refill the 1st Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}else if(k == 1){
					foodFromRefillingPage[k].setText("Refill the 2nd Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}else{
					foodFromRefillingPage[k].setText("Refill the 3rd Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}
			}
		}
		
//		// For future delete button
//		if(foodFromRefillingPage[0].getGraphic() != null){
//			System.out.println("1");
//		}
//		if(foodFromRefillingPage[1].getGraphic() != null){
//			System.out.println("2");
//		}
//		if(foodFromRefillingPage[2].getGraphic() != null){
//			System.out.println("3");
//		}
		
	}
	
	
	
	// Returning the value of toHomePage
    public Button getToMenuPage(){
        return toMenuPage;
    }
    
    
    // Returning the value of the foodFromRefillingPage button
    public Button[] getFoodFromRefillingPage(){
    	return foodFromRefillingPage;
    }
 	
}