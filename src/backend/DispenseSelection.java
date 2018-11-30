package backend;

import java.util.Date;

public class DispenseSelection {
	private PetFood petFood;
	private Date date;
	
	public DispenseSelection(PetFood petFood){
		this.petFood = petFood;
		this.date = new Date();
	}
	
	public PetFood getPetFood(){
		return petFood;
	}
	
	public void setPetFood(PetFood petFood){
		this.petFood = petFood;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		return petFood.getName() + ": " + date;
	}
}
