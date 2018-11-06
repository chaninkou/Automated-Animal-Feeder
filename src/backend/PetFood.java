package backend;


public class PetFood {
	private String imagePath;
	private String name;
	private String petKind;
	private String ingredient;
	private int dailyFeeding;
	
	public PetFood(String imagePath, String name, String petKind, String ingredient, int dailyFeeding){
		this.imagePath = imagePath;
		this.name = name;
		this.petKind = petKind;
		this.ingredient = ingredient;
		this.dailyFeeding = dailyFeeding;
		
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getName() {
		return name;
	}

	public String getPetKind() {
		return petKind;
	}

	public String getIngredient() {
		return ingredient;
	}

	public int getDailyFeeding() {
		return dailyFeeding;
	}
	
	
	
	
	
	
	
	
}
