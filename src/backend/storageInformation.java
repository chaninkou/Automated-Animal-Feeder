package backend;

public class storageInformation {
	public static int[] petFoodListStorage = new int[SelectedPetFood.petFoodList.size()];
	
	public storageInformation() {
		for(int i = 0; i < petFoodListStorage.length; i++) {
			petFoodListStorage[i] = 100;
		}
	}
	
	public static void refillPetFoodListStorage (PetFood petFood) {
		for (int i = 0; i < SelectedPetFood.petFoodList.size(); i++) {
			if (SelectedPetFood.petFoodList.get(i).getName().equals(petFood.getName()))
			{
				setIndex(i, 100);
				break;
			}
		}
	}
	
	public static void dispensePetFoodStorage(int index) {
		int newvalue = (petFoodListStorage[index] - 20 > 0)? petFoodListStorage[index] - 20: 0;
		setIndex(index, newvalue);
	}
	
	public static void setIndex(int index, int value) {
		petFoodListStorage[index] = value;
	}
	
	public static int getPetFoodStorage(int index) {
		return petFoodListStorage[index];
	}
	
	public static int getIndex(PetFood petFood) {
		for (int i = 0; i < SelectedPetFood.petFoodList.size(); i++) {
			if (SelectedPetFood.petFoodList.get(i).getName().equals(petFood.getName()))
			{
				return i;
			}
		}
		return -1;
	}
}
