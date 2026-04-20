package userservice.deserializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import userservice.Entities.UserInfoDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class UserInfoDtoDeserializer implements Deserializer<UserInfoDTO> {

    @Override
    public UserInfoDTO deserialize(String arg0, byte[] arg1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDTO user = null;
       try{
          user= objectMapper.readValue(arg1,UserInfoDTO.class);
       } catch (Exception e) {
           System.out.println("can not deserialize");
           throw new RuntimeException(e);
       }
        return user;
    }

    @Override
    public void close(){}


}
