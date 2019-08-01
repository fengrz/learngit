package springboot.mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.mysqldemo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long > {
}
