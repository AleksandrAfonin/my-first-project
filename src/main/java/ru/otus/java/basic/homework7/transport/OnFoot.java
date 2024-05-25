package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Human;
import ru.otus.java.basic.homework7.Terrain;

import java.util.EnumMap;
import java.util.Map;

public class OnFoot implements Transport {
  private Human driver;
  private static final String name;
  private static Terrain[] notMove;
  private static Map<Terrain, Integer> moveTerrain;

  static {
    name = "On foot";
    notMove = new Terrain[]{};
    moveTerrain = new EnumMap<>(Terrain.class);
    moveTerrain.put(Terrain.PLAIN, 2);
    moveTerrain.put(Terrain.DENSE_FOREST, 4);
    moveTerrain.put(Terrain.SWAMP, 7);
  }

  public OnFoot(Human human) {
    this.driver = human;
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
    System.out.printf("The %s moved %s successfully\n", driver.getName(), name);
    return true;
  }

  @Override
  public boolean addDriver(Human human) {
    return false;
  }

  @Override
  public boolean deleteDriver() {
    return false;
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
    return "OnFoot{" +
            "name: '" + name + '\'' +
            ", maxEnergy: " + driver.getMaxEnergy() +
            ", currentEnergy: " + driver.getCurrentEnergy() +
            '}';
  }
}

