package behavioural;

/**
 * Steps:
 * 1) Create an abstract class with a template method being final.
 * 2) Create concrete classes extending the above class.
 * 3) Create instances of the concrete classes.
 */

public class TemplateMethodPattern {

  public static void main(String[] args) {
    TemplateMethod concreteOne = new ConcreteOne();
    TemplateMethod concreteTwo = new ConcreteTwo();

    System.out.println("Execute ConcreteOne:");
    concreteOne.execute();
    System.out.println();
    System.out.println("Execute ConcreteTwo:");
    concreteTwo.execute();
  }
}

abstract class TemplateMethod {

  public void algorithmPartI() {
    System.out.println("Part I: TemplateMethod");
  }

  abstract void algorithmPartII();

  public final void execute() {
    algorithmPartI();
    algorithmPartII();
  }
}

class ConcreteOne extends TemplateMethod {

  @Override
  void algorithmPartII() {
    System.out.println("Part II: Concrete One");
  }
}

class ConcreteTwo extends TemplateMethod {

  @Override
  void algorithmPartII() {
    System.out.println("Part II: Concrete Two");
  }
}