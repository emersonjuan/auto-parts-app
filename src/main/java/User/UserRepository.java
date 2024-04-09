package User;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByfName(String fName);
	List<User> findByRole(String role);
	
}
