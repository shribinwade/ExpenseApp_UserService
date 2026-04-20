package userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userservice.Entities.UserInfoDTO;

@Repository
public interface UserRepository extends JpaRepository<UserInfoDTO,String> {

    UserInfoDTO findByUserId(String userId);

}
