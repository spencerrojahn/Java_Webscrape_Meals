
public class Items {
	
	private String item;
	private double calories;
	private String price;
	
	public Items(String item, double calories, String price) {
		this.item = item;
		this.calories = calories;
		this.price = price;
	}

	public String getItem() {
		return this.item;
	}
	public double getCalories() {
		return this.calories;
	}
	public String getPrice() {
		return this.price;
	}
	public double getCalToPriceRatio() {
		String price = this.price.substring(1);
		double priceNum = Double.parseDouble(price);
		return this.calories / priceNum;
	}	
	
}
