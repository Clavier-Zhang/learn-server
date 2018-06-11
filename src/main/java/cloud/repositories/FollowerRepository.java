package cloud.repositories;

import cloud.entities.Follow;
import org.springframework.data.repository.CrudRepository;


public interface FollowerRepository extends CrudRepository<Follow, Long> {

    Iterable<Follow> findAllByUserId(String userId);

    Iterable<Follow> findAllByFollowId(String followId);
}