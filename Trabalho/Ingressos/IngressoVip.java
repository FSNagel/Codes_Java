public class IngressoVip extends IngressoNormal{
	private double valorAdicional;
	private int quantidade;

	public int getQuantidade(){
		return this.quantidade;
	}

	public void setQuantidade(int $dado){
		this.quantidade = $dado;
	}

	public double getValorAdicional(){
		return this.valorAdicional;
	}

	public void setValorAdicional(double $dado){
		this.valorAdicional = $dado;
	}


	public void CalcValor(){
		this.setTotal((this.quantidade*this.getValor())-this.getDesconto());

	}

	public double MostrarValor(){
		this.CalcValor();
		return this.getTotal();
	}

	public double ValorIngressoVip(){
		System.out.printf("Valor: %.2f, Total %.2f \n\n", this.getValor(), this.getTotal());
		return this.valorAdicional + this.MostrarValor();
	}

}