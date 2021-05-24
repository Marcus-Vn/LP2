public class Calculo{
  public void calcular(int num1, int num2){
    //Realiza um cálculo qualquer
  }
}

public class Soma extends Calculo{
   public int calcular(int num1, int num2){
      //Realiza uma soma
   }
}
public class Mult extends Calculo{
   public int calcular(int num1, int num2){
      //Realiza uma multiplicação
   }
}
public class CalculoQualquer extends Soma,Mult{
}

//No programa principal ao chamar a função calcular para o "CalculoQualquer" haverá o problema
//de saber de qual classe herdada deve ser feito o cálculo, Soma ou Mult

CalculoQualquer conta = new CalculoQualquer();
conta.calcular();
