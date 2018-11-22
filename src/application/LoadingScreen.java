package application;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoadingScreen extends BorderPane {
	
	private Button finished;
	
	
	public LoadingScreen(){
		finished = new Button ("Click to finished");
		
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
		progressBar.setMinWidth(750);
		progressBar.setMinHeight(60);
		progressBar.progressProperty().bind(task.progressProperty());
		
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
