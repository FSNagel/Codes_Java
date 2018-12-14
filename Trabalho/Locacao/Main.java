/* Adalberto Marques da Costa
   Felipe Schons Nagel
   Gabriela Paz 
*/

   import java.util.*;

   class Main{
   	public static void main(String args[]){

   		Scanner input = new Scanner(System.in);
   		int controle = 1;

   		Clientes cliente;
   		Frotas frota;
   		Precos preco;
   		Locacaos locacao;


   		while(controle != 0){

   			System.out.println("\n========================== ( AlocaAFG ) =========================");
   			System.out.println("|                                                                |");
   			System.out.println("|   01 - Cadastrar Clientes:                                     |");
   			System.out.println("|   02 - Cadastrar Frotas:                                       |");
   			System.out.println("|   03 - Alterar Precos:                                         |");
   			System.out.println("|   04 - Cadastrar a locacao de um veiculo:                      |");
   			System.out.println("|   05 - Listar os clientes cadastrados:                         |");
   			System.out.println("|   06 - Listar os veiculos da frota:                            |");
   			System.out.println("|   07 - Listar as Locacoes:                                     |");
   			System.out.println("|   08 - Listar os dados da locacao (extrato para o cliente):    |");
   			System.out.println("|   09 - Mostrar tabela de precos:                               |");
   			System.out.println("|   00 - Para Sair:                                              |");
   			System.out.println("|                                                                |");
   			System.out.println("==================================================================\n");
   			System.out.print("==> ");

   			controle = input.nextInt();
   			input = new Scanner(System.in);

   			switch(controle){
   				case 1:
   				cliente = new Clientes();
   				System.out.println("\n===================== ( Cadastro de Cliente ) ====================\n");
   				System.out.println("Informe o nome:");
   				cliente.setNome(input.nextLine());	
   				System.out.println("Informe o numero da carteira de habilitacao:");
   				cliente.setNumeroCarteira(input.nextLine());

   				cliente.registrar();

   				System.out.println("\n==================================================================");
   				break;

   				case 2:
   				frota = new Frotas();
   				System.out.println("\n====================== ( Cadastro da Frota ) =====================\n");

   				System.out.println("Marca do carro: ");
   				frota.setMarca(input.nextLine());
   				System.out.println("Modelo do carro: ");
   				frota.setModelo(input.nextLine());
   				System.out.println("Placa do carro: ");
   				frota.setPlaca(input.nextLine());
   				System.out.println("Quilometragem do carro: ");
   				frota.setQuilometragem(input.nextDouble());
   				
   				frota.registrar();

   				System.out.println("\n==================================================================");
   				break;

   				case 3:
   				preco = new Precos();

   				System.out.println("\n====================== ( Cadastro de Precos ) ====================\n");
   				System.out.println("Informe o Valor da Diaria:");
   				preco.setValorCombustivel(input.nextDouble());
   				System.out.println("Informe a Taxa de Quilometragem");
   				preco.setTaxaQuilometragem(input.nextDouble());
   				System.out.println("Informe o Valor do Combustivel");
   				preco.setValoresDiarias(input.nextDouble());

   				preco.registrar();
   				
   				System.out.println("\n==================================================================");
   				break;

   				case 4:
   				cliente = new Clientes();
   				frota 	= new Frotas();
   				locacao = new Locacaos();

   				System.out.println("\n===================== ( Cadastro de Locacao ) ====================\n");

   				cliente.listar();
   				System.out.println("Informe o Id do Cliente:");
   				int clienteId = input.nextInt();

   				while(!cliente.carregar(clienteId)){
   					System.out.println("O id informado nao pertence a nenhum cliente!");
   					clienteId = input.nextInt();
   				}

   				locacao.setClienteId(clienteId);
   				frota.listar();
   				System.out.println("Informe o Id da Frota:");

   				int frotaId = input.nextInt();

   				while(!frota.carregar(frotaId)){
   					System.out.println("O id informado nao pertence a nenhum veiculo da frota!");
   					frotaId = input.nextInt();
   				}

   				locacao.setFrotaId(frotaId);

   				System.out.println("Informe o total de dias:");
   				locacao.calcularTotalDiarias(input.nextInt());
   				System.out.printf("O valor em diarias: R$ %.2f\n\n", locacao.getTotalDiarias());

   				System.out.println("Informe a quilometragem atual:");
   				frota.carregar(locacao.getFrotaId());
   				double kmAtual = input.nextDouble();
   				while(kmAtual <= frota.getQuilometragem()){
   					System.out.println("Voce informou uma quilometragem menor do que a anterior da locacao:");
   					kmAtual = input.nextDouble();
   				}
   				double km = locacao.calcularTotalQuilometragem(locacao.getFrotaId(), kmAtual);
   				System.out.println("O total percorrido foi: " + km + "Km");
   				System.out.printf("O valor pela quilometragem foi: R$ %.2f \n\n", locacao.getTotalQuilometragem());


   				System.out.println("Informe quantos litros a reposicao de combustivel:");
   				locacao.calcularTotalCombustivel(input.nextDouble());
   				System.out.printf("O total do combustivel foi: R$ %.2f\n\n", locacao.getTotalReposicao());

   				System.out.printf("O total da locacao foi: R$ %.2f\n", locacao.getTotalFinal());

   				locacao.registrar();

   				System.out.println("\n==================================================================");

   				break;

   				case 5:
   				cliente = new Clientes();
   				cliente.listar();
   				break;

   				case 6:
   				frota = new Frotas();
   				frota.listar();
   				break;

   				case 7:
   				locacao = new Locacaos();
   				locacao.listar();
   				break;

   				case 8:
   				locacao =  new Locacaos();

   				System.out.println("Informe um Id de locacao:");
   				int idLocacao = input.nextInt();

   				if(!locacao.carregar(idLocacao)){
   					System.out.println("O id informado nao pertence a nenhuma locacao!");
   					break;
   				}

   				cliente = new Clientes();
   				frota 	= new Frotas();
   				cliente.carregar(locacao.getClienteId());
   				frota.carregar(locacao.getFrotaId());

   				System.out.println("\n========================= ( Locacao: " + locacao.getId() + " ) ========================\n");
   				System.out.println("Numero do Cliente : " + cliente.getId());
   				System.out.println("Locador 		  : " + cliente.getNome());
   				System.out.println("Carteira 		  : " + cliente.getNumeroCarteira());
   				System.out.println("----------------------------------------");
   				System.out.println("Numero do Veiculo        : " + frota.getId());
   				System.out.println("Marca do Veiculo         : " + frota.getMarca());
   				System.out.println("Modelo do Veiculo        : " + frota.getModelo());
   				System.out.println("Placa do Veiculo         : " + frota.getPlaca());
   				System.out.println("Quilometragem do Veiculo : " + frota.getQuilometragem());
   				System.out.println("----------------------------------------");
   				System.out.printf("Total em Diarias       : R$ %.2f\n", locacao.getTotalDiarias());
   				System.out.printf("Total em Quilometragem : R$ %.2f\n", locacao.getTotalQuilometragem());
   				System.out.printf("Total em Reposicao     : R$ %.2f\n\n", locacao.getTotalReposicao());
   				System.out.printf("Total da Locacao       : R$ %.2f\n\n", locacao.getTotalFinal());
   				System.out.println("\n==================================================================");


   				break;

   				case 9:
   				preco = new Precos();
   				preco.listar();
   				break;

   				case 0:
   				System.out.println("\n========================== ( Ate Mais ) =========================");
   				break;

   				default:
   				System.out.println("Opcao invalida");
   				break;
   			}


   		}
   	}
   }