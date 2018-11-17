package backend;

import java.util.ArrayList;
import java.util.List;

public class SelectedPetFood {
	public static PetFood[] petFoodArray = new PetFood[3];
	
	public static List<PetFood> petFoodList = new ArrayList<PetFood>();
	
	// Could be only click and select 3 petFood picture
	private final int maxSize = 3;
	
	public SelectedPetFood(){
		// This is working now, we could only select 3 pet food from the filling page.
		petFoodArray = new PetFood[maxSize];
	}
	
	
	public static void addPetFood(PetFood food){
		for (int k = 0; k < petFoodArray.length; k++){
			if(petFoodArray[k] == null){
				petFoodArray[k] = food;
				break;
			}
		}
	}
	
	public String toString(){
		String information = "";
		for (int k = 0; k < petFoodList.size(); k++){
			information += "Name: " + petFoodList.get(k).getName() + "\n"
							+ "Pet Kind: " + petFoodList.get(k).getPetKind() + "\n"
							+ "Ingredient: : " + petFoodList.get(k).getIngredient() + "\n"
							+ "Daily Feeding: " + petFoodList.get(k).getDailyFeeding() + " time(s) a day\n";
		}
		
		return information;
	}
	
	
	
	
}
