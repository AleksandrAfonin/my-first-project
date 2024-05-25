package ru.otus.java.basic.tests.task4;

public class MathUtilsFactorial {
  public static void main(String[] args) {
    System.out.println("Факториал от 5 должен равняться 120 - " + getFactorial((byte) 5));
  }

  public static long getFactorial(byte number) {
    if(number < 0){
      return 0;
    }

    long factorial = 1L;
    for(int i = number; i > 0; i--){
      try{
        factorial *= i;
      }catch(Exception e){
        return 0;
      }
    }
    return factorial;
  }
}
