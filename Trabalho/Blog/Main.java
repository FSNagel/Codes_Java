//Felipe Schons Nagel

import java.util.*;

class Main{
	public static void main(String[] args){
		Blog blog 	  = new Blog();
		Scanner input = new Scanner(System.in);
		Post temp;

		int select = 1;

		while(select != 0){

			System.out.println("=========================================");
			System.out.println("=                                       =");
			System.out.println("=  BLOG NAGEL: O que voce quer fazer?   =");
			System.out.println("=                                       =");
			System.out.println("=  1 - Novo post de noticia             =");
			System.out.println("=  2 - Nova resenha do produto          =");
			System.out.println("=  3 - Novo post de outros assuntos     =");
			System.out.println("=  4 - Listar todas as postagens        =");
			System.out.println("=  5 - Curtir uma postagem              =");
			System.out.println("=  6 - Nao curtir uma postagem          =");
			System.out.println("=  0 - Sair                             =");
			System.out.println("=                                       =");
			System.out.println("=  Escolha a opcao:                     =");
			System.out.println("=                                       =");
			System.out.println("=========================================");

			select = input.nextInt();

			switch(select){
				case 1:
					blog.readData(temp = new News());
				break;

				case 2:
					blog.readData(temp = new ProductReview());
				break;

				case 3:
					blog.readData(temp = new Post());
				break;

				case 4:
					blog.showAll();
				break;

				case 5:
					blog.showToLike();
				break;

				case 6:
					blog.showToDislike();
				break;

				case 0:
					System.out.println("Obrigado a visita, ate a proxima!");
				break;

				default:
					System.out.println("Opcao Invalida, tente novamente!");
				break;
			}
		}
	}
}