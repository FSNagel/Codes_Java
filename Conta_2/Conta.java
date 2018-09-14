class Conta{
  int numero;
  double saldo;
  double limite;
  Cliente titular;

  boolean saque(double valor){
    if((this.saldo+this.limite) < valor){
      return false;
    }

    this.saldo-=valor;
    return true;
  }

  boolean deposita(double valor){
    this.saldo+=valor;
    return true;
  }
}
