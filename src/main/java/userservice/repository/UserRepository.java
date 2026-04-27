package userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userservice.DTOs.UserInfoDTO;
import userservice.Entities.UserInfo;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,String> {

    Optional<UserInfo> findByUserId(String userId);

}
