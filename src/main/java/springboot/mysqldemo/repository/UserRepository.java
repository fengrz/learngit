package springboot.mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.mysqldemo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long > {


}
