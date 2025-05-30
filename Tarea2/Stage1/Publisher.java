public class Publisher extends Component {
   
   public Publisher(String name, Broker broker, String topicName) {
      super(name, topicName); 
      this.topic = broker.createTopic(topicName);
   }
   protected void publishNewEvent(String message) {
      if (topic != null) {
         topic.notify(message); 
     }
   }
   private Topic topic; 
}