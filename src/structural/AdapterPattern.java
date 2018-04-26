package structural;

/**
 * I have an X, but I need a Y.
 *
 * Steps:
 * 1) Identify the adaptee (class that needs to be adapted).
 * 2) Identify the target interface (Service) that the Client uses and wants the Adaptee to resemble.
 * 3) Create the concrete Adapter class which implements that target interface and has the Adaptee as a member.
 * 4) Include the Adapter as a field of the Client.
 */
public class AdapterPattern {

  public static void main(String[] args) {
    Adaptee legacySystem = new Adaptee();
    Adapter newSystem = new Adapter(legacySystem);
    Client client = new Client(newSystem);
    client.useService();
  }

}

interface Service {
  void request();
}

class Adapter implements Service {

  private final Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    System.out.println("NEW SERVICE:");
    System.out.println(adaptee.action() + "\nExecuting new action...");
  }
}

class Adaptee {
  public String action() {
    return "Executing old action...";
  }
}

class Client {
  private final Service service;

  public Client(Service adapter) {
    this.service = adapter;
  }

  public void useService() {
    service.request();
  }

}

