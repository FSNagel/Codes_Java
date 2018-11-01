public class Funcionario{
  private String nome;
  private double salario;
  private int numeroDeDependentes;

  static int totalDeFuncionarios = 0;

  public void aumento(double valorAumento){
    salario = salario + valorAumento;
  }
}
