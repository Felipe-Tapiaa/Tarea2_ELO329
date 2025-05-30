import java.io.PrintStream;
import java.util.Scanner;

public class Monitor extends Subscriber {
    private PrintStream out;
    
    public Monitor(String name, String topicName, PrintStream out) {
        super(name, topicName);
        this.out = out;
    }

    public void update(String message) {
        Scanner in = new Scanner(message);
        if (in.hasNextInt()) {
            int x = in.nextInt();
            if (in.hasNextInt()) {
                int y = in.nextInt();
                double distancia = Math.sqrt(x * x + y * y);

                if (distancia > 500) {
                    out.println(getName() + "," + getTopicName() + "," + x + "," + y);
                }
            }
        }
    }
}
