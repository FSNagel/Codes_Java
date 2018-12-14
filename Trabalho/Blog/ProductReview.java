import java.util.*;

class ProductReview extends Post implements Evaluable{
	private String brand;
	private int stars;

	public void evaluate(int value){
		if(value > 10 || value < 1){
			System.out.println("A nota deve ser de 1 a 10 Estrelas!");
			Scanner input = new Scanner(System.in);
			this.evaluate(input.nextInt());

		} else {
			this.setStars(value);
		}
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String value){
		this.brand = value;
	}

	public int getStars(){
		return this.stars;
	}

	public void setStars(int value){
		this.stars = value;
	}

	@Override
	public void show(){
		super.show();
		System.out.println("=  Estrelas: " + this.getStars());
		System.out.println("=  Marca: " + this.getBrand());
	}
}