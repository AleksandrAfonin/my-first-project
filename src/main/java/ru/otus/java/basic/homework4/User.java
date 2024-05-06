package ru.otus.java.basic.homework4;

public class User {
  private String surname;
  private String name;
  private String patronymic;
  private int yearOfBirth;
  private String email;

  public User(String surname, String name, String patronymic, int yearOfBirth, String email) {
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.yearOfBirth = yearOfBirth;
    this.email = email;
  }

  public void info() {
    System.out.println("ФИО: " + surname + " " + name + " " + patronymic);
    System.out.println("Год рождения: " + yearOfBirth);
    System.out.println("e-mail: " + email);
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
