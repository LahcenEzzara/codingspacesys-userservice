package ma.ensamcasa.codingspacesys.userservice.controller;

import ma.ensamcasa.codingspacesys.userservice.dto.LoginDto;
import ma.ensamcasa.codingspacesys.userservice.dto.StudentDto;
import ma.ensamcasa.codingspacesys.userservice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDto studentDto) {
        String response = studentService.registerStudent(studentDto.getName(), studentDto.getEmail(), studentDto.getCode(), studentDto.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody LoginDto loginDto) {
        String response = studentService.loginStudent(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(response);
    }
}
