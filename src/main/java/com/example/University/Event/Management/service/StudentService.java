package com.example.University.Event.Management.service;

import com.example.University.Event.Management.model.Department;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private IStudentRepo iStudentRepo;
    public Student addStudent(Student student) {
        return iStudentRepo.save(student);
    }

    public Optional<Student> updateStudentDepartment(@PathVariable Long studentId, @RequestBody Map<String, String> requestBody) {
        Optional<Student> optionalStudent = iStudentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            String department = requestBody.get("department");
            student.setDepartment(Department.valueOf(department));
            iStudentRepo.save(student);
        }
        return optionalStudent;
    }

    public Iterable<Student> getAllStudents() {
        return iStudentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return iStudentRepo.findById(studentId);
    }

    public String deleteStudent(Long studentId) {
        if(iStudentRepo.existsById(studentId)) {
            iStudentRepo.deleteById(studentId);
            return "Student with Id: "+studentId+ " is Deleted";
        }
        return "Student with Id: "+studentId+ " is not found";
    }
}