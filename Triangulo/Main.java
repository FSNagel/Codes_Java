class Main{
	public static void main(String[] args){
		TrianguloEquilatero abc = new TrianguloEquilatero();
		float valor;
		abc.setB(10);
		abc.setH(5);
		valor = abc.area();
		System.out.println("Area do Triangulo é:" + valor);
	}
}