package com.sfnotificator.service;

import com.sfnotificator.entity.Homework;

import java.util.List;

public interface HomeworkService {
    List<Homework> getAllHomework();

    Homework getHomeworkById(Long id);

    List<Homework> getHomeworkByStudentName(String studentName);

//    List<Homework> getHomeworkByStudentNameAndCheckedIsFalse(String studentName);

    void saveHomework(Homework homework);

    String deleteHomework(Long id);
}
