package userservice.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Id;
import lombok.*;
import userservice.Entities.UserInfo;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDTO {

    @NonNull
    @JsonProperty("user_id")
    private String userId;

    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;

    @NonNull
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NonNull
    @JsonProperty("email")
    private String email;

    @JsonProperty("profile_pic")
    private String profilePic;


    public UserInfo transformToUserInfo(){
        return UserInfo.builder().userId(userId).firstName(firstName).lastName(lastName).email(email)
                .phoneNumber(phoneNumber)
                .profilePic(profilePic).build();
    }

}
