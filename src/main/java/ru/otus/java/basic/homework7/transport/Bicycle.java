package ru.otus.java.basic.homework7.transport;

import ru.otus.java.basic.homework7.Terrain;
import ru.otus.java.basic.homework7.Transport;

import java.util.EnumMap;
import java.util.Map;

public class Bicycle extends OnFoot implements Transport {
  private final String name;
  private final Terrain[] notMove;
  private final Map<Terrain, Integer> moveTerrain;

  public Bicycle(String name){
    super();
    this.name = name;
    this.notMove = new Terrain[]{Terrain.SWAMP};
    this.moveTerrain = new EnumMap<>(Terrain.class);
    this.moveTerrain.put(Terrain.PLAIN, 1);
    this.moveTerrain.put(Terrain.DENSE_FOREST, 2);
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
    System.out.printf("The human moved on %s successfully\n", name);
    return true;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Bicycle{" +
            "name='" + name + '\'' +
            ", maxForces=" + maxForces +
            ", currentForces=" + currentForces +
            '}';
  }

}
