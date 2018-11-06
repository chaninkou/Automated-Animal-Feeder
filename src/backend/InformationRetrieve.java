package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InformationRetrieve {
	
//	public static final String petFoodFile = "dataBase/FoodInformation/petFoodData.csv";
	public static final String petFoodFile = "src/dataBase/FoodInformation/petFoodData.csv";
	
//	public static void petFoodimport(String outFile){
//		String line;
//		String[] fields;
//		String imagePath;
//		String name;
//		String petKind;
//		String Ingredient;
//		int dailyFeeding;
//		
//		try {
//			Scanner freader = new Scanner(outFile);
//			while (freader.hasNextLine()) {
//				line = freader.nextLine();
//				fields = line.split(",");
//				imagePath = fields[0];
//				name = fields[1];
//				petKind = fields[2];
//				Ingredient = fields[3];
//				dailyFeeding = Integer.parseInt(fields[4]);
//				SelectedPetFood.petFoodList.add(new PetFood(imagePath,name,petKind,Ingredient,dailyFeeding));
//			}
//			freader.close(); // Close to unlock.
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Retrieve not working");
//		}	
//	}
	
	public static void petFoodimport(String outFile){
		String line = null;
		String[] fields;
		String imagePath;
		String name;
		String petKind;
		String Ingredient;
		int dailyFeeding;
		
		try {
			FileReader fileReader = new FileReader(outFile);
			BufferedReader buffer = new BufferedReader(fileReader);
			while ((line = buffer.readLine()) != null) {
				fields = line.split(",");
				imagePath = fields[0];
				System.out.println(imagePath);
				name = fields[1];
				System.out.println(name);
				petKind = fields[2];
				Ingredient = fields[3];
				dailyFeeding = Integer.parseInt(fields[4]);
				SelectedPetFood.petFoodList.add(new PetFood(imagePath,name,petKind,Ingredient,dailyFeeding));
			}
			buffer.close(); // Close to unlock.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Retrieve not working");
		}	
	}
	
}
