package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
