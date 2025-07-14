package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
