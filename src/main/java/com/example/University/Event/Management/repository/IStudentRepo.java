package com.example.University.Event.Management.repository;

import com.example.University.Event.Management.model.Student;
import jdk.jfr.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
public interface IStudentRepo extends CrudRepository<Student,Long> {
}