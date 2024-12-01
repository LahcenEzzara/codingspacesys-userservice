package ma.ensamcasa.codingspacesys.userservice.repository;

import ma.ensamcasa.codingspacesys.userservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);

    void deleteByEmail(String email);
}
