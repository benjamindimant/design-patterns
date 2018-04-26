package behavioural;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Steps:
 * 1) Create the Command interface (skip if using a built in one like Runnable).
 * 2) Create the concrete Command classes.
 * 3) Create the CommandQueue class.
 */
public class CommandPattern {

  public static void main(String[] args) {
    CommandQueue queue = new CommandQueue();
    ConcreteCommand c1 = new ConcreteCommand(1);
    ConcreteCommand c2 = new ConcreteCommand(2);

    queue.add(c1);
    queue.add(c2);

    queue.executeAll();
  }

}

// This is just to keep consistency of the class namings in the pattern
interface Command extends Runnable {

}

class ConcreteCommand implements Command {

  private final int state;

  public ConcreteCommand(int state) {
    this.state = state;
  }

  @Override
  public void run() {
    System.out.println("ConcreteCommand " + this.state + " is running");
  }
}

class CommandQueue {
  private final Queue<Command> queue = new LinkedList<>();

  public void add(Command command) {
    queue.add(command);
  }

  public void executeAll() {
    queue.forEach(Runnable::run);
  }
}
