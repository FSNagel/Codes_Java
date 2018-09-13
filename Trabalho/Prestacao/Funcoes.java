class Funcoes{
  int parcelas;
  double valor_inicial;
  double valor_juros;
  double valor_final;
  double valor_parcelas;
  double juros;
  double entrada;

  void calcularValor(){
    juros = juros/100; //transforma o inteiro em float de porcentagem
    valor_juros = (valor_inicial - entrada) * juros; //calcula valor dos juros, diminuindo a entrada.
    valor_final = valor_inicial - entrada + valor_juros; // calcular valor atualizado
  }

  void calcularAdiantamentoParcela(double dias_AP, double juros_AP){
    dias_AP = dias_AP/30; //converte dias para mês(compatibilidade).
    juros_AP = juros_AP/100; //converte inteiro em float de porcentagem.
    valor_juros = valor_parcelas * dias_AP * juros_AP; //calcula o desconto
    valor_final = valor_parcelas - valor_juros; //diminui o desconto do valor original
  }

  void calcularAtraso(double dias_AP, double juros_AP){
    dias_AP = dias_AP/30; //converte dias para mês(compatibilidade).
    juros_AP = juros_AP/100; //converte inteiro em float de porcentagem.
    valor_juros = valor_parcelas * dias_AP * juros_AP; //calcula o desconto
    valor_final = valor_parcelas + valor_juros; //diminui o desconto do valor original
  }
}
