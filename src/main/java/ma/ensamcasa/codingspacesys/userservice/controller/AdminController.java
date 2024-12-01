package ma.ensamcasa.codingspacesys.userservice.controller;

import ma.ensamcasa.codingspacesys.userservice.dto.LoginDto;
import ma.ensamcasa.codingspacesys.userservice.entity.Student;
import ma.ensamcasa.codingspacesys.userservice.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody LoginDto loginDto) {
        String response = adminService.loginAdmin(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/approve-student/{studentEmail}")
    public ResponseEntity<String> approveStudent(@PathVariable String studentEmail) {
        String response = adminService.approveStudent(studentEmail);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-student/{studentEmail}")
    public ResponseEntity<String> deleteStudent(@PathVariable String studentEmail) {
        String response = adminService.deleteStudent(studentEmail);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> response = adminService.getAllStudents();
        return ResponseEntity.ok(response);
    }
}
