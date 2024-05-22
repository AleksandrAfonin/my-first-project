package ru.otus.java.basic.homework7;

import ru.otus.java.basic.homework7.transport.OnFoot;
import ru.otus.java.basic.homework7.transport.Transport;

public class Human {
  private final String name;
  private final int maxEnergy;
  private int currentEnergy;
  private Transport currentTransport;
  public final Transport defaultTransport;

  public Human(String name, int energy) {
    this.name = name;
    this.maxEnergy = energy;
    this.currentEnergy = energy;
    this.defaultTransport = new OnFoot(this);
    this.currentTransport = this.defaultTransport;
  }

  public String getName() {
    return name;
  }

  public int getCurrentEnergy() {
    return currentEnergy;
  }

  public int getMaxEnergy() {
    return maxEnergy;
  }

  public void setCurrentEnergy(int energy) {
    currentEnergy = energy;
  }

  public Transport getCurrentTransport() {
    return currentTransport;
  }

  public void onTransport(Transport transport) {
    if (!currentTransport.getName().equals(defaultTransport.getName())) {
      System.out.printf("Transport is already exist: %s\n", currentTransport.getName());
      return;
    }

    if (transport.addDriver(this)) {
      currentTransport = transport;
    }
  }

  public void leaveTransport() {
    if (currentTransport.getName().equals(defaultTransport.getName())) {
      System.out.printf("The %s has not a transport\n", name);
      return;
    }

    currentTransport.deleteDriver();
    currentTransport = defaultTransport;
  }

  public boolean move(int distance, Terrain terrain) {// Делегируем перемещение
    return currentTransport.move(distance, terrain);
  }

  @Override
  public String toString() {
    return "Human{" +
            "name: '" + name + '\'' +
            ", currentTransport: " + currentTransport.getName() +
            ", resources: " + currentTransport.getResource() +
            '}';
  }
}
