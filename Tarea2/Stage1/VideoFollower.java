import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VideoFollower extends Subscriber {
    private Button videoButton;

    public VideoFollower(String name, String topicName) {
        super(name, topicName);
        createUI();
    }

    private void createUI() {
        VBox box = new VBox();
        videoButton = new Button("Esperando publicación...");
        videoButton.setDisable(true);

        box.getChildren().add(videoButton);
        this.getChildren().add(box);
    }

    @Override
    public void update(String message) {
        videoButton.setText(message);
        videoButton.setDisable(false);
    }
}
