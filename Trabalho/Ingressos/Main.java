//Felipe S. Nagel.
//Professor Trento.
//Ciência da Computação. Fase 3.

import java.util.Scanner;
class Main {

	public static void main(String[] args){
		Scanner input 		= new Scanner(System.in);
		IngressoNormal iN 	= new IngressoNormal();
		IngressoVip iV 		= new IngressoVip();
		CamaroteSuperior cS = new CamaroteSuperior();

		int n = 1;
		double valorCamarote;


		while(n != 0){
			System.out.printf("\n");
			System.out.println("========= (Principal) ===========");
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Ingresso Normal:");
			System.out.println("2 - Ingresso VIP:");
			System.out.println("0 - Para Sair:");

			n = input.nextInt();

			switch(n){

				case 1:
					System.out.println("Digite a quantidade de ingressos:");
					iN.setQuantidade(input.nextInt());
					System.out.println("Digite o valor do desconto:(0 se não tiver)");
					iN.setDesconto(input.nextDouble());

					//iN.CalcValor();
					System.out.printf("Valor total: R$ %.2f", iN.MostrarValor());
				break;

				case 2:
					System.out.println("Digite a quantidade de ingressos:");
					iV.setQuantidade(input.nextInt());
					System.out.println("Digite o valor adicional do ingresso VIP:");
					iV.setValorAdicional(input.nextDouble()*iV.getQuantidade());

					System.out.println("====== (Selecione o Camarote) ====");
					System.out.println("1 - Camarote Inferior:");
					System.out.println("2 - Camarote Superior:");

					n = input.nextInt();

					if(n == 1){
						valorCamarote = camaroteInferior();
					} else {
						valorCamarote = camaroteSuperior();
					}

					System.out.printf("Valor total: R$ %.2f", (iV.ValorIngressoVip() + valorCamarote));
				break;	

				case 0:
					System.out.println("Até a próxima");
				break;

				default:
					System.out.println("Opção inválida!");
				break;
			}
		}
	}

	public static double camaroteSuperior(){
		Scanner input 		= new Scanner(System.in);
		double temp;

		System.out.println("Digite valor adicional do Camarote Superior:");
		temp = input.nextDouble();

		return temp;
	}

	public static double camaroteInferior(){
		Scanner input 		= new Scanner(System.in);
		CamaroteInferior cI = new CamaroteInferior();
		int n1 = 1;
		double temp;

		while(n1 != 0){
			System.out.printf("\n");
			System.out.println("========= (Camarote Inferior) ===========");
			System.out.println("1 - Adicionar um novo item no Consumo:");
			System.out.println("2 - Definir desconto de consumo (porcentagem):");
			System.out.println("3 - Mostrar Total:");
			System.out.println("4 - Mostrar Total com Desconto:");
			System.out.println("0 - Finalizar Camarote:");

			n1 = input.nextInt();

			switch(n1) {
				case 1:
					System.out.println("Informe o valor para adicionar na conta:");
					temp = cI.getTotalConsumo() + input.nextDouble();
					cI.setTotalConsumo(temp);
					System.out.printf("Valor acrescido, divida atual: R$%.2f\n", cI.getTotalConsumo()); 
				break;

				case 2:
					System.out.println("Informe a porcentagem de desconto:");
					cI.setDescontoConsumo(input.nextDouble());
					System.out.printf("Desconto definido em %.0f%% \n", cI.getDescontoConsumo() * 100);
				break;

				case 3:
					System.out.printf("Total: R$ %.2f \n", cI.getTotalConsumo());
				break;

				case 4:
					if(cI.getDescontoConsumo() == 0){
						System.out.println("Você precisa informar o valor de desconto para esse opção:");
					} else {
						System.out.printf("Total: R$ %.2f\n", cI.MostrarValorConsumo());
					}
				break;

				case 0:
					System.out.printf("Finalizando Camarote...\n\n");
				break;

				default:
					System.out.println("Opção inválida");
				break;
			}

		}

			//verifica se existe desconto, se tiver retorna com desconto.
			if(cI.getDescontoConsumo() == 0){
				return cI.getTotalConsumo();
			} else {
				return cI.MostrarValorConsumo();
			}
	}
}