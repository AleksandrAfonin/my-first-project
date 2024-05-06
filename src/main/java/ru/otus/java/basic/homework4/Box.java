package ru.otus.java.basic.homework4;

public class Box {
  private final double width;
  private final double height;
  private final double depth;
  private String color;
  private Boolean isOpen;
  private String item;

  public Box(double width, double height, double depth, String color, Boolean isOpen){
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.color = color;
    this.isOpen = isOpen;
    this.item = null;
  }

  public Box(double width, double height, double depth, String color, Boolean isOpen, String item){
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.color = color;
    this.isOpen = isOpen;
    this.item = item;
  }

  public Box(double size, String color, Boolean isOpen){
    width = size;
    height = size;
    depth = size;
    this.color = color;
    this.isOpen = isOpen;
    this.item = null;
  }

  public Box(double size, String color, Boolean isOpen, String item){
    width = size;
    height = size;
    depth = size;
    this.color = color;
    this.isOpen = isOpen;
    this.item = item;
  }

  public void info(){
    System.out.println("Ширина: " + width);
    System.out.println("Высота: " + height);
    System.out.println("Глубина: " + depth);
    System.out.println("Цвет: " + color);
    System.out.println(isOpen ? "Коробка открыта" : "Кробка закрыта");
    System.out.println(item == null ? "Коробка пуста" : "В коробке " + item);
  }

  public void close(){
    isOpen = false;
    System.out.println("Коробка закрыта");
  }

  public void open(){
    isOpen = true;
    System.out.println("Коробка открыта");
  }

  public boolean isOpen(){
    return isOpen;
  }

  public void setColor(String color){
    if(this.color.equals(color)){
      System.out.println("Коробка таково же цвета");
      return;
    }
    this.color = color;
    System.out.println("Новый цвет " + this.color);
  }

  public String getColor(){
    return color;
  }

  public void putItem(String newItem){
    if(newItem == null){
      System.out.println("Нечего класть в коробку");
      return;
    }
    if (!isOpen){
      System.out.println("Коробка закрыта, нельзя положить");
      return;
    }
    if(this.item != null){
      System.out.println("Коробка занята, нельзя положить");
      return;
    }
    item = newItem;
    System.out.println("В коробку положен " + item);
  }

  public void extractItem(){
    if (!isOpen){
      System.out.println("Коробка закрыта, нельзя извлечь");
    }
    if (item == null){
      System.out.println("Нечего извлекать из коробки");
      return;
    }
    System.out.println(item + " извлечен из коробки");
    item = null;
  }
}
