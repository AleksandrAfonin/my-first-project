package ru.otus.java.basic.homework6;

public class Cat {
  private String name;
  private int appetite;
  private boolean isSatiety;

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
    //this.isSatiety = false;
    // Поле по-умолчанию фолсом и заполнится можно было в явном виде не прописывать
  }

  public void eat(Plate plate) {
    if (isSatiety) {
      System.out.println("Кот " + this.name + " сыт и есть не будет");
      //this обычно используется когда есть неоднозначность использования имени поля/аргумента
      return;
    }
    if (!plate.decreaseFood(this.appetite)) {
      System.out.println("Кот " + this.name + " не поел, не хватило еды");
      return;
    }
    this.isSatiety = true;
    System.out.println("Кот " + this.name + " поел");
  }

  @Override
  public String toString() {
    return "Cat{" +
            "name='" + name + '\'' +
            ", appetite=" + appetite +
            ", isSatiety=" + isSatiety +
            '}';
  }
}
