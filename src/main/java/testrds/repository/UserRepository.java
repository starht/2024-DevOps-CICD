package testrds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testrds.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
