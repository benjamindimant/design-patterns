package creational;

/**
 * Steps:
 * 1) Create Singleton class.
 * 2) Include method: private static final <class> INSTANCE = new <class>();
 * 3) Include method: public static <class> getInstance() { return INSTANCE; }
 */
public class SingletonPattern {

  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
    System.out.println(singleton.getClass());
  }

}

class Singleton {
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return INSTANCE;
  }
}