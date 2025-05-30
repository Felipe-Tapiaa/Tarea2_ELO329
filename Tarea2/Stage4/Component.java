import javafx.scene.layout.VBox;

public abstract class Component extends VBox {
    public Component(String name, String topicName) {
        this.name = name;
        this.topicName = topicName;
    }

    public String getName() {
        return name;
    }

    public String getTopicName() {
        return topicName;
    }

   protected String name;
   protected String topicName;
}
