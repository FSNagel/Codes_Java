import java.util.*;

class Clientes extends Salvar{
	private int id;
	private String nome;
	private String numeroCarteira;
	private static Clientes[] arrayList = new Clientes[100];
	private String arquivo = "Clientes.txt";

	public int getId(){
		return this.id;
	} 

	public void setId(int value){
		this.id = value;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String value){
		this.nome = value;
	}

	public String getNumeroCarteira(){
		return this.numeroCarteira;
	}

	public void setNumeroCarteira(String value){
		this.numeroCarteira = value;
	}

	public Clientes[] getArrayList(){
		this.carregar();
		return this.arrayList;
	}

	public void registrar(){

		String linha = this.getNome() + ";" + this.getNumeroCarteira();

		super.registrar(this.arquivo, linha, true);
	}

	public void listar(){
		this.carregar();

		System.out.println("\n====================== ( Lista de Clientes ) =====================\n");

		for (int i = 0; this.arrayList[i] != null; i++){
			System.out.println("Id: " + this.arrayList[i].getId() + " | Nome: " + this.arrayList[i].getNome());
			System.out.println("Carteira: " + this.arrayList[i].getNumeroCarteira() + "\n");
		}

		System.out.println("\n==================================================================");
	}

	public void carregar(){
		String[] arrayDados = {};
		String[] arrayCampos = new String[3];

		Clientes temp;

		arrayDados = super.consultar(this.arquivo);

		for (int i = 0; arrayDados[i] != null; i++){
			temp = new Clientes();

			arrayCampos = arrayDados[i].split(";");

			int id = Integer.valueOf(arrayCampos[0]);

			temp.setId(id);
			temp.setNome(arrayCampos[1]);
			temp.setNumeroCarteira(arrayCampos[2]);


			this.arrayList[i] = temp;
		}
	}

	public boolean carregar(int idPesquisa){
		String[] arrayDados = {};
		String[] arrayCampos = new String[3];

		arrayDados = super.consultar(this.arquivo);

		for (int i = 0; arrayDados[i] != null; i++){

			arrayCampos = arrayDados[i].split(";");

			id = Integer.valueOf(arrayCampos[0]);

			this.setId(id);
			this.setNome(arrayCampos[1]);
			this.setNumeroCarteira(arrayCampos[2]);
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