import java.util.*;

class Precos extends Salvar{
	private double valoresDiarias;
	private double taxaQuilometragem;
	private double valorCombustivel;
	private String arquivo = "Precos.txt";

	public double getValoresDiarias(){
		return this.valoresDiarias;
	}

	public void setValoresDiarias(double value){
		this.valoresDiarias = value;
	}

	public double getTaxaQuilometragem(){
		return this.taxaQuilometragem;
	}

	public void setTaxaQuilometragem(double value){
		this.taxaQuilometragem = value;
	}

	public double getValorCombustivel(){
		return this.valorCombustivel;
	}

	public void setValorCombustivel(double value){
		this.valorCombustivel = value;
	}

	public void registrar(){
		
		String linha = this.getValorCombustivel() + ";" + this.getTaxaQuilometragem() + ";" + this.getValoresDiarias();

		super.registrar(this.arquivo, linha, false);
		System.out.println("\n==================================================================");
		
	}

	public void listar(){
		this.carregar();

		System.out.println("\n======================= ( Lista de Precos ) ======================\n");

		System.out.printf("Valor do Combustivel:  R$ %.2f\n", this.getValorCombustivel());
		System.out.printf("Taxa da Quilometragem: R$ %.2f\n", this.getTaxaQuilometragem());
		System.out.printf("Valor das Diarias:     R$ %.2f\n\n", this.getValoresDiarias());

		System.out.println("\n==================================================================");
	}

	public void carregar(){
		String[] arrayDados = {};
		String[] arrayCampos = new String[3];
		arrayDados = super.consultar(this.arquivo);

		for (int i = 0; arrayDados[i] != null; i++){

			arrayCampos = arrayDados[i].split(";");

			this.setValorCombustivel(Double.valueOf(arrayCampos[3]));
			this.setTaxaQuilometragem(Double.valueOf(arrayCampos[2]));
			this.setValoresDiarias(Double.valueOf(arrayCampos[1]));
		}
	}
}