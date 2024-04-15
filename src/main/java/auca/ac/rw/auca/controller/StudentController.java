package auca.ac.rw.auca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.auca.model.Student;
import auca.ac.rw.auca.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;


     @PostMapping(value="/saveStudent", consumes =  MediaType.APPLICATION_JSON_VALUE,
     produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        
        if(student != null){
            String getReturnedMessage = studentService.saveStudent(student);
        if(getReturnedMessage.equalsIgnoreCase("student saved successfully")){
                return new ResponseEntity<> (getReturnedMessage, HttpStatus.CREATED);
        }else if(getReturnedMessage.equalsIgnoreCase("student not saved successfully")){
            return new ResponseEntity<> (getReturnedMessage, HttpStatus.BAD_REQUEST);
        }else if(getReturnedMessage.equalsIgnoreCase("student exist")){
            return new ResponseEntity<> (getReturnedMessage, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<> ("Some thing wrong", HttpStatus.INTERNAL_SERVER_ERROR);  
        }

    }else{
        return new ResponseEntity<> ("Invalid Input", HttpStatus.INTERNAL_SERVER_ERROR);  
    }
}
@GetMapping(
    value = "/getStudentByNames",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<?> getStudentByFirstNameAndLastName(
    @RequestParam String firstName,
    @RequestParam String lastName
  ) {
    Student getStudent = studentService.getStudentByFirstNameAndLastName(
      firstName,
      lastName
    );
    if (getStudent == null) {
      return new ResponseEntity<>(
        "Student with that names is not found",
        HttpStatus.NOT_FOUND
      );
    } else {
      return new ResponseEntity<>(getStudent,HttpStatus.OK);
    }
}
}
