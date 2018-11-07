package backend;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InformationRetrieve {
	
//	public static final String petFoodFile = "dataBase/FoodInformation/petFoodData.csv";
	// This is the file path
	public static final String petFoodFilePath = "src/dataBase/FoodInformation/petFoodData.csv";
	
	// Importing from the csv file
	public static void petFoodimport(String file){
		String line;
		String[] fields;
		String imagePath;
		String name;
		String petKind;
		String Ingredient;
		int dailyFeeding;
		File outFile = new File(file);
		
		try {
			Scanner freader = new Scanner(outFile);
			while (freader.hasNextLine()) {
				line = freader.nextLine();
				fields = line.split(",");
				imagePath = fields[0];
//				System.out.println(imagePath);
				name = fields[1];
//				System.out.println(name);
				petKind = fields[2];
//				System.out.println(petKind);
				Ingredient = fields[3];
//				System.out.println(Ingredient);
				dailyFeeding = Integer.parseInt(fields[4]);
//				System.out.println(dailyFeeding);
				SelectedPetFood.petFoodList.add(new PetFood(imagePath,name,petKind,Ingredient,dailyFeeding));
			}
			freader.close(); // Close to unlock.
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Retrieve not working");
		}	
	}
}
