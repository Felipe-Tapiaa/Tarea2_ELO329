import java.io.PrintStream;

public class Follower extends Subscriber {
   public Follower(String name, String topicName, PrintStream out) {
      super(name, topicName);
      this.out = out;
   }
   public void update(String message) {
      out.println(message);
      out.flush();  
   }
   private PrintStream out;
} 