import java.util.*;

class Frotas extends Salvar{
  private int id;
  private String marca;
  private String modelo;
  private String placa;
  private double quilometragem;
  private Frotas arrayList[] = new Frotas[100];
  private String arquivo = "Frota.txt";

  public int getId(){
    return this.id;
  }

  public void setId(int value){
    this.id = value;
  }

  public String getMarca(){
    return this.marca;
  }

  public void setMarca(String value){
    this.marca = value;
  }

  public String getModelo(){
    return this.modelo;
  }

  public void setModelo(String value){
    this.modelo = value;
  }

  public String getPlaca(){
    return this.placa;
  }

  public void setPlaca(String value){
    this.placa = value;
  }

  public double getQuilometragem(){
    return this.quilometragem;
  }

  public Frotas[] getArrayList(){
    this.carregar();
    return this.arrayList;
  }

  public void setQuilometragem(double value){
    this.quilometragem = value;
  }

  public void registrar(){

    String linha = this.getMarca() + ";" + this.getModelo() + ";" + this.getPlaca() + ";" + this.getQuilometragem();

    super.registrar(this.arquivo, linha, true);

  }

  public void listar(){
    this.carregar();

    System.out.println("\n======================= ( Lista da Frota ) =======================\n");

    for (int i = 0; this.arrayList[i] != null; i++){

      System.out.println("Id: " + this.arrayList[i].getId() + " | Placa: " + this.arrayList[i].getPlaca() + " | Quilometragem: " + this.arrayList[i].getQuilometragem() + "Km");
      System.out.println("Marca: " + this.arrayList[i].getMarca() + "| Modelo: " + this.arrayList[i].getModelo() + "\n");
    }

    System.out.println("\n==================================================================");
  }

  public void carregar(){
   String[] arrayDados = {};
   String[] arrayCampos = new String[5];
   arrayDados = super.consultar(this.arquivo);

   Frotas temp;

   for (int i = 0; arrayDados[i] != null; i++){

    temp = new Frotas();

    arrayCampos = arrayDados[i].split(";");

    int id = Integer.valueOf(arrayCampos[0]);

    temp.setId(id);
    temp.setMarca(arrayCampos[1]);
    temp.setModelo(arrayCampos[2]);
    temp.setPlaca(arrayCampos[3]);
    temp.setQuilometragem(Double.valueOf(arrayCampos[4]));

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
  this.setMarca(arrayCampos[1]);
  this.setModelo(arrayCampos[2]);
  this.setPlaca(arrayCampos[3]);
  this.setQuilometragem(Double.valueOf(arrayCampos[4]));

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

public void atualizar(){
  String linha = this.getId() + ";" + this.getMarca() + ";" + this.getModelo() + ";" + this.getPlaca() + ";" + this.getQuilometragem();

  super.atualizar(this.arquivo, linha);
}
}
