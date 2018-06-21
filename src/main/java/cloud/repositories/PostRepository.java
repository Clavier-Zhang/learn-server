package cloud.repositories;

import cloud.entities.Follow;
import cloud.entities.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {

}
