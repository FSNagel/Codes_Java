import java.util.*;

class Blog{
	Post arrayList[] = new Post[100];
	int  indice = 0;

	public void readData(Post temp){
		Scanner input = new Scanner(System.in);

		System.out.println("==== Voce esta cadastrando uma nova Publicacao ====");
		System.out.println("Digite o titulo:");
		temp.setTitle(input.nextLine());
		System.out.println("Digite a data:");
		temp.setDate(input.nextLine());
		System.out.println("Digite o conteudo:");
		temp.setContent(input.nextLine());

		if(temp instanceof News){
			News news = (News)temp;

			System.out.println("Digite a fonte:");
			news.setSource(input.nextLine());

		} else if(temp instanceof ProductReview){
			ProductReview product = (ProductReview)temp;

			System.out.println("Digite a marca:");
			product.setBrand(input.nextLine());

			System.out.println("Digite quantas estrelas:");
			product.evaluate(input.nextInt());

		}

		this.arrayList[this.indice] = temp;
		this.indice++;
	}

	public void showAll(){
		for (int i = 0; i<this.indice; i++) {
			System.out.printf("\n=========================================\n\n");
			this.arrayList[i].show();		
			System.out.printf("\n=========================================\n\n");
		}
	}

	public void showToLike(){
		Scanner input = new Scanner(System.in);

		int temp;
		System.out.printf("\n=============== (Lista) ================\n\n");
		for (int i = 0; i<this.indice; i++) {
			System.out.print("=  Id: " + (i+1) + " | Likes: " + this.arrayList[i].getLikes() + " | Titulo: " + this.arrayList[i].getTitle());
			if(this.arrayList[i] instanceof News) {
				System.out.println(" - postagem News");	
			} else if(this.arrayList[i] instanceof ProductReview) {
				System.out.println(" - postagem ProductReview");	
			} else if(this.arrayList[i] instanceof Post) {
				System.out.println(" - postagem Post");	
			}
		}	
		System.out.printf("\n=========================================\n\n");

		System.out.println("Informe o Id da postagem a qual quer dar like: ");
		temp = input.nextInt();
		temp--;

		if(temp >= 0 && temp < this.indice){
			this.arrayList[temp].like();
		} else {
			System.out.println("Id inexistente!");
		}
	}

	public void showToDislike(){
		Scanner input = new Scanner(System.in);

		int temp;
		System.out.printf("\n=============== (Lista) ================\n\n");
		for (int i = 0; i<this.indice; i++) {
			System.out.print("=  Id: " + (i+1) + " | Dislikes: " + this.arrayList[i].getDislikes() + " | Titulo: " + this.arrayList[i].getTitle());

			if(this.arrayList[i] instanceof News) {
				System.out.println(" - postagem News");	
			} else if(this.arrayList[i] instanceof ProductReview) {
				System.out.println(" - postagem ProductReview");	
			} else if(this.arrayList[i] instanceof Post) {
				System.out.println(" - postagem Post");	
			}
		}	
		System.out.printf("\n=========================================\n\n");

		System.out.println("Informe o Id da postagem a qual quer dar dislike: ");
		temp = input.nextInt();
		temp--;

		if(temp >= 0 && temp < this.indice){
			this.arrayList[temp].dislike();
		} else {
			System.out.println("Id inexistente!");
		}
	}


}