class Teste{
  public static void main(String[] args){
    Conta Conta_inst = new Conta();
    Cliente Cliente_inst = new Cliente();
    Conta_inst.titular = Cliente_inst;
    Cliente_inst.nome = "Nagel";

    System.out.println(Conta_inst.titular.nome);
  }
}
