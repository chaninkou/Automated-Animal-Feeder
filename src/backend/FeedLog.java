package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int month;
	private int day;
	private int year; 
	
	private String petName;
	private String petFoodBrand;
	private List<String> list;
	
	public FeedLog(String petNameIn,String petFoodBrandIn, String dateOfFeedingIn) {
		petName = petNameIn;
		petFoodBrand = petFoodBrandIn;
		
		list = new ArrayList<String>();
		
		String [] a = dateOfFeedingIn.split("/");
		month = Integer.parseInt(a[0]);
		day = Integer.parseInt(a[1]);
		year = Integer.parseInt(a[2]);
		
	}
	
	public String getpetName() {
		return petName;
	}
	public String getDogFoodBrand() {
		return petFoodBrand;
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
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public void setDogfoodBrand (String petFoodBrand) {
		this.petFoodBrand = petFoodBrand;
	}
	
	public String toString() {
		return petName + " ate " + petFoodBrand + " on " + getDate(); 
	}
	
	public void addAnimalLog(String animal) {
		list.add(animal);
	}
	public void deleteAnimal(String course) {
		list.remove(course);
	}
	

}
