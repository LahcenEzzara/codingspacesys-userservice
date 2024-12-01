package ma.ensamcasa.codingspacesys.userservice.service;

import ma.ensamcasa.codingspacesys.userservice.entity.Student;
import ma.ensamcasa.codingspacesys.userservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String registerStudent(String name, String email, String code, String password) {
        if (studentRepository.findByEmail(email).isPresent()) {
            return "Email is already registered.";
        }

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCode(code);
        student.setPassword(password);
        student.setVerified(false);
        studentRepository.save(student);

        return "Registration successful. Await admin approval.";
    }

    public String loginStudent(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isEmpty()) {
            return "Student not found.";
        }

        Student student = studentOpt.get();
        if (!student.getPassword().equals(password)) {
            return "Invalid credentials.";
        }

        if (!student.isVerified()) {
            return "Account not verified.";
        }

        return "Login successful!";
    }
}