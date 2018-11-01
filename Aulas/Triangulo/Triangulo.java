abstract class Triangulo{
	private float b, h;

	public Triangulo(){
		b = 0;
		h = 0;
	}

	abstract public float area();

	public float getB(){
		return this.b;
	}

	public void setB(float $value){
		this.b = $value;
	}

	public float getH(){
		return this.h;
	}

	public void setH(float $value){
		this.h = $value;
	}


}