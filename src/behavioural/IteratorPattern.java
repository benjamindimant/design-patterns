package behavioural;

/**
 * Steps:
 * 1) Create Iterator interface.
 * 2) Create Container interface.
 * 3) Create concrete Container class.
 * 3) Create concrete private inner class for Iterator inside of concrete Container.
 */
public class IteratorPattern {

  public static void main(String[] args) {
    Container container = new ConcreteContainer();

    for (Iterator iter = container.getIterator(); iter.hasNext(); ) {
      System.out.println(iter.next());
    }
  }

}

interface Iterator {
  boolean hasNext();
  Object next();
}

interface Container {
  Iterator getIterator();
}

class ConcreteContainer implements Container {
  Integer[] iterables = new Integer[]{1, 2, 3};

  @Override
  public Iterator getIterator() {
    return new ConcreteIterator();
  }

  private class ConcreteIterator implements Iterator {

    int index;

    @Override
    public boolean hasNext() {
      return index < iterables.length;
    }

    @Override
    public Object next() {
      return hasNext() ? iterables[index++] : null;
    }
  }
}