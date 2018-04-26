package creational;

/**
 * Steps:
 * 1) Create the complex Constructable class to be built.
 * 2) Create a ConstructableBuilder class with the fields of the Constructable.
 * 3) Implement withXXX() methods and build() method.
 * 4) Use builder instead of directly creating Constructable using its methods.
 */
public class BuilderPattern {

  public static void main(String[] args) {
    ConstructableBuilder builder = new ConstructableBuilder();
    Constructable constructable = builder.withX(1).withY(2).withZ(3).build();

    System.out.println("Constructable's x: " + constructable.getX());
    System.out.println("Constructable's y: " + constructable.getY());
    System.out.println("Constructable's z: " + constructable.getZ());
  }

}

class ConstructableBuilder {
  private int x;
  private int y;
  private int z;

  public ConstructableBuilder withX(int x) {
    this.x = x;
    return this;
  }

  public ConstructableBuilder withY(int y) {
    this.y = y;
    return this;
  }

  public ConstructableBuilder withZ(int z) {
    this.z = z;
    return this;
  }

  public Constructable build() {
    Constructable constructable = new Constructable(this.x);
    constructable.setY(this.y);
    constructable.setZ(this.z);
    return constructable;
  }
}

class Constructable {
  private final int x;
  private int y;
  private int z;

  public Constructable(int x) {
    this.x = x;
    this.y = 0;
    this.z = 0;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }
}