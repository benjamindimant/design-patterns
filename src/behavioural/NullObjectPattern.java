package behavioural;

/**
 * Steps:
 * 1) Create an abstract class.
 * 2) Create the regular classes.
 * 3) Create the class to handle the null case.
 */
public class NullObjectPattern {

  public static void main(String[] args) {
    AnyClass something = new DoesNothing();
    AnyClass somethingElse = new DoesSomething();

    // Neither throws a NULL exception
    something.action();
    somethingElse.action();
  }

}

abstract class AnyClass {
  abstract void action();
}

class DoesSomething extends AnyClass {

  @Override
  public void action() {
    System.out.println("Doing something");
  }
}

class DoesNothing extends AnyClass {

  @Override
  public void action() {

  }
}
