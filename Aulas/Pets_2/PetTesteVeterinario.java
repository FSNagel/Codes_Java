public class PetTesteVeterinario{
	public static void main(String[] args) {
		Cachorro dog = new Cachorro();
		dog.setNome("Rex");
		Gato cat = new Gato();
		cat.setNome("Mimi");

		Veterinario vet = new Veterinario();
		vet.cuidar(dog); //Passando argumento do tipo cachorro.
		vet.cuidar(cat); //Passando argumento do tipo gato.

	}
}