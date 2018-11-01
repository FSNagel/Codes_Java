public class CamaroteInferior{
	private String local;
	private double valorAdicional;
	private double descontoConsumo;
	private double totalConsumo;

	public String getLocal(){
		return this.local;
	}

	public void setLocal(String $data){
		this.local = $data;
	}

	public double getValorAdicional(){
		return this.valorAdicional;
	}

	public void setValorAdicional(double $dado){
		this.valorAdicional = $dado;
	}

	public double getDescontoConsumo(){
		return this.descontoConsumo;
	}

	public void setDescontoConsumo(double $dado){
		this.descontoConsumo = $dado/100;
	}

	public double getTotalConsumo(){
		return this.totalConsumo;
	}

	public void setTotalConsumo(double $dado){
		this.totalConsumo = $dado;
	}

	public double MostrarValorConsumo(){
		return this.totalConsumo - (this.totalConsumo * this.descontoConsumo);
	}
}