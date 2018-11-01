public class CamaroteSuperior extends IngressoVip{
	private double valorAdicional;

	public double getValorAdicional(){
		return this.valorAdicional;
	}

	public void setValorAdicional(double $dado){
		this.valorAdicional = $dado;
	}

	public double MostrarValor(){
		return super.ValorIngressoVip();
	}

}