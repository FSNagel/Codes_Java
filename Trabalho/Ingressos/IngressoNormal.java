public class IngressoNormal extends Ingresso{
	private int quantidade;
	private double desconto;
	private double total;
	
	public int getQuantidade(){
		return this.quantidade;
	}

	public void setQuantidade(int $dado){
		this.quantidade = $dado;
	}

	public double getDesconto(){
		return this.desconto;
	}	

	public void setDesconto(double $dado){
		this.desconto = $dado;
	}

	public double getTotal(){
		return this.total;
	}

	public void setTotal(double $dado){
		this.total = $dado;
	}

	public void CalcValor(){
		double quantidade = this.quantidade;

		if(quantidade < 5) {
			quantidade *= 1;
		} else if(quantidade >= 5 && quantidade <= 10) {
			quantidade *= 0.95;
		} else if(quantidade > 10 && quantidade <= 15) {
			quantidade *= 0.9;
		} else {
			quantidade *= 0.85;
		}



		this.total = (quantidade*super.getValor())-this.desconto;

	}

	public double MostrarValor(){
		this.CalcValor();
		return this.total;
	}
}