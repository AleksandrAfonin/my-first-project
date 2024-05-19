package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Terrain;
import ru.otus.java.basic.homework7.Transport;

import java.util.EnumMap;
import java.util.Map;

public class Car implements Transport {
  private String name;
  private int maxFuel;
  private int currentFuel;
  private Terrain[] notMove;
  private Map<Terrain, Integer> moveTerrain;

  public Car(String name, int fuel) {
    this.name = name;
    this.maxFuel = fuel;
    this.currentFuel = fuel;
    this.notMove = new Terrain[]{Terrain.DENSE_FOREST, Terrain.SWAMP};
    this.moveTerrain = new EnumMap<>(Terrain.class);
    this.moveTerrain.put(Terrain.PLAIN, 1);
  }

  public void addFuel(int fuel){
    if(fuel > maxFuel - currentFuel){
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
  public boolean move(int distance, Terrain terrain) {
    for (Terrain ter : notMove) {
      if (ter == terrain) {
        System.out.printf("The %s cannot move through this area\n", name);
        return false;
      }
    }
    int spending = moveTerrain.get(terrain) * distance;
    if(currentFuel < spending){
      System.out.println("There was not enough fuel");
      return false;
    }
    currentFuel -= spending;
    System.out.printf("The human moved by %s successfully\n", name);
    return true;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getResource(){
    return currentFuel + " fuel";
  }

  @Override
  public String toString() {
    return "Car{" +
            "name='" + name + '\'' +
            ", maxFuel=" + maxFuel +
            ", currentFuel=" + currentFuel +
            '}';
  }
}
