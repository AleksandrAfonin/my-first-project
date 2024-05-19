package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Terrain;
import ru.otus.java.basic.homework7.Transport;

import java.util.EnumMap;
import java.util.Map;

public class OnFoot implements Transport {
  private String name;
  static int maxForces;
  static int currentForces;
  private Terrain[] notMove;
  private Map<Terrain, Integer> moveTerrain;

  public OnFoot(String name, int forces) {
    this.name = name;
    this.maxForces = forces;
    this.currentForces = forces;
    this.notMove = new Terrain[]{};
    this.moveTerrain = new EnumMap<>(Terrain.class);
    this.moveTerrain.put(Terrain.PLAIN, 2);
    this.moveTerrain.put(Terrain.DENSE_FOREST, 4);
    this.moveTerrain.put(Terrain.SWAMP, 7);
  }

  OnFoot(){}

  public void addForces(int forces){
    if(forces > maxForces - currentForces){
      currentForces = maxForces;
      return;
    }
    currentForces += forces;
  }

  public int getMaxForces() {
    return maxForces;
  }

  public int getCurrentForces() {
    return currentForces;
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
    if(currentForces < spending){
      System.out.println("There was not enough forces");
      return false;
    }
    currentForces -= spending;
    System.out.printf("The human moved %s successfully\n", name);
    return true;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getResource(){
    return currentForces + " forces";
  }

  @Override
  public String toString() {
    return "OnFoot{" +
            "name='" + name + '\'' +
            ", maxForces=" + maxForces +
            ", currentForces=" + currentForces +
            '}';
  }
}

