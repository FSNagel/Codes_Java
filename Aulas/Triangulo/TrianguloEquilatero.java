class TrianguloEquilatero extends Triangulo{
	public float area(){
		float resultado;
		resultado = (getB() * getH())/2;
		return resultado;
	}
}