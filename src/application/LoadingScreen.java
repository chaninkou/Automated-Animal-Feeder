package application;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoadingScreen extends BorderPane {
	
	private Button finished;
	private Label pleaseWait;
	
	public LoadingScreen(){
		//Gif of dog running.
		Image image = new Image("backgroundPicture/dogRunning.gif");
		ImageView imageView = new ImageView(image);
		
		imageView.setFitHeight(1000);
		imageView.setFitWidth(1800);
		imageView.setPreserveRatio(false);
		imageView.setSmooth(true);
		imageView.setCache(true);
		VBox pane = new VBox();
		
		pane.getChildren().add(imageView);

		getChildren().add(pane);
		
		finished = new Button ("Click to finish");
		finished.getStyleClass().add("finishedButton");
	}
	
	public void loadingBar(int loadingTime){
		// Don't show the finished button yet
		finished.setVisible(false);
		
		VBox box = new VBox();
			
		Task task = new Task<Void>(){
			
			// How to update the loading bar frame by frame
			@Override
			protected Void call() throws Exception {
				// TODO Auto-generated method stub
				int fullBar = loadingTime;
				for(int k = 0; k <= fullBar; k++){
					// Update the progress
					updateProgress(k, fullBar);
					
					// If it's 100%
					if(k == fullBar){
						// show the finished button when it's done
						finished.setVisible(true);
					}
				}
				
				return null;
			}
		};
		
		ProgressBar progressBar = new ProgressBar();
		progressBar.setMinWidth(1700);
		progressBar.setMinHeight(80);
		progressBar.progressProperty().bind(task.progressProperty());
		
		// Styling the progress bar
		progressBar.setId("progressBar");
		progressBar.getStyleClass().add("progressBar");
		
		// Need this or else it would never start
		new Thread(task).start();
		
		box.getChildren().addAll(progressBar, finished);
		
		box.setPadding(new Insets(100,40,40,50));
		box.setSpacing(10);
		
		setBottom(box);
	}
	
	public Button getFinished(){
		return finished;
	}
}
