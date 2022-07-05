package com.sfnotificator.controller;

import com.sfnotificator.entity.Homework;
import com.sfnotificator.service.HomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Homework controller")
public class HomeworkController {

    private final HomeworkService service;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.service = homeworkService;
    }

    @GetMapping("/homework")
    @ApiOperation(value = "get all homework")
    public List<Homework> getAllHomework() {
        return service.getAllHomework();
    }

    @GetMapping("/homework/{id}")
    @ApiOperation(value = "get homework by id")
    public ResponseEntity<Homework> getHomeworkById(@PathVariable Long id) {
        Homework homework = service.getHomeworkById(id);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @GetMapping("/homework/student/{student_name}")
    @ApiOperation(value = "get homework by student's name")
    public ResponseEntity<List<Homework>> getHomeworkByStudentName(@PathVariable(name = "student_name") String studentName) {
        List<Homework> homework = service.getHomeworkByStudentName(studentName);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @PostMapping("/homework")
    @ApiOperation(value = "save new homework")
    public ResponseEntity<Homework> addHomework(@RequestBody Homework homework) {
        service.saveHomework(homework);
        return new ResponseEntity<>(homework, HttpStatus.CREATED);
    }

    @PutMapping("/homework")
    @ApiOperation(value = "update homework")
    public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework) {
        service.saveHomework(homework);
        return new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @DeleteMapping("/homework/{id}")
    @ApiOperation(value = "delete homework")
    public ResponseEntity<String> deleteHomework(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteHomework(id), HttpStatus.OK);
    }
}
