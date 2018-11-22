package backend;

public class DispenseSelection {
	private PetFood petFood;
	
	public DispenseSelection(PetFood petFood){
		this.petFood = petFood;
	}
	
	public PetFood getPetFood(){
		return petFood;
	}
	
	public void setPetFood(PetFood petFood){
		this.petFood = petFood;
	}
	
	public String toString(){
		return petFood.getName();
	}
}
