package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Human;
import ru.otus.java.basic.homework7.Terrain;

import java.util.EnumMap;
import java.util.Map;

public class Bicycle implements Transport {
  private Human driver;
  private final String name;
  private static Terrain[] notMove;
  private static Map<Terrain, Integer> moveTerrain;

  static {
    notMove = new Terrain[]{Terrain.SWAMP};
    moveTerrain = new EnumMap<>(Terrain.class);
    moveTerrain.put(Terrain.PLAIN, 1);
    moveTerrain.put(Terrain.DENSE_FOREST, 2);
  }

  public Bicycle(String name) {
    this.name = name;
  }

  @Override
  public boolean move(int distance, Terrain terrain) {
    for (Terrain ter : notMove) {
      if (ter == terrain) {
        System.out.printf("The %s cannot move through this area\n", name);
        return false;
      }
    }

    int spending = moveTerrain.get(terrain) * distance;
    if (driver.getCurrentEnergy() < spending) {
      System.out.println("There was not enough energy");
      return false;
    }

    driver.setCurrentEnergy(driver.getCurrentEnergy() - spending);
    System.out.printf("The %s moved on %s successfully\n", driver.getName(), name);
    return true;
  }

  @Override
  public boolean addDriver(Human human) {
    if (this.driver == null) {
      this.driver = human;
      System.out.printf("The %s on the %s\n", driver.getName(), name);
      return true;
    }

    System.out.printf("The %s already has a driver %s\n", name, driver.getName());
    return false;
  }

  @Override
  public boolean deleteDriver() {
    if (this.driver == null) {
      System.out.printf("The %s does not have a driver\n", name);
      return false;
    }

    System.out.printf("The %s left the %s\n", driver.getName(), name);
    this.driver = null;
    return true;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getResource() {
    return driver.getCurrentEnergy() + " energy";
  }

  @Override
  public String toString() {
    int maxEnergy = driver == null ? 0 : driver.getMaxEnergy();
    int currentEnergy = driver == null ? 0 : driver.getCurrentEnergy();
    return "Bicycle{" +
            "name: '" + name + '\'' +
            ", maxEnergy: " + maxEnergy +
            ", currentEnergy: " + currentEnergy +
            '}';
  }

}
