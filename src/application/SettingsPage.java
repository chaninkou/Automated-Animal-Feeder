package application;

import java.awt.Dimension;
import java.awt.Font;

import java.util.function.Supplier;

import javax.swing.JDialog;

import javax.swing.JOptionPane;

import javax.swing.UIManager;

import backend.FeedLogInformation;
import backend.InformationRetrieve;
import backend.SelectedPetFood;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsPage extends BorderPane {
	private Button toMenuPage;
	Button timer;
	private Button dispenseDuration;
	private int counter;
	
	public SettingsPage(){
		Image image = new Image("backgroundPicture/dogsitting.jpg");
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
		
		Label topMessage = new Label("Settings");
		topMessage.getStyleClass().add("menuTopMessage");
		
		
		hbox.setPadding(new Insets(30, 0, 0, 80));
		hbox.setSpacing(700);
		hbox.setAlignment(Pos.TOP_LEFT);
		
		topMessage.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(toMenuPage,topMessage);
		setTop(hbox);
		
	}
	
	public void bottomPart(){
		// Creating a HBox
		HBox hbox = new HBox();
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500)); 
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 50));
		UIManager.put("TextField.font",new Font("Arial", Font.BOLD,45));
		
		// Making a refill button
		timer = new Button("Timer");
		timer.setId("timer");
		timer.getStyleClass().add("settingPageButtons");
		

		
		
		hbox.setPadding(new Insets(0,0,30,0));
		hbox.setSpacing(50);
		
		// Setting the buttons to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Adding all the children
		hbox.getChildren().addAll(timer);
		
		// Need this to set it to the bottom of the GUI
		setBottom(hbox);
	}
	
	
	
	
	
	
	
	// Returning the value of toMenuPage
    public Button getToMenuPage(){
        return toMenuPage;
    }
	
}