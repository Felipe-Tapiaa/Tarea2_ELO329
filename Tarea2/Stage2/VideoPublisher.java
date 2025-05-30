import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VideoPublisher extends Publisher {
    private TextField urlField;

    public VideoPublisher(String name, Broker broker, String topicName) {
        super(name, broker, topicName);
        createUI();
    }

    private void createUI() {
        VBox box = new VBox();
        box.setSpacing(10);
        urlField = new TextField();
        urlField.setPromptText("Ingrese URL del video y presione ENTER");

        urlField.setOnAction(e -> {
            String url = urlField.getText();
            if (!url.isEmpty()) {
                publishNewEvent(url);
                urlField.clear();
            }
        });

        box.getChildren().addAll(urlField);
        this.getChildren().add(box);  // Component hereda de algún tipo de contenedor gráfico
    }
}
