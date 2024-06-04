package ru.otus.java.basic.homework10;

public class Main {
  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();

    phoneBook.find("Ivan");
    phoneBook.add("Igor", "79030547343");
    phoneBook.add("Igor", "79153748499");
    phoneBook.add("Ivan", "79095237648");
    System.out.println();
    phoneBook.find("Ivan");
    System.out.println();
    phoneBook.containsPhoneNumber("79153748499");
    phoneBook.containsPhoneNumber("79168372913");
    System.out.println();
    phoneBook.find("Igor");
  }
}
