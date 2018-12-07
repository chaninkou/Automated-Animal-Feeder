package application;

import java.util.List;

import javax.swing.JOptionPane;

import backend.PetFood;
import backend.SelectedPetFood;
import backend.storageInformation;
import backend.DispenseSelection;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StoragePage extends BorderPane{
	private Button toMenuPage;
	private int index;
	
	private Button selectedButton;
	private Button[] listButton = new Button[9];
	private List<PetFood> petFoodList = SelectedPetFood.petFoodList;
	
	public StoragePage(){
		Image image = new Image("backgroundPicture/storagePage.png");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(1000);
		imageView.setFitWidth(1800);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		this.selectedButton = new Button();
		
		for (int i = 0; i < listButton.length; i++) {
			listButton[i] = new Button();
		}
		
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		topPart();
		centerPart();
//		bottomPart();

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
	
	
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
    
    public Button getSelectedButton(){
    	return selectedButton;
    }
    
    public Button[] getListButton(){
    	return listButton;
    }
    
    public void centerPart() {
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
		index = 0;
//		Button[][] b = new Button[3][3];
		// Making two for loops to display the pet food picture by 3 rows and 3 columns
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				Button temp = new Button("0%");
//				Button b1 = b[row][column];
				// We need this to set the id to the current index
//				int x = storageInformation.getIndex(index);
//				temp.setText(String.valueOf(x) + "%");
				listButton[index] = temp;
				
//				temp.setText(String.valueOf(listButton[index]) + "%");
//				listButton[index] = Integer.parseInt(temp.getText().substring(0, temp.getText().length() - 1));
				
				// When we click the picture/button, it will activate the event and update the current picture information
//				temp.setOnAction(event -> {
//					temp.setText(String.valueOf(listButton[index]) + "%");
//				});
				
				
				//new
				
				
				
				Image image = new Image(petFoodList.get(index).getImagePath());
				
		        ImageView imageView = new ImageView(image);
		        
				imageView.setFitHeight(300);
				
				imageView.setFitWidth(300);
				
				imageView.setPreserveRatio(false);
				
				imageView.setSmooth(true);
				
				imageView.setCache(true);
		
		        temp.setGraphic(imageView);
		        
		        
		        gridPane.add(temp, column, row);
		        
		        index++;     
			}
		}
		
		this.setCenter(scrollPage(gridPane));
    }
    
//    public int refill(int index) {
//    	int value = listButton[index]; 
//    	value = (value + 20 < 100)? value + 20: 100;
//    	return value;
//    }
//    
//    public int dispanse(int index) {
//    	int value = listButton[index]; 
//    	value = (value - 20 > 0)? value - 20: 0;
//    	return value;
//    }
    
	public ScrollPane scrollPage(GridPane gridpane) {
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setPrefSize(800, 300);
		
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setPadding(new Insets(0, 0, 0, 0));
		
		scrollPane.setMaxSize(1150, 600);
		
		scrollPane.setContent(gridpane);
		
		return scrollPane;
	}
	
//	public void bottomPart(){
//		// Creating a HBox
//		HBox hbox = new HBox();
//
//		Button dispanse = new Button("Dispanse");
//		dispanse.setId("dispanse");
//		dispanse.getStyleClass().add("settingPageButtons");
//		
//		dispanse.addEventHandler(MouseEvent.MOUSE_CLICKED,
//				new EventHandler<Event>() {
//			Boolean clicked = true;
//
//			@Override
//			public void handle(Event event) {
//				if (clicked == true) {	
//					int index = Integer.parseInt(selectedButton.getId());
//					int newvalue = dispanse(index);
//					selectedButton.setText(String.valueOf(newvalue) + "%");
//					listButton[index] = Integer.parseInt(selectedButton.getText().substring(0,selectedButton.getText().length() - 1));
//				} 
//			}
//		});
//		
//		Button refill = new Button("Refill");
//		refill.setId("refill");
//		refill.getStyleClass().add("settingPageButtons");
//		
//		refill.addEventHandler(MouseEvent.MOUSE_CLICKED,
//				new EventHandler<Event>() {
//			Boolean clicked = true;
//
//			@Override
//			public void handle(Event event) {
//				if (clicked == true) {	
//					int index = Integer.parseInt(selectedButton.getId());
//					int newvalue = refill(index);
//					selectedButton.setText(String.valueOf(newvalue) + "%");
//					listButton[index] = Integer.parseInt(selectedButton.getText().substring(0,selectedButton.getText().length() - 1));
//				} 
//			}
//		});
//		
//		hbox.setPadding(new Insets(0,0,30,0));
//		hbox.setSpacing(50);
//		
//		// Setting the buttons to the center
//		hbox.setAlignment(Pos.CENTER);
//		
//		// Adding all the children
//		hbox.getChildren().addAll(refill,dispanse);
//		
//		// Need this to set it to the bottom of the GUI
//		setBottom(hbox);
//	}
    
	
}