import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage2 extends Application {
    private Broker broker = new Broker();
    private HBox publishers = new HBox(10);
    private HBox subscribers = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        Menu publisherMenu = new Menu("Publisher");
        MenuItem videoPub = new MenuItem("Video");
        videoPub.setOnAction(e -> createVideoPublisher());

        Menu subscriberMenu = new Menu("Subscriber");
        MenuItem videoSub = new MenuItem("Video");
        videoSub.setOnAction(e -> createVideoFollower());

        publisherMenu.getItems().add(videoPub);
        subscriberMenu.getItems().add(videoSub);
        menuBar.getMenus().addAll(publisherMenu, subscriberMenu);

        VBox root = new VBox(menuBar, publishers, subscribers);
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etapa 1 - Video Pub/Sub");
        primaryStage.show();
    }

    private void createVideoPublisher() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Nombre del publicador:");
        dialog.showAndWait().ifPresent(name -> {
            TextInputDialog topicDialog = new TextInputDialog();
            topicDialog.setHeaderText("Nombre del tópico:");
            topicDialog.showAndWait().ifPresent(topicName -> {
                VideoPublisher pub = new VideoPublisher(name, broker, topicName);
                publishers.getChildren().add(pub);
            });
        });
    }

    private void createVideoFollower() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Nombre del suscriptor:");
        dialog.showAndWait().ifPresent(name -> {
            TextInputDialog topicDialog = new TextInputDialog();
            topicDialog.setHeaderText("Nombre del tópico:");
            topicDialog.showAndWait().ifPresent(topicName -> {
                VideoFollower sub = new VideoFollower(name, topicName);
                broker.subscribe(sub);
                subscribers.getChildren().add(sub);
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
