package behavioural;

/**
 * Steps:
 * 1) Create an interface.
 * 2) Create concrete classes implementing the same interface.
 * 3) Create context class.
 * 4) Create instances of the context classes.
 */
public class StrategyPattern {

  public static void main(String[] args) {
    Context contextOne = new Context(new ImplementationOne());
    Context contextTwo = new Context(new ImplementationTwo());
    contextOne.execute();
    contextTwo.execute();
  }

}

interface Strategy {
  void algorithm();
}

class ImplementationOne implements Strategy {

  @Override
  public void algorithm() {
    System.out.println("ImplementationOne");
  }
}

class ImplementationTwo implements Strategy {

  @Override
  public void algorithm() {
    System.out.println("ImplementationTwo");
  }
}

class Context {

  private final Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    this.strategy.algorithm();
  }
}
