package auca.ac.rw.auca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.auca.model.Student;
import auca.ac.rw.auca.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(Student student) {
        Student getStudent = studentRepository.
        findByFirstNameAndLastNameAndEmail(student.getFirstName()
        , student.getLastName(), student.getEmail());

        if(getStudent == null) {
            Student saveStudent = studentRepository.save(student);
            if(saveStudent != null) {
                return "student saved successfully";
            } else {
                return "student not saved successfully";
            }
        }else{
            return "student exist";  
        }
    }public Student getStudentByFirstNameAndLastName(
        String firstName,
        String lastName
      ) {
        Student getStudentByFirstNameAndLastName = studentRepository.findByFirstNameAndLastName(
          firstName,
          lastName
        );
        if (getStudentByFirstNameAndLastName != null) {
          return getStudentByFirstNameAndLastName;
        } else {
          return null;
        }
      }

       
    }


