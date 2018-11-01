public class Veterinario{
	public void cuidar(Pet paciente){
		System.out.println("Cuidando do " + paciente.getNome());

		if(paciente instanceof Cachorro){
			System.out.println("Tirando as pulgas.");
		}

		if(paciente instanceof Gato){
			System.out.println("Fazendo carinho.");
		}
	}
}