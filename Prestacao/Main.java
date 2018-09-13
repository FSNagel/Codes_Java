//Felipe Nagel
import java.util.Scanner;

class Main{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Funcoes dados = new Funcoes();

    int n = 1;
    double dias;
    double juros;

    while(n != 0){
      System.out.println("1 - Calcular valor das prestações.");
      System.out.println("2 - Calcular valor de entrada.");
      System.out.println("3 - Calcular valor do atraso.");
      System.out.println("0 - Para sair do programa.");

      n = input.nextInt();
      switch(n){
        case 1:
          System.out.println("Digite o valor inicial:");
          dados.valor_inicial = input.nextDouble();
          System.out.println("Digite quantas parcelas:");
          dados.parcelas = input.nextInt();
          System.out.println("Digite a porcentagem de juros:");
          dados.juros = input.nextDouble();
          System.out.println("Digite o valor de entrada:(0, se não houver)");
          dados.entrada = input.nextDouble();

          dados.calcularValor();

          System.out.println("O valor inicial é de......: R$" + dados.valor_inicial);
          System.out.println("O valor da entrada é de...: R$" + dados.entrada);
          System.out.println("O valor do juros é de.....: R$" + dados.valor_juros);
          System.out.println("O valor atualizado é de...: R$" + dados.valor_final);
          System.out.println("As parcelas serão.........: ");
            for (int i = 1; i < dados.parcelas+1; i++) {
              System.out.println("A parcela " + i + " será de R$" + dados.valor_final/dados.parcelas);
            }
        break;

        case 2:
          System.out.println("Digite o valor da parcela:");
          dados.valor_parcelas = input.nextDouble();
          System.out.println("Digite quantos dias a parcela foi adiantada:");
          dias = input.nextDouble();
          System.out.println("Digite o juros ao mês:");
          juros = input.nextDouble();

          dados.calcularAdiantamentoParcela(dias, juros);

          System.out.println("O valor original da parcela é de.: R$ " + dados.valor_parcelas);
          System.out.println("O valor do juros é de.........: R$ " + dados.valor_juros);
          System.out.println("O valor é atualizado é de........: R$" +  dados.valor_final);
        break;

        case 3:
          System.out.println("Digite o valor da parcela:");
          dados.valor_parcelas = input.nextDouble();
          System.out.println("Digite quantos dias a parcela está atrasada:");
          dias = input.nextDouble();
          System.out.println("Digite o juros ao mês:");
          juros = input.nextDouble();

          dados.calcularAtraso(dias, juros);

          System.out.println("O valor original da parcela é de.: R$ " + dados.valor_parcelas);
          System.out.println("O valor do desconto é de.........: R$ " + dados.valor_juros);
          System.out.println("O valor é atualizado é de........: R$" +  dados.valor_final);

        break;

        default:
          System.out.println("Até a próxima!");
        break;
      }

    }
  }
}
