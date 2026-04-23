package userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.repository.UserRepository;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class AuthServiceConsumer {

    private UserRepository userRepository;

    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void lister(Object eventData){
         try{
             System.out.println("Received: " + eventData);
         }catch (Exception ex){
             ex.printStackTrace();
         }
    }



}
