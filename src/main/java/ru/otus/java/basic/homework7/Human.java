package ru.otus.java.basic.homework7;

import ru.otus.java.basic.homework7.transport.OnFoot;

public class Human {
  private final String name;
  private Transport currentTransport;
  private Transport defaultTransport;

  public Human(String name, int forces) {
    this.name = name;
    this.defaultTransport = new OnFoot("On foot", forces);
    this.currentTransport = this.defaultTransport;
  }

  public String getName() {
    return name;
  }

  public Transport getCurrentTransport() {
    return currentTransport;
  }

  public void onTransport(Transport transport) {
    if(currentTransport.getName() != "On foot"){
      System.out.println("Transport is already exist");
      return;
    }
    this.currentTransport = transport;
    System.out.printf("The %s on the %s\n", name, transport.getName());
  }

  public void leaveTransport(){
    if (currentTransport.getName() == "On foot"){
      System.out.println("There is no transport");
      return;
    }
    System.out.printf("The %s leave the %s\n", name, currentTransport.getName());
    this.currentTransport = this.defaultTransport;
  }

  public boolean move(int distance, Terrain terrain){// Делегируем перемещение
    return currentTransport.move(distance, terrain);
  }

  @Override
  public String toString() {
    return "Human{" +
            "name='" + name + '\'' +
            ", currentTransport=" + currentTransport.getName() +
            " resources=" + currentTransport.getResource() +
            '}';
  }
}
