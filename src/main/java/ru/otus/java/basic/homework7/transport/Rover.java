package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Human;
import ru.otus.java.basic.homework7.Terrain;

import java.util.EnumMap;
import java.util.Map;

public class Rover implements Transport {
  private Human driver;
  private final String name;
  private final int maxFuel;
  private int currentFuel;
  private static Terrain[] notMove;
  private static Map<Terrain, Integer> moveTerrain;

  static {
    notMove = new Terrain[]{};
    moveTerrain = new EnumMap<>(Terrain.class);
    moveTerrain.put(Terrain.PLAIN, 1);
    moveTerrain.put(Terrain.DENSE_FOREST, 1);
    moveTerrain.put(Terrain.SWAMP, 1);
  }

  public Rover(String name, int fuel) {
    this.name = name;
    this.maxFuel = fuel;
    this.currentFuel = fuel;
  }

  public void addFuel(int fuel) {
    if (fuel > maxFuel - currentFuel) {
      currentFuel = maxFuel;
      return;
    }
    currentFuel += fuel;
  }

  public int getMaxFuel() {
    return maxFuel;
  }

  public int getCurrentFuel() {
    return currentFuel;
  }

  @Override
  public boolean addDriver(Human human) {
    if (this.driver == null) {
      this.driver = human;
      System.out.printf("The %s on the %s\n", human.getName(), name);
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
  public boolean move(int distance, Terrain terrain) {
    for (Terrain ter : notMove) {
      if (ter == terrain) {
        System.out.printf("The %s cannot move through this area\n", name);
        return false;
      }
    }

    int spending = moveTerrain.get(terrain) * distance;
    if (currentFuel < spending) {
      System.out.println("There was not enough fuel");
      return false;
    }

    currentFuel -= spending;
    System.out.printf("The %s moved by %s successfully\n", driver.getName(), name);
    return true;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getResource() {
    return currentFuel + " fuel";
  }

  @Override
  public String toString() {
    return "Rover{" +
            "name: '" + name + '\'' +
            ", maxFuel: " + maxFuel +
            ", currentFuel: " + currentFuel +
            '}';
  }
}
