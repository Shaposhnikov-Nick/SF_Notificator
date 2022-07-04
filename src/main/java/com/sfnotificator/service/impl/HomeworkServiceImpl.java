package com.sfnotificator.service.impl;

import com.sfnotificator.entity.Homework;
import com.sfnotificator.exceptionHandling.NoSuchHomeworkException;
import com.sfnotificator.repository.HomeworkRepository;
import com.sfnotificator.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository repository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository repository) {
        this.repository = repository;
    }

    /**
     * @return
     */
    @Override
    public List<Homework> getAllHomework() {
        return repository.findAll();
    }

    @Override
    public Homework getHomeworkById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchHomeworkException("Homework with id=" + id
                + " is absent"));

    }

    @Override
    public List<Homework> getHomeworkByStudentName(String studentName) {
        List<Homework> homework = repository.findAllByStudentName(studentName);
        if (homework == null)
            throw new NoSuchHomeworkException("Homework of a student named " + studentName
                    + " is absent");

        return homework;
    }

//    @Override
//    public List<Homework> getHomeworkByStudentNameAndCheckedIsFalse(String studentName) {
//        List<Homework> notCheckedHomework = repository.findAllByStudentNameAndCheckedIsFalse(studentName);
//        if (notCheckedHomework == null)
//            throw new NoSuchHomeworkException("Student named " + studentName
//            + " has no unchecked homework");
//
//        return notCheckedHomework;
//    }

    @Override
    public void saveHomework(Homework homework) {
        repository.save(homework);
    }

    @Override
    public String deleteHomework(Long id) {
        repository.deleteById(id);
        return "Homework with id=" + id + " was deleted";
    }
}
