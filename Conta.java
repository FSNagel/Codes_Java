public class Conta{
    String dono;
    double saldo;
    double limite;
    int id;


  boolean saque(double valor){
    if((this.saldo+this.limite) < valor){
      return false;
    }

    this.saldo-=valor;
    return true;
  }

  boolean deposito(double valor){
    this.saldo+=valor;
    return true;
  }
}
