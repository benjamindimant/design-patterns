package structural;

/**
 * I need an X, but I don't want to have to retrieve that X from its source every time.
 *
 * Steps:
 * 1) Identify interface of the real service and implement same interface in proxy service.
 * 2) Store the real service as a member of the proxy service.
 * 3) When access is attempted through proxy, if proxy does not store real service then load it from source.
 */
public class ProxyPattern {

  public static void main(String[] args) {
    RequestedService proxy = new ProxyService();
    System.out.println("First request:");
    proxy.action();

    System.out.println();

    System.out.println("Second request:");
    proxy.action();
  }

}

interface RequestedService {
  void action();
}

class ProxyService implements RequestedService {
  private RealService realService;

  public ProxyService() {
    this.realService = null;
  }

  @Override
  public void action() {
    // Takes time to get from source
    if (realService == null) {
      System.out.println("Retrieving from RealService");
      this.realService = new RealService();
    } else {
      System.out.println("Retrieving from ProxyService");
    }
    this.realService.action();
  }
}

class RealService implements RequestedService {

  @Override
  public void action() {
    System.out.println("Executing RealService action...");
  }
}