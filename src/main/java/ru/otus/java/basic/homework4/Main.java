package ru.otus.java.basic.homework4;

public class Main {
  public static void main(String[] args) {
    User users[] = {
            new User("Барышев", "Константин", "Игоревич", 1974, "baryshev@mail.ru"),
            new User("Скребцова", "Вероника", "Павловна", 2001, "skrebcova@mail.ru"),
            new User("Ефремов", "Вячеслав", "Иванович", 1999, "efremov@yandex.ru"),
            new User("Воробьева", "Елена", "Николаевна", 1970, "vorobeva@gmail.ru"),
            new User("Жихарев", "Николай", "Константинович", 1989, "jiharev@mail.ru"),
            new User("Захарова", "Ольга", "Владимировна", 2003, "zaharova@yandex.ru"),
            new User("Медведев", "Денис", "Григорьевич", 2000, "medvedev@gmail.ru"),
            new User("Гришина", "Татьяна", "Степановна", 1961, "grishina@gmail.ru"),
            new User("Егоров", "Абдул", "Загибович", 1998, "egorov@mail.ru"),
            new User("Воронцова", "Светлана", "Борисовна", 1983, "voroncova@mail.ru"),
    };

    int currentYear = 2024;

    for (User user : users) {
      if(currentYear - user.getYearOfBirth() > 40){
        user.info();
        System.out.println();
      }
    }
    System.out.println("===================================");

    Box box = new Box(23, 46,15, "Красный", false);
    box.info();
    System.out.println();
    box.putItem("Предмет");
    System.out.println();
    box.open();
    box.putItem("Предмет");
    box.close();
    System.out.println();
    box.info();
    System.out.println();
    box.open();
    box.extractItem();
    System.out.println();
    box.info();
    System.out.println();
    box.setColor("Синий");
    System.out.println();
    box.info();
  }
}

