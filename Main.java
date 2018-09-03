import java.util.Scanner;
class Main{

  public static void main(String[] args){
  Scanner input =  new Scanner(System.in);
  Conta conta =  new Conta();
  double n1;
  int n = 1;

  System.out.println("Digite o nome do dono da Conta:");
  conta.dono = input.nextLine();

  System.out.println("Digite o saldo inicial:");
  conta.saldo = input.nextDouble();

  while(n != 0){
    System.out.println("===================================");
    System.out.println("O dono da conta é..:  " + conta.dono);
    System.out.println("1 - Consultar Saldo.");
    System.out.println("2 - Efetuar Saque.");
    System.out.println("3 - Efetuar Depósito.");
    System.out.println("0 - Sair.");

    n = input.nextInt();

    switch(n){
      case 1:
        System.out.println("Saldo da conta: " + conta.saldo);
        break;

      case 2:
        System.out.println("Por favor digite o valor do saque:");
        n1 = input.nextDouble();
        if(conta.saque(n1)){
          System.out.println("Saque efetuado com sucesso!");
          System.out.println("Saldo atualizado é: " + conta.saldo);
        }
        else{
          System.out.println("Saldo insuficiente, consulte a sua agência!");
        }
          break;

        case 3:
          System.out.println("Por favor informe o valor do depósito:");
          n1 = input.nextDouble();
          if(conta.deposito(n1)){
            System.out.println("Depósito efetuado com sucesso!");
            System.out.println("Saldo atualizado é: " + conta.saldo);
          }
          break;

        case 0:
          break;

        default:
          System.out.println("Operação Inválida!");
        break;
      }
    }
  }
}
