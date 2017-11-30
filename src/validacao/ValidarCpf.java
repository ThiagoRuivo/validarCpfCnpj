
package validacao;

public class ValidarCpf {
  
  /*
    campos::
  */
  private String cpf;
  private String mascCpf;

  /*
    construtores::
  */
  public ValidarCpf() {
  }

  /*
    gets e sets::
  */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public void setMascCpf(String mascCpf) {
    this.mascCpf = mascCpf;
  }
  public String getCpf() {
    return cpf;
  }
  public String getMascCpf() {
    return mascCpf;
  }
  

  /*
    ações::
  */
  private int[] gerarPesos (int tamanho) {
    int contador = tamanho + 1;
    int pesos[] = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      pesos[i] = contador;
      contador--;
    }
    return pesos;
  }
  private int calcularSoma (int pesos[], int numeros[]) {
    int soma = 0;
    for (int i = 0; i < pesos.length; i++) {
      soma += pesos[i] * numeros[i];
    }
    return soma;
  }
  private int calcularDigito (int soma) {
    int digito = 0;
    digito = 11 - (soma % 11);
    if ((digito == 10) || (digito == 11)) {
      digito = 0;
    }
    return digito;
  }
  public boolean validarCpf (String texto) {
    if ((!"".equals(texto)) && (texto.length() == 11)) {
      Conversao cv = new Conversao();
      int vetorCPF[] = new int[texto.length()];
      try {
        vetorCPF = cv.intArray(texto);
      } catch (Exception e) {
        System.out.println("Não foi possível converter a string passada para a função em um vetor de inteiros");
        System.out.println(e);
      }
      int dig1 = calcularDigito(calcularSoma(gerarPesos(9), vetorCPF));
      vetorCPF[9] = dig1;
      int dig2 = calcularDigito(calcularSoma(gerarPesos(10), vetorCPF));
      boolean valido = false;
      for (int i = 0; i < vetorCPF.length; i++) {
        if (vetorCPF[0] != vetorCPF[i]) {
          valido = true;
        }
      }
      if ((valido) && (vetorCPF[9] == dig1) && (vetorCPF[10] == dig2)) {
        this.cpf = texto;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  public boolean validarCpfMascara (String texto) {
    if ((!"".equals(texto)) && (texto.length() == 14)) {
      char vetorCPF[] = new char[texto.length()];
      int inteiros[] = new int[texto.length()- 3];
      try {
        vetorCPF = texto.toCharArray();
        inteiros[0] = Character.getNumericValue(vetorCPF[0]);
        inteiros[1] = Character.getNumericValue(vetorCPF[1]);
        inteiros[2] = Character.getNumericValue(vetorCPF[2]);
        inteiros[3] = Character.getNumericValue(vetorCPF[4]);
        inteiros[4] = Character.getNumericValue(vetorCPF[5]);
        inteiros[5] = Character.getNumericValue(vetorCPF[6]);
        inteiros[6] = Character.getNumericValue(vetorCPF[8]);
        inteiros[7] = Character.getNumericValue(vetorCPF[9]);
        inteiros[8] = Character.getNumericValue(vetorCPF[10]);
        inteiros[9] = Character.getNumericValue(vetorCPF[12]);
        inteiros[10] = Character.getNumericValue(vetorCPF[13]);
      } catch (Exception e) {
        System.out.println("Não foi possível converter a string passada para a função em um vetor de inteiros");
        System.out.println(e);
      }
      int dig1 = calcularDigito(calcularSoma(gerarPesos(9), inteiros));
      inteiros[9] = dig1;
      int dig2 = calcularDigito(calcularSoma(gerarPesos(10), inteiros));
      boolean valido = false;
      for (int i = 0; i < inteiros.length; i++) {
        if (inteiros[0] != inteiros[i]) {
          valido = true;
        }
      }
      if ((valido) && (inteiros[9] == dig1) && (inteiros[10] == dig2)) {
        this.mascCpf= texto;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  
}
