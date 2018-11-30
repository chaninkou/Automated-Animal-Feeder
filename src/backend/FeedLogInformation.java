package backend;

import java.util.ArrayList;
import java.util.List;

public class FeedLogInformation {
	public static List<DispenseSelection> dispenseSelection;
	
	// Making an array list to store all the information
	public FeedLogInformation(){
		dispenseSelection = new ArrayList<DispenseSelection>();
	}
	
	// This is for which 3 boxes the user selected, there should be only 3 boxes which the index could only be from 0 to 2
	public static void addDispense(int index){
		dispenseSelection.add(new DispenseSelection(SelectedPetFood.petFoodArray[index]));
	}
	
	// A toString to test in main.java to see if its working
	public String toString(){
		// This is a string 
		String information = "";
		
		for(DispenseSelection current : dispenseSelection){
			// Adding the pet food into the string
			information += current.getPetFood().getName();
			information += ", Time: ";
			
			// Adding the time the user clicked dispense into the string
			information += current.getDate();
			
			// Just adding space
			information += "\n";
		}
		
		return information;
	}
	
}
