package application;

import backend.SelectedPetFood;
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
	private Button setting;
	private Button dispense;
	private Button toHomePage;
	private Button[] foodFromRefillingPage = new Button[3];
	
	
	
	
	public MenuPage(){
		Image image = new Image("dataBase/backgroundPicture/menuPage.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(700);
		imageView.setFitWidth(1200);
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
		
		// Calling the bottom Menu
		bottomPart();
	}
	
	// All this is just a back button on top that goes back to home page.
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
	
	// Displaying the center 3 boxes of food that are selected from refilling page.
	public void displayPetFood(){
		HBox hbox = new HBox();
		
		// 3 since petFoodArray.length from SelectedPetFood is 3
		for(int k = 0; k < foodFromRefillingPage.length; k++){
			// Making a button
			Button selectedBoxInMenu = new Button();
			// Will do CSS for this
			// selectedBoxInMenu.getStyleClass().add("selectedBoxInMenu");
			
			if(k == 0){
				selectedBoxInMenu.setText("Please press Refill to selected the first Pet Food");
			}else if(k == 1){
				selectedBoxInMenu.setText("Please press Refill to selected the second Pet Food");
			}else{
				selectedBoxInMenu.setText("Please press Refill to selected the third Pet Food");
			}
		
			this.foodFromRefillingPage[k] = selectedBoxInMenu;
			hbox.getChildren().add(selectedBoxInMenu);
		}
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.CENTER);
		
		setCenter(hbox);
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
		feedingLog = new Button("Feeding Log");
		feedingLog.setId("feedingLog");
		
		// Making a feeding log button
		setting = new Button("Setting");
		setting.setId("setting");
		
		// Making a feeding log button
		dispense = new Button("DISPENSE");
		
		dispense.setId("dispense");
		dispense.getStyleClass().add("dispense");
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(refill,storage,feedingLog, setting, dispense);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
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
				
				imageView.setFitHeight(200);
				imageView.setFitWidth(200);
				imageView.setPreserveRatio(false);
				imageView.setSmooth(true);
				imageView.setCache(true);
				
				// Make sure to set the default text to nothing
				foodFromRefillingPage[k].setText(null);
				
				foodFromRefillingPage[k].setGraphic(imageView);
			} else {
				// Set the image to null and still display the rest of the image
				System.out.println("testing");
				if(k == 0){
					foodFromRefillingPage[k].setText("Please press Refill to selected the first Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}else if(k == 1){
					foodFromRefillingPage[k].setText("Please press Refill to selected the second Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}else{
					foodFromRefillingPage[k].setText("Please press Refill to selected the third Pet Food");
					foodFromRefillingPage[k].setGraphic(null);
				}
			}
		}
	}
	
	
	
	// Returning the value of toHomePage
    public Button getToHomePage(){
        return toHomePage;
    }
    
    // Returning the value of refill button
    public Button getToRefillPage() {
    	return refill;
    }
    
    // Returning the value of storage button
    public Button getToStoragePage() {
    	return storage;
    }
    
    // Returning the value of storage button
    public Button getToFeedingLogPage() {
    	return feedingLog;
    }
    
    // Returning the value of the foodFromRefillingPage button
    public Button[] getFoodFromRefillingPage(){
    	return foodFromRefillingPage;
    }
    
	
}
