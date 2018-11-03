package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Calling the home page
			HomeStartPage homePage = new HomeStartPage();
			
			// Calling the menu page
			MenuPage menuPage = new MenuPage();
			
			Scene scene = new Scene(homePage);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			// Calling the method for the on click to the menu page
			homePageController(menuPage, scene, homePage);
			
			menuController(menuPage, scene, homePage);
			
			
			primaryStage.setScene(scene);
			primaryStage.setWidth(1100);
			primaryStage.setHeight(600);
	        
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
	
	public void menuController(MenuPage menuPage, Scene scene, HomeStartPage homePage){
			menuPage.getToHomePage().setOnAction(e -> scene.setRoot(homePage));
	}

	
}
