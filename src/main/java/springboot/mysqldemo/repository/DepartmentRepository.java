package springboot.mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.mysqldemo.entity.Deparment;

@Repository
public interface DepartmentRepository extends JpaRepository<Deparment,Long > {

}
