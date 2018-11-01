class ContaComum{
  private int numero_conta;
  private double saldo_conta;

  public int getNumeroConta(){
    return this.numero_conta;
  }

  public void setNumeroConta(int $dado){
    this.numero_conta = $dado;
  }

  public double getSaldoConta(){
    return this.saldo_conta;
  }

  public void setSaldoConta(double $dado){
    this.saldo_conta = $dado;
  }

  public bool saque(double $valor){

    if(this.saldo_conta > $valor){
      this.saldo_conta -= $valo;
      return  true;
    } else {
      return false;
    }
  }

  public bool deposito(double $valor){
    this.saldo_conta += $valor;
    return true;
  }
}
