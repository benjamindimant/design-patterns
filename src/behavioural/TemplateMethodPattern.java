package behavioural;

/**
 * Steps:
 * 1) Create an abstract class with a template method being final.
 * 2) Create concrete classes extending the above class.
 * 3) Create instances of the concrete classes.
 */

public class TemplateMethodPattern {

  public static void main(String[] args) {
    Template concreteOne = new ConcreteOne();
    Template concreteTwo = new ConcreteTwo();

    System.out.println("Execute ConcreteOne:");
    concreteOne.execute();
    System.out.println();
    System.out.println("Execute ConcreteTwo:");
    concreteTwo.execute();
  }
}

abstract class Template {

  public void algorithmPartI() {
    System.out.println("Part I: Template");
  }

  abstract void algorithmPartII();

  public final void execute() {
    algorithmPartI();
    algorithmPartII();
  }
}

class ConcreteOne extends Template {

  @Override
  void algorithmPartII() {
    System.out.println("Part II: Concrete One");
  }
}

class ConcreteTwo extends Template {

  @Override
  void algorithmPartII() {
    System.out.println("Part II: Concrete Two");
  }
}