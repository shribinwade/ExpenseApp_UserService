package userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.DTOs.UserInfoDTO;
import userservice.Entities.UserInfo;
import userservice.repository.UserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import userservice.services.UserService;

@Service
public class AuthServiceConsumer {

    private UserService userService;

    @Autowired
    AuthServiceConsumer(UserService userService)
    {
        this.userService = userService;
    }
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void lister(UserInfoDTO eventData){
         try{
             System.out.println("Received: " + eventData);
           //Todo: make it transactional ,to handle idempotency and validate email,phoneNumber etc. can use redis distributed locks
             userService.createOrUpdateUser(eventData);
         }catch (Exception ex){
             ex.printStackTrace();
         }
    }
}
