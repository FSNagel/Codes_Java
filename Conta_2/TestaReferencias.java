class TestaReferencias{
  public static void main(String args[]){
      Conta c1 = new Conta();

      if(c1.deposito(100)){
        System.out.println("Depósito efetuado com sucesso!");
        System.out.println("Saldo atualizado é: " + c1.saldo);
      }

      Conta c2 = c1;

      if(c2.deposito(200)){
        System.out.println("Depósito efetuado com sucesso!");
        System.out.println("Saldo atualizado é: " + c2.saldo);
      }

      System.out.println(c1.saldo);
      System.out.println(c2.saldo);
  }
}
