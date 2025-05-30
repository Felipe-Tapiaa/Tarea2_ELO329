import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage4 extends Application {
    private Broker broker = new Broker();
    private HBox publishers = new HBox(10);
    private HBox subscribers = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        // Menú Publicadores
        Menu publisherMenu = new Menu("Publisher");
        MenuItem videoPub = new MenuItem("Video");
        videoPub.setOnAction(e -> createVideoPublisher());

        MenuItem gpsPub = new MenuItem("Car's GPS");
        gpsPub.setOnAction(e -> createGPSPublisher());

        publisherMenu.getItems().addAll(videoPub, gpsPub);

        // Menú Subscriptores
        Menu subscriberMenu = new Menu("Subscriber");
        MenuItem videoSub = new MenuItem("Video");
        videoSub.setOnAction(e -> createVideoFollower());

        MenuItem gpsSub = new MenuItem("GPS Follower");
        gpsSub.setOnAction(e -> createGPSFollower());

        subscriberMenu.getItems().addAll(videoSub, gpsSub);
        menuBar.getMenus().addAll(publisherMenu, subscriberMenu);

        VBox root = new VBox(menuBar, publishers, subscribers);
        Scene scene = new Scene(root, 900, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stage 4 - Simulador Pub/Sub");
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

    private void createGPSPublisher() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Nombre del publicador:");
        dialog.showAndWait().ifPresent(name -> {
            TextInputDialog topicDialog = new TextInputDialog();
            topicDialog.setHeaderText("Nombre del tópico:");
            topicDialog.showAndWait().ifPresent(topicName -> {
                GPSCarPublisher pub = new GPSCarPublisher(name, broker, topicName);
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

    private void createGPSFollower() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Nombre del suscriptor:");
        dialog.showAndWait().ifPresent(name -> {
            TextInputDialog topicDialog = new TextInputDialog();
            topicDialog.setHeaderText("Nombre del tópico:");
            topicDialog.showAndWait().ifPresent(topicName -> {
                CarFollower sub = new CarFollower(name, topicName);
                broker.subscribe(sub);
                // No se agrega al panel derecho porque es ventana separada
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
