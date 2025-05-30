import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CarFollower extends Subscriber {
    private Label label;
    private Stage window;

    public CarFollower(String name, String topicName) {
        super(name, topicName);
        openWindow();
    }

    private void openWindow() {
        label = new Label("Esperando posiciones...");
        VBox box = new VBox(label);
        Scene scene = new Scene(box, 300, 100);
        window = new Stage();
        window.setTitle("Seguidor GPS - " + getName());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void update(String message) {
        label.setText("Posición actual:\n" + message);
    }
}
