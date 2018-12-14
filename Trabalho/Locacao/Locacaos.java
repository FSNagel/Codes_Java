import java.util.*;

class Locacaos extends Salvar{
	private int id;
	private int clienteId;
	private int frotaId;
	private double totalDiarias;
	private double totalQuilometragem;
	private double totalReposicao;
	private Locacaos arrayList[] = new Locacaos[100];
	private String arquivo = "Locacaos.txt";

	public int getId(){
		return this.id;
	}

	public void setId(int value){
		this.id = value;
	}

	public int getClienteId(){
		return this.clienteId;
	}	

	public void setClienteId(int value){
		this.clienteId = value;
	}

	public int getFrotaId(){
		return this.frotaId;
	}

	public void setFrotaId(int value){
		this.frotaId = value;
	}

	public double getTotalDiarias(){
		return this.totalDiarias;
	}

	public void setTotalDiarias(double value){
		this.totalDiarias = value;
	}

	public double getTotalQuilometragem(){
		return this.totalQuilometragem;
	}

	public void setTotalQuilometragem(double value){
		this.totalQuilometragem = value;
	}

	public double getTotalReposicao(){
		return this.totalReposicao;
	}

	public void setTotalReposicao(double value){
		this.totalReposicao = value;
	}

	public Locacaos[] getArrayList(){
		this.carregar();
		return this.arrayList;
	}

	public void calcularTotalDiarias(int dias){
		Precos preco = new Precos();
		preco.carregar();

		double valor = preco.getValoresDiarias() * dias;

		this.setTotalDiarias(valor);
	}

	public double calcularTotalQuilometragem(int idFrota, double quilometragem){
		Frotas[] arrayList = new Frotas[100];

		Frotas frota = new Frotas();
		frota.carregar(idFrota);
		double totalKm = quilometragem - frota.getQuilometragem();
		frota.setQuilometragem(quilometragem);
		frota.atualizar();

		Precos preco = new Precos();
		preco.carregar();

		this.setTotalQuilometragem(totalKm * preco.getTaxaQuilometragem());

		return totalKm;
	}

	public void calcularTotalCombustivel(double litros){
		Precos preco = new Precos();
		preco.carregar();

		this.setTotalReposicao(preco.getValorCombustivel() * litros);
	}

	public double getTotalFinal(){
		return this.getTotalDiarias() + this.getTotalQuilometragem() + this.getTotalReposicao();
	}


	public void registrar(){

		String linha = this.getClienteId() + ";" + this.getFrotaId() + ";" + this.getTotalDiarias() + ";" + this.getTotalQuilometragem() + ";" + this.getTotalReposicao();

		super.registrar(this.arquivo, linha, true);

	}

	public void listar(){
		this.carregar();

		System.out.println("\n====================== ( Lista de Locacao ) =====================\n");


		for (int i = 0; this.arrayList[i] != null; i++){

			System.out.println("Id: " + this.arrayList[i].getId() + " | Cliente Id: " + arrayList[i].getClienteId() + " | Frota Id: " + this.arrayList[i].getFrotaId());
			System.out.printf("Total em Diarias:       R$ %.2f\n", this.arrayList[i].getTotalDiarias());
			System.out.printf("Total em Quilometragem: R$ %.2f\n", this.arrayList[i].getTotalQuilometragem());
			System.out.printf("Total em Reposicao:     R$ %.2f\n\n", this.arrayList[i].getTotalReposicao());
		}

		System.out.println("\n==================================================================");
	}

	public void carregar(){
		String[] arrayDados = {};
		String[] arrayCampos = new String[5];
		arrayDados = super.consultar(this.arquivo);

		Locacaos temp;

		for (int i = 0; arrayDados[i] != null; i++){

			temp = new Locacaos();

			arrayCampos = arrayDados[i].split(";");

			int id = Integer.valueOf(arrayCampos[0]);

			temp.setId(id);
			temp.setClienteId(Integer.valueOf(arrayCampos[1]));
			temp.setFrotaId(Integer.valueOf(arrayCampos[2]));
			temp.setTotalDiarias(Double.valueOf(arrayCampos[3]));
			temp.setTotalQuilometragem(Double.valueOf(arrayCampos[4]));
			temp.setTotalReposicao(Double.valueOf(arrayCampos[5]));

			this.arrayList[i] = temp;
		}
	}

	public boolean carregar(int idPesquisa){
		String[] arrayDados = {};
		String[] arrayCampos = new String[5];
		arrayDados = super.consultar(this.arquivo);

		for (int i = 0; arrayDados[i] != null; i++){

			arrayCampos = arrayDados[i].split(";");

			int id = Integer.valueOf(arrayCampos[0]);

			this.setId(id);
			this.setClienteId(Integer.valueOf(arrayCampos[1]));
			this.setFrotaId(Integer.valueOf(arrayCampos[2]));
			this.setTotalDiarias(Double.valueOf(arrayCampos[3]));
			this.setTotalQuilometragem(Double.valueOf(arrayCampos[4]));
			this.setTotalReposicao(Double.valueOf(arrayCampos[5]));

			if(id == idPesquisa){
				break;
			}
		}

		if(idPesquisa != id){
			System.out.println("Registro nao encontrado!");
			return false;
		} else {
			return true;
		}
	}


	
}