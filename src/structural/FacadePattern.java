package structural;

/**
 * I have an X, but I want a simpler X.
 * Steps:
 * 1) Identify Complex class.
 * 2) Create Facade class and include Complex class as a field.
 * 3) Implement and expose simple methods that use the complex internal logic of the Complex class.
 * 4) Replace all instances of the Complex class with the Facade class.
 */
public class FacadePattern {

  public static void main(String[] args) {
    ComplexClass complex = new ConcreteComplexClass();
    Facade simple = new Facade(complex);
    simple.simpleAction();
  }

}

class Facade {
  private ComplexClass complex;

  public Facade(ComplexClass complex) {
    this.complex = complex;
  }

  public void simpleAction() {
    complex.complexAction();
  }
}

interface ComplexClass {
  void complexAction();
}

class ConcreteComplexClass implements ComplexClass {

  @Override
  public void complexAction() {
    System.out.println("Executing complexAction in " + ConcreteComplexClass.class + "...");
  }
}
