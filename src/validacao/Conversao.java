/*
  Autor: Thiago Baldykowski
  Data: 22/10/2017
*/
package validacao;

public class Conversao {
  
  
  public int[] intArray (int numero) {
    String texto = Integer.toString(numero);
    int array[] = new int[texto.length()];
    for (int i = 0; i < texto.length(); i++) {
      array[i] = Character.getNumericValue(texto.charAt(i));
    }
    return array;
  }
  public int[] intArray (long numero) {
    String texto = Long.toString(numero);
    int array[] = new int[texto.length()];
    for (int i = 0; i < texto.length(); i++) {
      array[i] = Character.getNumericValue(texto.charAt(i));
    }
    return array;
  }
  public int[] intArray (String texto) {
    int numero[] = new int[texto.length()];
    for (int i = 0; i < numero.length; i++) {
      numero[i] = Character.getNumericValue(texto.charAt(i));
    }
    return numero;
  }
  public long[] longArray (long numero) {
    String texto = Long.toString(numero);
    long array[] = new long[texto.length()];
    for (int i = 0; i < texto.length(); i++) {
      array[i] = Character.getNumericValue(texto.charAt(i));
    }
    return array;
  }
  public double[] doubleArray (double numero) {
    String texto = Double.toString(numero);
    double array[] = new double[texto.length()];
    for (int i = 0; i < texto.length(); i++) {
      array[i] = Character.getNumericValue(texto.charAt(i));
    }
    return array;
  }
  public int arrayInt (int array[]) {
    String texto = new String();
    for (int i = 0; i < array.length; i++) {
      texto = texto.concat(String.format("%d", array[i]));
    }
    return Integer.parseInt(texto);
  }
  public long arrayLong (long array[]) {
    String texto = new String();
    for (int i = 0; i < array.length; i++) {
      texto = texto.concat(String.format("%d", array[i]));
    }
    return Long.parseLong(texto);
  }
  public long arrayLong (int array[]) {
    String texto = new String();
    for (int i = 0; i < array.length; i++) {
      texto = texto.concat(String.format("%d", array[i]));
    }
    return Long.parseLong(texto);
  }
  
  
}
