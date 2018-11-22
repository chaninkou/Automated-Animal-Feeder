package application;
	
import backend.InformationRetrieve;
import backend.SelectedPetFood;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Retrieve the information for pet food comment
			InformationRetrieve.petFoodimport(InformationRetrieve.petFoodFilePath);
			
			// Calling the home page
			HomeStartPage homePage = new HomeStartPage();
			
			// Calling the menu page
			MenuPage menuPage = new MenuPage();
			
			// Calling the refill page
			RefillPage refillPage = new RefillPage();
			
			// Calling the storage page
			StoragePage storagePage = new StoragePage();
			
			// Calling the feeding log page
			FeedingLogPage feedingLogPage = new FeedingLogPage();
			
			// Calling the feeding log page
			SettingsPage settingsPage = new SettingsPage();
			
			// Calling the loading screen page
			LoadingScreen loadingScreen = new LoadingScreen();
			
			// Calling the what to dispense page
			WhatToDispensePage whatToDispensePage = new WhatToDispensePage();

			// Making a new button for the foodFromRefillingPage button from menuPage
			Button[] foodFromRefillPageButton = whatToDispensePage.getFoodFromRefillingPage();
			
			Scene scene = new Scene(homePage);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			// Calling the method for the on click to the menu page
			homePageController(menuPage, scene, homePage);
			
			// Menu page
			menuPageController(menuPage, scene, homePage, refillPage, storagePage, feedingLogPage,settingsPage, whatToDispensePage);
			
			// Refill page
			refillPageController(menuPage, scene, refillPage, whatToDispensePage);
			
			// Storage Page
			storagePageController(menuPage, scene, storagePage);
			
			// Feeding log page
			feedingLogPageController(menuPage, scene, feedingLogPage);
			
			//Setting Page Controller
			settingPageController(menuPage,scene,settingsPage);
			
			// A controller for the loading screen page
			loadingScreenController(scene, feedingLogPage, loadingScreen);
			
			// Controller for what to dispense page
			whatToDispensePageController(menuPage, scene, loadingScreen, whatToDispensePage, foodFromRefillPageButton);
			
			primaryStage.setScene(scene);
			primaryStage.setWidth(1200);
			primaryStage.setHeight(700);
	        
			// The user will not be able to maximize the screen
			primaryStage.setResizable(false);
			
			// Putting icon
			primaryStage.getIcons().add(new Image("backgroundPicture/animalIcon.png"));
			
			// Setting the title
			primaryStage.setTitle("AAF");
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// When the user click the screen, it will go to menuPage
	public void homePageController(MenuPage menuPage, Scene scene, HomeStartPage homePage){
		homePage.setOnMouseClicked(e -> {
			scene.setRoot(menuPage);
			
		});
		
	}
	
	// This is for the menu page
	public void menuPageController(MenuPage menuPage, Scene scene, HomeStartPage homePage, RefillPage refillPage, StoragePage storagePage, FeedingLogPage feedingLogPage,SettingsPage settings, WhatToDispensePage whatToDispensePage){
			menuPage.getToHomePage().setOnAction(e -> scene.setRoot(homePage));
			
			// When user click refill button
			menuPage.getToRefillPage().setOnAction(e -> {
				scene.setRoot(refillPage);
			});
			
			// When user click storage button
			menuPage.getToStoragePage().setOnAction(e -> {
				scene.setRoot(storagePage);
			});
			
			// When user click the feeding log button
			menuPage.getToFeedingLogPage().setOnAction(e -> {
				scene.setRoot(feedingLogPage);
			});

			//When user clicks the settings button
			menuPage.getToSettingsPage().setOnAction(e -> {
				scene.setRoot(settings);
			});	

			//When user clicks the dispense button
			menuPage.getDispenseButton().setOnAction(e -> {
				scene.setRoot(whatToDispensePage);
			});	
			
			// Making a array of delete button
			Button[] deleteButtons = menuPage.getRemoveFoodFromRefillingPage();
			
			// If the first button was clicked, then delete first picture
			if (deleteButtons[0] != null){
				deleteButtons[0].setOnAction(event -> {
					SelectedPetFood.deletePetFood(0);
					menuPage.changeDefaultDisplayPetFood();
					scene.setRoot(menuPage);
				});
			}
			
			// If the second button was clicked, then delete first picture
			if (deleteButtons[1] != null){
				deleteButtons[1].setOnAction(event -> {
					SelectedPetFood.deletePetFood(1);
					menuPage.changeDefaultDisplayPetFood();
					scene.setRoot(menuPage);
				});
			}
			
			// If the third button was clicked, then delete first picture
			if (deleteButtons[2] != null){
				deleteButtons[2].setOnAction(event -> {
					SelectedPetFood.deletePetFood(2);
					menuPage.changeDefaultDisplayPetFood();
					scene.setRoot(menuPage);
				});
			}
	}
	
	// This is for the refill page
	public void refillPageController(MenuPage menuPage, Scene scene, RefillPage refillPage, WhatToDispensePage whatToDispensePage) {
		refillPage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
		refillPage.getSelectedButton().setOnAction(e -> {
			SelectedPetFood.addPetFood(RefillPage.selectedPicture);
			
			// Call this when user select pet food
			menuPage.changeDefaultDisplayPetFood();
			whatToDispensePage.changeDefaultDisplayPetFood();
			
			scene.setRoot(menuPage);
		});
	}
	
	// This is for the storage page
	public void storagePageController(MenuPage menuPage, Scene scene, StoragePage storagePage) {
		storagePage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
	}
	
	// This is for the feeding log page
	public void feedingLogPageController(MenuPage menuPage, Scene scene, FeedingLogPage feedingLogPage) {
		feedingLogPage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
	}
	
	// This is for settings page
	public void settingPageController(MenuPage menuPage, Scene scene, SettingsPage settingsPage) {
		settingsPage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
	}
	
	
	// This is the controller for the loading screen 
	public void loadingScreenController(Scene scene, FeedingLogPage feedingLogPage, LoadingScreen loadingScreen){
		loadingScreen.getFinished().setOnAction(e -> {
			scene.setRoot(feedingLogPage);
		});
	}
	
	// Controller for what to dispense page
	public void whatToDispensePageController(MenuPage menuPage, Scene scene,LoadingScreen loadingScreen, WhatToDispensePage whatToDispensePage, Button[] foodFromRefillPageButton) {
		whatToDispensePage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
		
		// For the first choice
		foodFromRefillPageButton[0].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[0] != null){
				scene.setRoot(loadingScreen);
				loadingScreen.loadingBar(90000000);
			}
		});
		
		// For the second choice
		foodFromRefillPageButton[1].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[1] != null){
				scene.setRoot(loadingScreen);
				loadingScreen.loadingBar(90000000);
			}
		});
		
		// For the third choice
		foodFromRefillPageButton[2].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[2] != null){
				scene.setRoot(loadingScreen);
				loadingScreen.loadingBar(90000000);
			}
		});
		
	}
	

	
}
