package application;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Map;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Alarm {
	Map<Integer,String> numberMap;
	Integer currSeconds; 
	Thread thrd;
	Integer hmsToSeconds(Integer h , Integer m , Integer s) {
		Integer hToSeconds = h*3600;
		Integer mToSeconds = m*60;
		Integer total = hToSeconds + mToSeconds + s;
		return total;
	}
	
	LinkedList<Integer> secondsToHms(Integer currSecond){
		Integer hours = currSecond /3600;
		currSecond = currSecond%3600;
		Integer minutes = currSecond / 60;
		currSecond = currSecond%60;
		Integer seconds = currSecond;
		LinkedList<Integer> answer = new LinkedList<>();
		answer.add(hours);
		answer.add(minutes);
		answer.add(seconds);
		return answer;
	}
	void startCountdown() {
		thrd = new Thread(new Runnable(){
			
		@Override
		public void run() {
			try {
				while(true) {
					//countdown here 
					setOutput();
					Thread.sleep(1000);
					if(currSeconds ==0) {
						thrd.stop();
					}
				}
				
			}
			catch(Exception e){
				
			}
		}
	});
		
//	//public class Alarm {
//	    Scanner scan = new Scanner(System.in);
//	    System.out.println("How much time (In Minutes) ?");
//	    int timet= scan.nextInt() * 60; // Convert to seconds
//	    long delay = timet * 1000;
//
//	    do
//	    {
//	      int minutes = timet / 60;
//	      int seconds = timet % 60;
//	      System.out.println(minutes +" minute(s), " + seconds + " second(s)");
//	      Thread.sleep(1000);
//	      timet = timet - 1;
//	      delay = delay - 1000;
//
//	    }
//	    while (delay != 0);
//	    System.out.println("Time's Up!");
//	  }
//	}
	
	}
	void setOutput() {
		LinkedList<Integer> currHms= secondsToHms(currSeconds);
		System.out.println(currHms.get(0) + "." + currHms.get(1)+ "." + currHms.get(2));
	}
}