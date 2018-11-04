package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int month;
	private int day;
	private int year; 
	
	private String dogName;
	private String dogFoodBrand;
	private List<String> list;
	
	public FeedLog(String dogNameIn,String dogFoodBrandIn, String dateOfFeedingIn) {
		dogName = dogNameIn;
		dogFoodBrand = dogFoodBrandIn;
		
		list = new ArrayList<String>();
		
		String [] a = dateOfFeedingIn.split("/");
		month = Integer.parseInt(a[0]);
		day = Integer.parseInt(a[1]);
		year = Integer.parseInt(a[2]);
		
	}
	
	public String getDogName() {
		return dogName;
	}
	public String getDogFoodBrand() {
		return dogFoodBrand;
	}
	public String getDate(){
		String date = month + "/" + day + "/" + year;
		return date;
	}
	
	public void setDate(String date) {
		String [] a = date.split("/");
		month = Integer.parseInt(a[0]);
		day = Integer.parseInt(a[1]);
		year = Integer.parseInt(a[2]);
	}
	
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public void setDogfoodBrand (String dogFoodBrand) {
		this.dogFoodBrand = dogFoodBrand;
	}
	
	public String toString() {
		return dogName + " ate " + dogFoodBrand + " on " + getDate(); 
	}
	
	public void addAnimalLog(String animal) {
		list.add(animal);
	}
	public void deleteAnimal(String course) {
		list.remove(course);
	}
	

}
