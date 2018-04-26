package creational;

/**
 * Steps:
 * 1) Create a class with a private constructor with a static method to create it.
 * 2) Only allow classes to build the object using the static method exposed.
 */
public class FactoryPattern {

  public static void main(String[] args) {
    FactoryProduct productOne = FactoryProduct.createFactoryProduct(1);
    FactoryProduct productTwo = FactoryProduct.createFactoryProduct(2);
    System.out.println(productOne.getId());
    System.out.println(productTwo.getId());
  }

}

class FactoryProduct {

  private final int id;

  private FactoryProduct(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  static FactoryProduct createFactoryProduct(int id) {
    return new FactoryProduct(id);
  }
}