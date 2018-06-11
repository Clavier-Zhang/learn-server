package cloud.repositories;

import cloud.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    User findByPhoneNumber(String phoneNumber);

    @Modifying
    @Query("update User u set u.posts = ?1, u.following= ?2 where u.id = ?3")
    @Transactional
    void setUserInfoById(Integer posts, Integer following, String userId);

}