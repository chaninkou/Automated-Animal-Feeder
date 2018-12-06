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

public class StoragePage extends BorderPane{
	private Button toMenuPage;
	private Button testB;
	private Button testC;
	private Button testD;
	private Button testE;
	private Button testF;
	private Button testG;
	private Button testH;
	private Button testI;
	private Button testJ;	
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
		listButton[0] = new Button();
		this.selectedButton = listButton[0];
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		topPart();
		centerPart();

	}
	
	public void topPart(){
		HBox hbox = new HBox();
		toMenuPage = new Button("Back");
		toMenuPage.setId("back");
		toMenuPage.getStyleClass().add("backButtons");
		
		testB = new Button("Test");
		
		testB.setId("test"); 
		testB.getStyleClass().add("test");
		
		testC = new Button("Test");
		
		testC.setId("testC"); 
		testC.getStyleClass().add("test");
		
		testD = new Button("Test");
		testD.setId("testC"); 
		testD.getStyleClass().add("test");
		
		testE = new Button("Test");
		testE.setId("testC"); 
		testE.getStyleClass().add("test");
		
		GridPane gpan = new GridPane();
		gpan.add(testB, 0, 0);
		gpan.add(testC, 1, 0);
		gpan.add(testD, 2, 0);
		gpan.add(testE, 0, 1);
		
		
		hbox.setPadding(new Insets(30, 0, 0, 50));
		hbox.setSpacing(100);
		hbox.setAlignment(Pos.TOP_LEFT);
	
		hbox.getChildren().addAll(toMenuPage);
//		setCenter(gpan);
		setTop(hbox);
//		setBottom(hbox);
//		this.set
	}
	
	
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
    
    public Button getSelectedButton(){
    	return selectedButton;
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
		int index = 0;
//		Button[][] b = new Button[3][3];
		// Making two for loops to display the pet food picture by 3 rows and 3 columns
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				Button temp = new Button("100%");
//				Button b1 = b[row][column];
				// We need this to set the id to the current index
				temp.setId(Integer.toString(index));
				listButton[index] = temp;
				
				// When we click the picture/button, it will activate the event and update the current picture information
				temp.setOnAction(event -> {
					// Updating which one the user currently selecting
					int x = Integer.parseInt(this.listButton[Integer.parseInt(temp.getId())].getText());
					this.listButton[x].setText(String.valueOf((x - 20) > 0? (x - 20): 0));
				});
				
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
    
	public ScrollPane scrollPage(GridPane gridpane) {
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setPrefSize(500, 300);
		
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		scrollPane.setPadding(new Insets(0, 0, 0, 0));
		
		scrollPane.setMaxSize(1000, 600);
		
		scrollPane.setContent(gridpane);
		
		return scrollPane;
	}
    
	
}