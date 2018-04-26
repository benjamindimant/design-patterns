package structural;

/**
 * I have an X, but I want a better X.
 *
 * Steps:
 * 1) Identify the worse concrete implementation of the same Service.
 * 2) Include that worse implementation as a field of the Decorator.
 * 3) Include the Decorator as a field of the Client.
 */
public class DecoratorPattern {

  public static void main(String[] args) {
    SameService worseService = new WorseService();
    SameService betterService = new Decorator(worseService);
    FancyClient client = new FancyClient(betterService);
    client.useService();
  }

}

interface SameService {
  void action();
}

class Decorator implements SameService {

  private final SameService worseService;

  public Decorator(SameService worseService) {
    this.worseService = worseService;
  }

  @Override
  public void action() {
    System.out.println("I do this: ");
    worseService.action();
    System.out.println("And I can also do this thing better...");
  }
}

class WorseService implements SameService {
  @Override
  public void action() {
    System.out.println("Executing WorseService action...");
  }
}

class FancyClient {
  private final SameService service;

  public FancyClient(SameService decorator) {
    this.service = decorator;
  }

  public void useService() {
    service.action();
  }

}
