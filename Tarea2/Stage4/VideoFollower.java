import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VideoFollower extends Subscriber {
    private Button videoButton;
    private String lastURL = "";

    public VideoFollower(String name, String topicName) {
        super(name, topicName);
        createUI();
    }

    private void createUI() {
        VBox box = new VBox();
        videoButton = new Button("Esperando publicación...");
        videoButton.setDisable(true);

        videoButton.setOnAction(e -> {
            if (!lastURL.isEmpty()) {
                try {
                    Media media = new Media("https://download.samplelib.com/mp4/sample-5s.mp4");
                    MediaPlayer player = new MediaPlayer(media);
                    MediaView view = new MediaView(player);

                    VBox vbox = new VBox(view);
                    Scene scene = new Scene(vbox, 640, 480);

                    Stage stage = new Stage();
                    stage.setTitle("Reproductor de video");
                    stage.setScene(scene);
                    stage.show();

                    player.play();
                } catch (Exception ex) {
                    System.out.println("Error al reproducir el video: " + ex.getMessage());
                }
            }
        });

        box.getChildren().add(videoButton);
        this.getChildren().add(box);
    }

    @Override
    public void update(String message) {
        lastURL = message;
        videoButton.setText("Ver video");
        videoButton.setDisable(false);
    }
}

