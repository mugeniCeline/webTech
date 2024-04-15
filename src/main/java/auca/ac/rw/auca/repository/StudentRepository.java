package auca.ac.rw.auca.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.auca.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,UUID>  {
    
    Student  findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);

    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameLikeIgnoreCase(String firstName);

    }

