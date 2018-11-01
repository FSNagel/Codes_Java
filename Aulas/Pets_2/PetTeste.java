public class PetTeste{
	public static void main(String[] args) {
		Pet vetor[] = new Pet[10]; //O vetor é do tipo da super classe.
		for(int i = 0; i < vetor.length; i++) {
			if(i%2 == 0) {
				vetor[i] = new Cachorro();
			} else {
				vetor[i] = new Gato();
			}

			vetor[i].emitirSom();
		}
	}
}