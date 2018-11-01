class FuncMain{

  public static void main(String args[]){
    System.out.println("Classe.....: " + Funcionario.totalDeFuncionarios);

    Funcionario f1 = new Funcionario();
    f1.totalDeFuncionarios++;

    System.out.println("Total em F1: " + f1.totalDeFuncionarios);

    Funcionario f2 = new Funcionario();
    f2.totalDeFuncionarios++;

    System.out.println("Total em F2: " + f1.totalDeFuncionarios);

    System.out.println("Após em F1: " + f1.totalDeFuncionarios);
    System.out.println("Total em F2: " + f2.totalDeFuncionarios);

  }
}
