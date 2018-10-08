class Main{
	public static void main(String args[]){

		Cachorro $cachorro = new Cachorro();

		$cachorro.cavar();
		$cachorro.emitirSom();

		Gato $gato = new Gato();

		$gato.emitirSom();
		$gato.arranhar();
	}
}