import java.util.ArrayList;

public class Broker {
   public Broker() {
      topics = new ArrayList<Topic>();
   }
   public Topic createTopic (String topicName){
      Topic topic = new Topic(topicName);
      topics.add(topic);
      return topic;
   }

   public boolean subscribe(Subscriber sub) {
      Topic topic = findTopic(sub.getTopicName());
      if ((topic = findTopic(sub.getTopicName())) != null) {
          topic.subscribe(sub);
          return true;
      } else {
          return false; // topic does not exist.
      }
  }
   private Topic findTopic (String topicName) {
      for (Topic t : topics) {
         if (t.hasThisName(topicName)) {
             return t;
         }
      }
      return null;  // topic not found
   }
   private ArrayList<Topic> topics;
}