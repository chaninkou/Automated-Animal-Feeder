package application;

import java.util.List;

import javax.swing.JOptionPane;

import application.Alarm;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsPage extends BorderPane {
	private Button toMenuPage;
	private Button timer;
	private Button dispenseDuration;
	private int counter;
	
	public SettingsPage(){
		Image image = new Image("backgroundPicture/alarmclock.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(1000);
		imageView.setFitWidth(1800);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		topPart();
		bottomPart();
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
	
	public void bottomPart(){
		// Creating a HBox
		HBox hbox = new HBox();
		
		
		// Making a refill button
		timer = new Button("Count Down.");
		timer.setId("timer");
		timer.getStyleClass().add("settingPageButtons");
		
		timer.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<Event>() {
			Boolean clicked = true;

			@Override
			public void handle(Event event) {
				if (clicked == true) {	

					int seconds =Integer.parseInt(JOptionPane
							.showInputDialog("Please enter the seconds"));
					
					for(int i = seconds; i>=0; i--) {
						try {
							if(i >0) {
								Thread.sleep(1000);
								System.out.println(i);
							}
							else {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setHeaderText(null);
								alert.setContentText("AAF Will now Dispense");
								
								alert.showAndWait();
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				} 
			}
		});
		
		
		
		dispenseDuration = new Button("Set time for the duration of the AAF dispensement.");
		dispenseDuration.setId("dispenseDuration");
		dispenseDuration.getStyleClass().add("settingPageButtons");
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(timer,dispenseDuration);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
	}
	
	
	
	
	
	
	
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}
