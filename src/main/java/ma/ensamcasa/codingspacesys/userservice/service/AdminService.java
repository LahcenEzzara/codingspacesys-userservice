package ma.ensamcasa.codingspacesys.userservice.service;

import ma.ensamcasa.codingspacesys.userservice.entity.Admin;
import ma.ensamcasa.codingspacesys.userservice.entity.Student;
import ma.ensamcasa.codingspacesys.userservice.repository.AdminRepository;
import ma.ensamcasa.codingspacesys.userservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final StudentRepository studentRepository;

    public AdminService(AdminRepository adminRepository, StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    public String loginAdmin(String email, String password) {
        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isEmpty()) {
            return "Admin not found.";
        }

        Admin admin = adminOpt.get();
        if (!admin.getPassword().equals(password)) {
            return "Invalid credentials.";
        }

        return "Login successful!";
    }

    public String approveStudent(String studentEmail) {
        Optional<Student> studentOpt = studentRepository.findByEmail(studentEmail);
        if (studentOpt.isEmpty()) {
            return "Student not found.";
        }

        Student student = studentOpt.get();
        student.setVerified(true);
        studentRepository.save(student);

        return "Student approved.";
    }

    public String deleteStudent(String studentEmail) {
        Optional<Student> studentOpt = studentRepository.findByEmail(studentEmail);
        if (studentOpt.isEmpty()) {
            return "Student not found.";
        }
        studentRepository.deleteByEmail(studentEmail);
        return "Student deleted.";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
