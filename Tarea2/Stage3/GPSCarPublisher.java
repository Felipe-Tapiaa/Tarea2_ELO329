import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GPSCarPublisher extends Publisher {
    private ArrayList<GPSPosition> positions = new ArrayList<>();
    private int currentIndex = 0;
    private Timeline timeline;

    public GPSCarPublisher(String name, Broker broker, String topicName) {
        super(name, broker, topicName);
        createUI();
    }

    private void createUI() {
        VBox box = new VBox();
        Label label = new Label("Publicando posiciones GPS...");
        box.getChildren().add(label);
        this.getChildren().add(box);

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Selecciona archivo de posiciones");
        File file = chooser.showOpenDialog(null);

        if (file != null) {
            readPositions(file);
            startPublishing();
        }
    }

    private void readPositions(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int t = scanner.nextInt();
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                positions.add(new GPSPosition(t, x, y));
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private void startPublishing() {
        if (positions.isEmpty()) return;

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (currentIndex < positions.size()) {
                System.out.println("Publicando: " );
                GPSPosition pos = positions.get(currentIndex);
                publishNewEvent(pos.toString());
                currentIndex++;
            } else {
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
