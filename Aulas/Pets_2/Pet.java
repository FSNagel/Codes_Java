public abstract class Pet {
	private String nome;
	private int idade;
	public void setNome(String nome) {
		this.nome = nome;
	}
	}
	public String getNome(){
		return this.nome;
	}	
	public void brincar() {
		System.out.println(nome+ " brincando");
	}
	public abstract void emitirSom();
}