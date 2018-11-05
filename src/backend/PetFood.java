package backend;


public class PetFood {
	private String image;
	private String name;
	private String petKind;
	private String ingredient;
	private int dailyFeeding;
	
	public PetFood(String image, String name, String petKind, String ingredient, int dailyFeeding){
		this.image = image;
		this.name = name;
		this.petKind = petKind;
		this.ingredient = ingredient;
		this.dailyFeeding = dailyFeeding;
		
	}

	public String getImage() {
		return image;
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
