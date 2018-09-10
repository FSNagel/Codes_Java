class Teste{
  public static void main(String[] args){
    Conta Conta_inst = new Conta();
    Cliente Cliente_inst = new Cliente();
    Conta_inst.titular = Cliente_inst;

    System.out.println(Conta_inst.titular);
  }
}
