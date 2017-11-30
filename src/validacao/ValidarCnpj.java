/*
  Autor: Thiago Baldykowski
  Data: 22/10/2017
*/
package validacao;

import validacao.Conversao;

public class ValidarCnpj {
  /*
    campos::
  */
  private String cnpj;
  private String mascCnpj;

  /*
    construtores::
  */
  public ValidarCnpj() {
  }

  /*
    gets e sets::
  */
  public String getCnpj() {
    return cnpj;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
  public String getMascCnpj() {
    return mascCnpj;
  }
  public void setMascCnpj(String mascCnpj) {
    this.mascCnpj = mascCnpj;
  }

  /*
    ações::
  */
  private int[] gerarPesos (int tamanho) {
    int contador = 2;
    int pesos[] = new int[tamanho];
    for (int i = 1; i < tamanho + 1; i++) {
      pesos[pesos.length - i] = contador;
      contador++;
      if (contador == 10) {
        contador = 2; 
      }
    }
    return pesos;
  }
  private int calcularSoma (int pesos[], int numeros[]) {
    int soma = 0;
    if (numeros.length >= 12) {
      for (int i = 0; i < pesos.length; i++) {
        soma += pesos[i] * numeros[i];
      }
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
  public boolean validarCnpj (String texto) {
    if ((!"".equals(texto)) && (texto.length() == 14)) {
      Conversao cv = new Conversao();
      int inteiros[] = new int[texto.length()];
      try {
        inteiros = cv.intArray(texto);
      } catch (Exception e) {
        System.out.println("Não foi possível converter a string passada para a função em um vetor de inteiros");
        System.out.println(e);
      }
      int dig1 = calcularDigito(calcularSoma(gerarPesos(12), inteiros));
      inteiros[12] = dig1;
      int dig2 = calcularDigito(calcularSoma(gerarPesos(13), inteiros));
      boolean valido = false;
      for (int i = 0; i < inteiros.length; i++) {
        if (inteiros[i] != inteiros[0]) {
          valido = true;
        }
      }
      if ((valido) && (dig1 == inteiros[12]) && (dig2 == inteiros[13])) {
        this.cnpj = texto;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
    
  }
  public boolean validaCnpjMascara (String texto) {
    if ((!"".equals(texto)) && (texto.length() == 18)) {
      char vetorCNPJ[] = new char[texto.length()];
      int inteiros[] = new int[texto.length() - 3];
      try {
        vetorCNPJ = texto.toCharArray();
        inteiros[0] = Character.getNumericValue(vetorCNPJ[0]);
        inteiros[1] = Character.getNumericValue(vetorCNPJ[1]);
        inteiros[2] = Character.getNumericValue(vetorCNPJ[3]);
        inteiros[3] = Character.getNumericValue(vetorCNPJ[4]);
        inteiros[4] = Character.getNumericValue(vetorCNPJ[5]);
        inteiros[5] = Character.getNumericValue(vetorCNPJ[7]);
        inteiros[6] = Character.getNumericValue(vetorCNPJ[8]);
        inteiros[7] = Character.getNumericValue(vetorCNPJ[9]);
        inteiros[8] = Character.getNumericValue(vetorCNPJ[11]);
        inteiros[9] = Character.getNumericValue(vetorCNPJ[12]);
        inteiros[10] = Character.getNumericValue(vetorCNPJ[13]);
        inteiros[11] = Character.getNumericValue(vetorCNPJ[14]);
        inteiros[12] = Character.getNumericValue(vetorCNPJ[16]);
        inteiros[13] = Character.getNumericValue(vetorCNPJ[17]);
      } catch (Exception e) {
        System.out.println("Não foi possível converter a string passada para a função em um vetor de inteiros");
        System.out.println(e);
      }
      int dig1 = calcularDigito(calcularSoma(gerarPesos(12), inteiros));
      inteiros[12] = dig1;     
      int dig2 = calcularDigito(calcularSoma(gerarPesos(13), inteiros));
      boolean valido = false;
      for (int i = 0; i < inteiros.length - 3; i++) {
        if (inteiros[i] != inteiros[0]) {
          valido = true;
        }
      }
      if ((valido) && (dig1 == inteiros[12]) && (dig2 == inteiros[13])) {
        this.cnpj = texto;
        return true;
      } else {
        return false;
      }
    } else {
      
      return false;
    }
  }

  
}
