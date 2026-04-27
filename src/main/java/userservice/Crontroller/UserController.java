package userservice.Crontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.DTOs.UserInfoDTO;
import userservice.services.UserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUpdate")
    public ResponseEntity<UserInfoDTO> createUpdate(@RequestBody UserInfoDTO userInfoDTO){
        try{
            UserInfoDTO user = userService.createOrUpdateUser(userInfoDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserInfoDTO> getUser(UserInfoDTO userInfoDTO){
        try{
          UserInfoDTO user = userService.getUser(userInfoDTO);
          return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
