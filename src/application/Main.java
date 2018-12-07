package application;
	
import java.util.Optional;
import java.util.function.Supplier;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import backend.FeedLogInformation;
import backend.InformationRetrieve;
import backend.SelectedPetFood;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


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
			
			// Calling the dispense selection
			FeedLogInformation feedLogInformation = new FeedLogInformation();
			
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
			settingPageController(menuPage,scene,settingsPage,feedingLogPage,feedLogInformation);
			
			// A controller for the loading screen page
			loadingScreenController(scene, feedingLogPage, loadingScreen);
			
			// Controller for what to dispense page
			whatToDispensePageController(menuPage, scene, loadingScreen, whatToDispensePage, foodFromRefillPageButton, feedLogInformation, feedingLogPage);
			
			primaryStage.setScene(scene);
			primaryStage.setWidth(1800);
			primaryStage.setHeight(1000);
	        
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
					
					// Update the display of the pet food when user press delete on menu page
					menuPage.changeDefaultDisplayPetFood();
					
					// Update the display of the pet food in dispense page when user press delete on menu page
					whatToDispensePage.changeDefaultDisplayPetFood();
					scene.setRoot(menuPage);
				});
			}
			
			// If the second button was clicked, then delete first picture
			if (deleteButtons[1] != null){
				deleteButtons[1].setOnAction(event -> {
					SelectedPetFood.deletePetFood(1);
					
					// Update the display of the pet food when user press delete on menu page
					menuPage.changeDefaultDisplayPetFood();
					
					// Update the display of the pet food in dispense page when user press delete on menu page
					whatToDispensePage.changeDefaultDisplayPetFood();
					scene.setRoot(menuPage);
				});
			}
			
			// If the third button was clicked, then delete first picture
			if (deleteButtons[2] != null){
				deleteButtons[2].setOnAction(event -> {
					SelectedPetFood.deletePetFood(2);
					
					// Update the display of the pet food when user press delete on menu page
					menuPage.changeDefaultDisplayPetFood();
					
					// Update the display of the pet food in dispense page when user press delete on menu page
					whatToDispensePage.changeDefaultDisplayPetFood();
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
	public void settingPageController(MenuPage menuPage, Scene scene, SettingsPage settingsPage,FeedingLogPage feedingLogPage,FeedLogInformation feedLogInformation) {
		settingsPage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
		
		settingsPage.timer.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<Event>() {
			Boolean clicked = true;
			@Override
			public void handle(Event event) {
				if (clicked == true) {	
					
//					JOptionPane.showMessageDialog(
//			                 ((Supplier<JDialog>) () -> {final JDialog dialog = new JDialog(); dialog.setAlwaysOnTop(true); return dialog;}).get()
//			                 , "Enter your countdown Timer");	
//			       
//					int seconds =Integer.parseInt(JOptionPane.showInputDialog("Please enter in seconds"));
							
							TextInputDialog dialog = new TextInputDialog("Countdown");

							dialog.setTitle("Countdown!");
							dialog.setHeaderText("Enter your time in seconds:");
							dialog.setContentText("Seconds");
							
							
							DialogPane dialogPane = dialog.getDialogPane();
							dialogPane.getStylesheets().add(
						    getClass().getResource("application.css").toExternalForm());
							dialogPane.getStyleClass().add("dialog-pane");

							Optional<String> result = dialog.showAndWait();
							
							Integer seconds = Integer.valueOf(result.get());
							
							result.ifPresent(Integer -> {
								
								timer(seconds,feedingLogPage,feedLogInformation);

							  System.out.print(Integer);
							});

//					

					}
				}
				
			}
		);
	}
	public void timer(int seconds , FeedingLogPage feedingLogPage, FeedLogInformation feedingLogInformation ) {
		for(int i = seconds; i>=0; i--) {
			try {
				if(i >0) {
					Thread.sleep(1000);
					System.out.println(i);
				}
				else {
					TextInputDialog dialog = new TextInputDialog("Countdown");
					dialog.setTitle("Select your food choice!");
					dialog.setHeaderText("Enter 1,2, or 3:");
					dialog.setContentText("Enter Here");
					
					DialogPane dialogPane2 = dialog.getDialogPane();
					dialogPane2.getStylesheets().add(
				    getClass().getResource("application.css").toExternalForm());
					dialogPane2.getStyleClass().add("dialog-pane");

					Optional<String> result = dialog.showAndWait();
					Integer foodChoice = Integer.valueOf(result.get());
					
					
					if(foodChoice ==1) {
						FeedLogInformation.addDispense(0);
						feedingLogPage.updatedLog();			
						
					}
					else if (foodChoice ==2) {
						FeedLogInformation.addDispense(1);
						feedingLogPage.updatedLog();
					}
					else if(foodChoice ==3) {
						FeedLogInformation.addDispense(2);
						feedingLogPage.updatedLog();	
					}
					else {
						FeedLogInformation.addDispense(0);
						feedingLogPage.updatedLog();
					}
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("AAF Will now Dispense food " + foodChoice);
					
					DialogPane dialogPane = alert.getDialogPane();
					dialogPane.getStylesheets().add(
				    getClass().getResource("application.css").toExternalForm());
					dialogPane.getStyleClass().add("dialog-pane");
					
					
					alert.showAndWait();
			
					
						
					}

					
				}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// This is the controller for the loading screen 
	public void loadingScreenController(Scene scene, FeedingLogPage feedingLogPage, LoadingScreen loadingScreen){
		loadingScreen.getFinished().setOnAction(e -> {
			scene.setRoot(feedingLogPage);
		});
	}
	
	// Controller for what to dispense page
	public void whatToDispensePageController(MenuPage menuPage, Scene scene,LoadingScreen loadingScreen, WhatToDispensePage whatToDispensePage, Button[] foodFromRefillPageButton, FeedLogInformation feedLogInformation, FeedingLogPage feedingLogPage) {
		whatToDispensePage.getToMenuPage().setOnAction(e -> scene.setRoot(menuPage));
		int loadingTime = 100000000;
		
		// For the first choice
		foodFromRefillPageButton[0].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[0] != null){
				// Adding the first choice of pet food into the array list
				FeedLogInformation.addDispense(0);
				feedingLogPage.updatedLog();
				System.out.println(feedLogInformation.toString());
				scene.setRoot(loadingScreen);
				
				// This is for the time it loads
				loadingScreen.loadingBar(loadingTime);
			}
		});
		
		// For the second choice
		foodFromRefillPageButton[1].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[1] != null){
				// Adding the second choice of pet food into the array list
				FeedLogInformation.addDispense(1);
				feedingLogPage.updatedLog();
				// Printing it out on console to check if its working
				System.out.println(feedLogInformation.toString());
				scene.setRoot(loadingScreen);
				
				// This is for the time it loads
				loadingScreen.loadingBar(loadingTime);
			}
		});
		
		// For the third choice
		foodFromRefillPageButton[2].setOnAction(e -> {
			if(SelectedPetFood.petFoodArray[2] != null){
				// Adding the third choice of pet food into the array list
				FeedLogInformation.addDispense(2);
				feedingLogPage.updatedLog();
				// Printing it out on console to check if its working
				System.out.println(feedLogInformation.toString());
				scene.setRoot(loadingScreen);
				
				// This is for the time it loads
				loadingScreen.loadingBar(loadingTime);
			}
		});
		
	}
	

	
}
