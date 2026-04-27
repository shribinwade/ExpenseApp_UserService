package userservice.services;

import org.springframework.stereotype.Service;
import userservice.DTOs.UserInfoDTO;
import userservice.Entities.UserInfo;
import userservice.repository.UserRepository;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfoDTO createOrUpdateUser(UserInfoDTO userInfoDTO){
        //here we can also use UnaryOperator if input and return are of same Type
        Function<UserInfo,UserInfo> updateUserInfo = (user)->{
            user.setUserId(userInfoDTO.getUserId());
            user.setFirstName(userInfoDTO.getFirstName());
            user.setLastName(userInfoDTO.getLastName());
            user.setEmail(userInfoDTO.getEmail());
            user.setPhoneNumber(userInfoDTO.getPhoneNumber());
            user.setProfilePic(userInfoDTO.getProfilePic());
            return userRepository.save(user);
        };

        Supplier<UserInfo> createUser = ()->{
            return userRepository.save(userInfoDTO.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDTO.getUserId())
                .map(updateUserInfo)
                .orElseGet(createUser);

         return UserInfoDTO.builder().userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .profilePic(userInfo.getProfilePic())
                .email(userInfo.getEmail()).build();
    }


    public UserInfoDTO getUser(UserInfoDTO userInfoDTO) throws Exception {
        Optional<UserInfo> user = userRepository.findByUserId(userInfoDTO.getUserId());

        if(user.isEmpty()){
            throw new Exception("User not Found");
        }
        UserInfo userInfo = user.get();
        return UserInfoDTO.builder().userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .profilePic(userInfo.getProfilePic())
                .email(userInfo.getEmail()).build();

    }
}
