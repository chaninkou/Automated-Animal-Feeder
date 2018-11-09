package application;
	
import backend.InformationRetrieve;
import backend.SelectedPetFood;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Retrieve the information for pet food
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
			
			
			Scene scene = new Scene(homePage);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			// Calling the method for the on click to the menu page
			homePageController(menuPage, scene, homePage);
			
			// Menu page
			menuPageController(menuPage, scene, homePage, refillPage, storagePage, feedingLogPage);
			
			// Refill page
			refillPageController(menuPage, scene, refillPage);
			
			// Storage Page
			storagePageController(menuPage, scene, storagePage);
			
			// Feeding log page
			feedingLogPageController(menuPage, scene, feedingLogPage);
			
			
			primaryStage.setScene(scene);
			primaryStage.setWidth(1200);
			primaryStage.setHeight(700);
	        
			// The user will not be able to maximize the screen
			primaryStage.setResizable(false);
			
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
	public void menuPageController(MenuPage menuPage, Scene scene, HomeStartPage homePage, RefillPage refillPage, StoragePage storagePage, FeedingLogPage feedingLogPage){
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
	}
	
	// This is for the refill page
	public void refillPageController(MenuPage menuPage, Scene scene, RefillPage refillPage) {
		refillPage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
		refillPage.getSelectedButton().setOnAction(e -> {
			SelectedPetFood.addPetFood(RefillPage.selectedPicture);
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
	
	
	

	
}
