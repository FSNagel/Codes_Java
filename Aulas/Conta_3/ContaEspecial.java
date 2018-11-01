public class ConstaEspecial extends ContaComum{
  private double limite_conta;
  private double juros_conta;

  public double getLimiteConta(){
    return this.limite_conta;
  }

  public void setLimiteConta(double $dado){
    this.limite_conta = $dado;
  }

  public double getJurosConta(){
    return this.juros_conta;
  }

  public void setJurosConta(int $dado){
    this.juros_conta = $dado;
  }

  public double getSaldoConta(){
    return super.saldo_conta;
  }

  public void setSaldoConta(double $dado){
    super.saldo_conta = $dado;
  }

  public double getNumeroConta(){
    return super.numero_conta;
  }

  public void setNumeroConta(int $dado){
    super.numero_conta = $dado;
  }

  public bool saque(double $valor){
    if(this.limite_conta + this.saldo_conta < $valor){
      this.saldo_conta -= $valor;
      return true;
    } else {
      return false;
    }

  public double juros(int $dado){
    
  }

  }
}
