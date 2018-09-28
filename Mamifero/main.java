public class main {
  public static void main(String[] args) {
    PastorAlemao p = new PastorAlemao();
    Cachorro c = new Cachorro();

    c.latir();
    p.latir();
    System.out.println("Cor dos Olhos: " + c.getCorOlhos());
    System.out.println("Cor dos Olhos: " + p.getCorOlhos());
  }
}
