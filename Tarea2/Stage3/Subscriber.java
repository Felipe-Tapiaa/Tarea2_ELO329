public abstract class Subscriber extends Component {

   public Subscriber(String name, String topicName) {
      super(name, topicName);
   }
   public abstract void update(String message);
}