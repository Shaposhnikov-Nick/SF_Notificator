package com.sfnotificator.controller;

import com.sfnotificator.entity.Homework;
import com.sfnotificator.exceptionHandling.NoSuchHomeworkException;
import com.sfnotificator.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeworkController {

    private final HomeworkService service;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.service = homeworkService;
    }

    @GetMapping("/homework")
    public List<Homework> getAllHomework() {
        return service.getAllHomework();
    }

    @GetMapping("/homework/{id}")
    public ResponseEntity<Homework> getHomeworkById(@PathVariable Long id) {
        Homework homework = service.getHomeworkById(id);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @GetMapping("/homework/student/{student_name}")
    public ResponseEntity<List<Homework>> getHomeworkByStudentName(@PathVariable(name = "student_name") String studentName) {
        List<Homework> homework = service.getHomeworkByStudentName(studentName);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

//    @GetMapping("/homework/unchecked/{student_name}")
//    public ResponseEntity<List<Homework>> getHomeworkByStudentNameAndCheckedIsFalse(@PathVariable(name = "student_name") String studentName) {
//        List<Homework> homework = service.getHomeworkByStudentNameAndCheckedIsFalse(studentName);
//        return new ResponseEntity<>(homework, HttpStatus.OK);
//    }

    @PostMapping("/homework")
    public ResponseEntity<Homework> addHomework(@RequestBody Homework homework) {
        service.saveHomework(homework);
        return new ResponseEntity<>(homework, HttpStatus.CREATED);
    }

    @PutMapping("/homework")
    public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework) {
        service.saveHomework(homework);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @DeleteMapping("/homework/{id}")
    public ResponseEntity<String> deleteHomework(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteHomework(id), HttpStatus.OK);
    }
}
